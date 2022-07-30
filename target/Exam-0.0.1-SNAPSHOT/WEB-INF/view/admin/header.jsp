
<%@page import="com.project.utils.Basemethods"%>
<nav class="navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
	<div
		class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
		<a class="navbar-brand brand-logo" href="index.html"><img
			src="<%=request.getContextPath()%>/adminResources/image/logo.svg"
			alt="logo" /></a> <a class="navbar-brand brand-logo-mini"
			href="index.html"><img
			src="<%=request.getContextPath()%>/adminResources/image/logo-mini.svg"
			alt="logo" /></a>
	</div>
	<div
		class="navbar-menu-wrapper d-flex align-items-center justify-content-end justify-content-lg-start">
		<button class="navbar-toggler navbar-toggler align-self-center"
			type="button" data-toggle="minimize">
			<span class="mdi mdi-menu"></span>
		</button>

		<ul class="navbar-nav navbar-nav-right">
			<li class="nav-item nav-profile dropdown"><a
				class="nav-link dropdown-toggle" href="#" data-toggle="dropdown"
				id="profileDropdown"> <img
					src="<%=request.getContextPath()%>/adminResources/image/face5.jpg"
					alt="profile" /> <span class="nav-profile-name"><%=Basemethods.getUser()%></span>
			</a>
				<div class="dropdown-menu dropdown-menu-right navbar-dropdown"
					aria-labelledby="profileDropdown">
					<a class="dropdown-item"> <i class="mdi mdi-account menu-icon"></i>
						Profile
					</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="/logout"> <i
						class="mdi mdi-logout text-primary"></i> Logout
					</a>
				</div></li>

		</ul>
	</div>
</nav>
