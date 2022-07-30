var jsonObject = [];

$('#insertExamForm').submit(function(){
	swal({
	    title: "Are you sure want to submit?",
	    text: "Only selected answers will be count",
	    icon: "warning",
	    buttons: true,
	    dangerMode: true,
	})
	.then((willSubmit) => {
	    if (willSubmit) {
	    	$('[id^=selectedAns]:checked').each(function(){
	    		let item = {};
	    		item['questionId'] = $(this).parent().find('#question').find('#questionId').val();
	    		item['optionSelected'] = $(this).val();
	    		item['streamType'] = $('#streamId').val();
	    		jsonObject.push(item);
	    	});
	    		
	    	    $.ajax({
	    	        type: "POST",
	    	        url: "submitExam",
	    	        contentType: 'application/json',
	    	        data: JSON.stringify(jsonObject),
	    	        async: false,
	    	        success: function(response) {
	    	        	swal({
	    	                title: 'Congratulations!',
	    	                text: 'You entered '+response+' correct answer',
	    	                icon: 'success',
	    	                button: {
	    	                  text: "Continue",
	    	                  value: true,
	    	                  visible: true,
	    	                  className: "btn btn-primary"
	    	                }
	    	              }).then(function(){
	    	            	  window.location.href = "getResult";
	    	              })
	    	        },
	    	    });
	    } else {
	    	return false;
	    }
	});
	return false;
});
