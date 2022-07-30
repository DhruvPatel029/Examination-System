<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BoardsterUI Admin</title>
<!-- plugins:css -->
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/adminResources/css/star.css">

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.base.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/vendor.bundle.addons.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/image/favicon.png" />
</head>

<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_navbar.html -->


		<jsp:include page="header.jsp"></jsp:include>



		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_sidebar.html -->



			<jsp:include page="menu.jsp"></jsp:include>



			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row grid-margin">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Add Feedback</h4>

									<f:form class="cmxform" method="post" action="insertRaiting"
										modelAttribute="FeedbackVO">
										<f:hidden path="id" />
										
										<fieldset class="rating mb-2">
											<input type="radio" id="star5" name="rating" value="5" /><label
												class="full" for="star5" title="Awesome - 5 stars"></label>
											<input type="radio" id="star4" name="rating" value="4" /><label
												class="full" for="star4" title="Pretty good - 4 stars"></label>
											<input type="radio" id="star3" name="rating" value="3" /><label
												class="full" for="star3" title="Meh - 3 stars"></label> <input
												type="radio" id="star2" name="rating" value="2" /><label
												class="full" for="star2" title="Kinda bad - 2 stars"></label>
											<input type="radio" id="star1" name="rating" value="1" /><label
												class="full" for="star1" title="Sucks big time - 1 star"></label>
										</fieldset>
										
										<div class="form-group mt-3" style="clear: left;">
											<f:textarea path="feedBack" class="form-control" placeholder="Enter About Your Feedback..."></f:textarea>
										</div>

										<input class="btn btn-primary" type="submit" value="Post">
									
									</f:form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- content-wrapper ends -->
	<!-- partial:../../partials/_footer.html -->



	<jsp:include page="footer.jsp"></jsp:include>

	<!-- container-scroller -->
	<!-- plugins:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.base.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/vendor.bundle.addons.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/template.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
