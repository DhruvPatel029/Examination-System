
<!DOCTYPE html>
<html lang="en">
<head>
<title>Career Guidance | Register
	Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/font-awesome.min.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/payloan-icon.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/icofont.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/animate.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/settings.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/slick.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/owl.theme.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/owl.carousel.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/preset.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/theme.css" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/userResources/css/responsive.css" />

<link rel="icon" type="image/png"
	href="<%=request.getContextPath()%>/userResources/image/favicon.png">
</head>
<body>
	<section class="payloan_header_bg header_bg_1" style="padding: 0px">
		<div class="container">
			<div class="row align-items-center">
				<div class="col-lg-4">
					<h4>Register</h4>
					<h6 class="font-weight-light">Signing up is easy. It only
						takes a few steps</h6>

					<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>


					<f:form class="pt-3" modelAttribute="RegisterVO"
						action="insertRegister" method="post">
						<div class="form-group">
							<f:input path="firstName" class="form-control form-control-lg"
								placeholder="First Name" required="required" />
						</div>
						<div class="form-group">
							<f:input path="lastName" class="form-control form-control-lg"
								placeholder="Last Name" required="required" />
						</div>
						<div class="form-group">
							Gender
							<f:radiobutton path="gender" value="male" />
							<label for="male">Male</label>
							<f:radiobutton path="gender" value="female" />
							<label for="female">Female </label><br>
						</div>
						<div class="form-group">
							<f:input path="loginVO.username"
								class="form-control form-control-lg" placeholder="Email"
								required="required" />
						</div>
						<div class="form-group">
							<f:input path="mobileNo" class="form-control form-control-lg"
								placeholder="Mobile No" required="required" />
						</div>
						<div class="form-group">
							Date Of Birth
							<f:input path="dob" class="form-control form-control-lg"
								required="required" />
						</div>
						<div class="form-group">
							Address
							<f:textarea rows="3" cols="3" path="address"
								class="form-control form-control-lg" required="required" />
						</div>
						<div class="mt-3">
							<input type="submit" value="SIGN UP"
								class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn">
						</div>
						<div class="text-center mt-4 font-weight-light">
							Already have an account? <a href="login.html"
								class="text-primary">Login</a>
						</div>
					</f:form>
				</div>
				<div class="col-lg-6">
					<%-- <div class="header_img">
						<img
							src="<%=request.getContextPath()%>/userResources/image/slider/2.png"
							alt="">
					</div>
		 --%>
				</div>
			</div>
		</div>
	</section>




	<script data-cfasync="false"
		src="<%=request.getContextPath()%>/userResources/js/email-decode.min.js"></script>
	<script src="<%=request.getContextPath()%>/userResources/js/jquery.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/bootstrap.min.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/modernizr.custom.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery.themepunch.revolution.min.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery.themepunch.tools.min.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/jquery-ui.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script src="<%=request.getContextPath()%>/userResources/js/shuffle.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script src="<%=request.getContextPath()%>/userResources/js/slick.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script src="<%=request.getContextPath()%>/userResources/js/gmaps.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="https://maps.google.com/maps/api/js?key=AIzaSyCysDHE3s4Qw3nTh9o58-2mJcqvR6HV8Kk"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="<%=request.getContextPath()%>/userResources/js/owl.carousel.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script src="<%=request.getContextPath()%>/userResources/js/theme.js"
		type="cc7d8e13936e725475f54289-text/javascript"></script>
	<script
		src="https://ajax.cloudflare.com/cdn-cgi/scripts/7089c43e/cloudflare-static/rocket-loader.min.js"
		data-cf-settings="cc7d8e13936e725475f54289-|49" defer=""></script>
</body>
</html>