<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Job Hunt</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="">
	<meta name="keywords" content="">
	<meta name="author" content="CreativeLayers">

	<!-- Styles -->
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap-grid.css" />
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/icons.css">
	<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/resources/css/animate.min.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/style.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/responsive.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/chosen.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/colors/colors.css" />
	<link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/resources/css/bootstrap.css" />
<link rel="stylesheet" href="../../../https@maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" />
	
</head>
<body>

<div class="page-loading">
	<img src="images/loader.gif" alt="" />
	<span>Skip Loader</span>
</div>

<div class="theme-layout" id="scrollup">
	
	<div class="responsive-header">
		<div class="responsive-menubar">
			<div class="res-logo"><a href="${pageContext.servletContext.contextPath}/" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a></div>
			<div class="menu-resaction">
				<div class="res-openmenu">
					<img src="images/icon.png" alt="" /> Menu
				</div>
				<div class="res-closemenu">
					<img src="images/icon2.png" alt="" /> Close
				</div>
			</div>
		</div>
		<div class="responsive-opensec">
			<div class="btn-extars">
			    <c:url value="/createAdd" var="createadd"></c:url>
				<a href="${createadd}" title="" class="post-job-btn"><i class="la la-plus"></i>Post Jobs</a>
				
			</div><!-- Btn Extras -->
			<form class="res-search">
				<input type="text" placeholder="Job title, keywords or company name" />
				<button type="submit"><i class="la la-search"></i></button>
			</form>
		
		</div>
	</div>
	
	<header class="stick-top">
		<div class="menu-sec">
			<div class="container">
				<div class="logo">
					<a href="index.html" title=""><img src="images/resource/logo.png" alt="" /></a>
				</div><!-- Logo -->
				<div class="btn-extars">
					  <c:url value="/createAdd" var="createadd"></c:url>
				<a href="${createadd}" title="" class="post-job-btn"><i class="la la-plus"></i>Post Jobs</a>
					<ul class="account-btns">
						<li class=""><a href="/logout"><i class="la la-key"></i> Log out</a></li>
<!-- 						<li class="signin-popup"><a title=""><i class="la la-external-link-square"></i> Login</a></li>
 -->					</ul>
				</div>
				
			</div>
		</div>
	</header>

	<section class="overlape">
		<div class="block no-padding">
			<div data-velocity="-.1" style="background: url(images/resource/mslider1.jpg) repeat scroll 50% 422.28px transparent;" class="parallax scrolly-invisible no-parallax"></div><!-- PARALLAX BACKGROUND IMAGE -->
			<div class="container fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="inner-header">
							<h3>${add.addtitle}</h3>
							<div class="job-statistic">
								<span>FULL TIME</span>
								<p><i class="la la-map-marker"></i> Ajax, Ontario</p>
								<p><i class="la la-calendar-o"></i>${add.getPostTimeinMonths()} Months Ago</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section>
		<div class="block">
			<div class="container">
				<jsp:include page="menu.jsp"></jsp:include>
				<div class="row">
				 	<div class="col-lg-8 column">
				 		<div class="job-single-sec">
				 			<div class="job-single-head">
				 				<div class="job-thumb"> <img src="${add.files[0]}" alt="" /> </div>
				 				<div class="job-head-info">
				 					<h4>${add.addtitle}</h4>
				 					<span>${add.category }</span>
				 					<p><i class="la la-unlink"></i> www.jehlum.com</p>
				 					<p><i class="la la-phone"></i> +90 538 963 54 87</p>
				 					<p><i class="la la-envelope-o"></i> ali.tufan@jehlum.com</p>
				 				</div>
				 			</div><!-- Job Head -->
				 			<div class="job-details">
				 				<h3>Job Description</h3>
				 				<p>${add.description}</p>
				 				<h3>Required Knowledge, Skills, and Abilities</h3>
				 				<ul>
				 					<li>Ability to write code – HTML & CSS (SCSS flavor of SASS preferred when writing CSS)</li>
				 					<li>Proficient in Photoshop, Illustrator, bonus points for familiarity with Sketch (Sketch is our preferred concepting)</li>
				 					<li>Cross-browser and platform testing as standard practice</li>
				 					<li>Experience using Invision a plus</li>
				 					<li>Experience in video production a plus or, at a minimum, a willingness to learn</li>
				 				</ul>
				 				<h3>Education + Experience</h3>
				 				<ul>
				 					<li>Advanced degree or equivalent experience in graphic and web design</li>
				 					<li>3 or more years of professional design experience</li>
				 					<li>Direct response email experience</li>
				 					<li>Ecommerce website design experience</li>
				 					<li>Familiarity with mobile and web apps preferred</li>
				 					<li>Excellent communication skills, most notably a demonstrated ability to solicit and address creative and design feedback</li>
				 					<li>Must be able to work under pressure and meet deadlines while maintaining a positive attitude and providing exemplary customer service</li>
				 					<li>Ability to work independently and to carry out assignments to completion within parameters of instructions given, prescribed routines, and standard accepted practices</li>
				 				</ul>
				 			</div>
				 			<div class="share-bar">
				 				<span>Share</span><a href="#" title="" class="share-fb"><i class="fa fa-facebook"></i></a><a href="#" title="" class="share-twitter"><i class="fa fa-twitter"></i></a>
				 			</div>
				 			<!-- <div class="recent-jobs">
				 				<h3>Recent Jobs</h3>
				 				<div class="job-list-modern">
								 	<div class="job-listings-sec no-border">
										<div class="job-listing wtabs">
											<div class="job-title-sec">
												<div class="c-logo"> <img src="images/resource/l1.png" alt="" /> </div>
												<h3><a href="#" title="">Web Designer / Developer</a></h3>
												<span>Massimo Artemisis</span>
												<div class="job-lctn"><i class="la la-map-marker"></i>Sacramento, California</div>
											</div>
											<div class="job-style-bx">
												<span class="job-is ft">Full time</span>
												<span class="fav-job"><i class="la la-heart-o"></i></span>
												<i>5 months ago</i>
											</div>
										</div>
										<div class="job-listing wtabs">
											<div class="job-title-sec">
												<div class="c-logo"> <img src="images/resource/l2.png" alt="" /> </div>
												<h3><a href="#" title="">C Developer (Senior) C .Net</a></h3>
												<span>Massimo Artemisis</span>
												<div class="job-lctn"><i class="la la-map-marker"></i>Sacramento, California</div>
											</div>
											<div class="job-style-bx">
												<span class="job-is pt ">Part time</span>
												<span class="fav-job"><i class="la la-heart-o"></i></span>
												<i>5 months ago</i>
											</div>
										</div>Job
										<div class="job-listing wtabs">
											<div class="job-title-sec">
												<div class="c-logo"> <img src="images/resource/l3.png" alt="" /> </div>
												<h3><a href="#" title="">Regional Sales Manager South</a></h3>
												<span>Massimo Artemisis</span>
												<div class="job-lctn"><i class="la la-map-marker"></i>Sacramento, California</div>
											</div>
											<div class="job-style-bx">
												<span class="job-is ft ">Full time</span>
												<span class="fav-job"><i class="la la-heart-o"></i></span>
												<i>5 months ago</i>
											</div>
										</div>Job
										<div class="job-listing wtabs">
											<div class="job-title-sec">
												<div class="c-logo"> <img src="images/resource/l4.png" alt="" /> </div>
												<h3><a href="#" title="">Marketing Dairector</a></h3>
												<span>Massimo Artemisis</span>
												<div class="job-lctn"><i class="la la-map-marker"></i>Sacramento, California</div>
											</div>
											<div class="job-style-bx">
												<span class="job-is ft ">Full time</span>
												<span class="fav-job"><i class="la la-heart-o"></i></span>
												<i>5 months ago</i>
											</div>
										</div>Job
									</div>
								 </div>
				 			</div> -->
				 		</div>
				 	</div>
				 	<div class="col-lg-4 column">
				 		<a class="apply-thisjob" href="#" title=""><i class="la la-paper-plane"></i>Apply for job</a>
				 		<div class="apply-alternative">
				 			<a href="#" title=""><i class="fa fa-linkedin"></i> Apply with Linkedin</a>
				 			<span><i class="la la-heart-o"></i> Shortlist</span>
				 		</div>
				 		<!-- <div class="job-overview">
				 			<h3>Job Overview</h3>
				 			<ul>
				 				<li><i class="la la-money"></i><h3>Offerd Salary</h3><span>£15,000 - £20,000</span></li>
				 				<li><i class="la la-mars-double"></i><h3>Gender</h3><span>Female</span></li>
				 				<li><i class="la la-thumb-tack"></i><h3>Career Level</h3><span>Executive</span></li>
				 				<li><i class="la la-puzzle-piece"></i><h3>Industry</h3><span>Management</span></li>
				 				<li><i class="la la-shield"></i><h3>Experience</h3><span>2 Years</span></li>
				 				<li><i class="la la-line-chart "></i><h3>Qualification</h3><span>Bachelor Degree</span></li>
				 			</ul>
				 		</div> --><!-- Job Overview -->
				 		<div class="job-location">
				 			<h3>Job Location</h3>
				 			<div class="job-lctn-map">
				 				<iframe src="../../../https@www.google.com/maps/embed@pb=!1m18!1m12!1m3!1d926917.0482572999!2d-104.57738594649922!3d40.26036964524562!2m3!1f0!2f0!3f0!3m2!1i10208A7BF844D"></iframe>
				 			</div>
				 		</div>
				 		<div class="extra-job-info">
				 			<span><i class="la la-clock-o"></i><strong>${add.getPostTimeinDays()}</strong> Days</span>
				 			<!-- <span><i class="la la-search-plus"></i><strong>35697</strong> Displayed</span>
				 			<span><i class="la la-file-text"></i><strong>300-500</strong> Application</span> -->
				 		</div>
				 	</div>
				</div>
			</div>
		</div>
	</section>

	<footer>
		<!-- <div class="block">
			<div class="container">
				<div class="row">
					<div class="col-lg-3 column">
						<div class="widget">
							<div class="about_widget">
								<div class="logo">
									<a href="index.html" title=""><img src="images/resource/logo.png" alt="" /></a>
								</div>
								<span>Collin Street West, Victor 8007, Australia.</span>
								<span>+1 246-345-0695</span>
								<span>info@jobhunt.com</span>
								<div class="social">
									<a href="#" title=""><i class="fa fa-facebook"></i></a>
									<a href="#" title=""><i class="fa fa-twitter"></i></a>
									<a href="#" title=""><i class="fa fa-linkedin"></i></a>
									<a href="#" title=""><i class="fa fa-pinterest"></i></a>
									<a href="#" title=""><i class="fa fa-behance"></i></a>
								</div>
							</div>About Widget
						</div>
					</div>
					<div class="col-lg-4 column">
						<div class="widget">
							<h3 class="footer-title">Frequently Asked Questions</h3>
							<div class="link_widgets">
								<div class="row">
									<div class="col-lg-6">
										<a href="#" title="">Privacy & Seurty </a>
										<a href="#" title="">Terms of Serice</a>
										<a href="#" title="">Communications </a>
										<a href="#" title="">Referral Terms </a>
										<a href="#" title="">Lending Licnses </a>
										<a href="#" title="">Disclaimers </a>	
									</div>
									<div class="col-lg-6">
										<a href="#" title="">Support </a>
										<a href="#" title="">How It Works </a>
										<a href="#" title="">For Employers </a>
										<a href="#" title="">Underwriting </a>
										<a href="#" title="">Contact Us</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-2 column">
						<div class="widget">
							<h3 class="footer-title">Find Jobs</h3>
							<div class="link_widgets">
								<div class="row">
									<div class="col-lg-12">
										<a href="#" title="">US Jobs</a>	
										<a href="#" title="">Canada Jobs</a>	
										<a href="#" title="">UK Jobs</a>	
										<a href="#" title="">Emplois en Fnce</a>	
										<a href="#" title="">Jobs in Deuts</a>	
										<a href="#" title="">Vacatures China</a>	
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-lg-3 column">
						<div class="widget">
							<div class="download_widget">
								<a href="#" title=""><img src="images/resource/dw1.png" alt="" /></a>
								<a href="#" title=""><img src="images/resource/dw2.png" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> -->
		<div class="bottom-line">
			<span>© 2018 Jobhunt All rights reserved. Design by Creative Layers</span>
			<a href="#scrollup" class="scrollup" title=""><i class="la la-arrow-up"></i></a>
		</div>
	</footer>

</div>

<div class="account-popup-area signin-popup-box">
	<div class="account-popup">
		<span class="close-popup"><i class="la la-close"></i></span>
		<h3>User Login</h3>
		<span>Click To Login With Demo User</span>
		<div class="select-user">
			<span>Candidate</span>
			<span>Employer</span>
		</div>
		<form>
			<div class="cfield">
				<input type="text" placeholder="Username" />
				<i class="la la-user"></i>
			</div>
			<div class="cfield">
				<input type="password" placeholder="********" />
				<i class="la la-key"></i>
			</div>
			<p class="remember-label">
				<input type="checkbox" name="cb" id="cb1"><label for="cb1">Remember me</label>
			</p>
			<a href="#" title="">Forgot Password?</a>
			<button type="submit">Login</button>
		</form>
		<div class="extra-login">
			<span>Or</span>
			<div class="login-social">
				<a class="fb-login" href="#" title=""><i class="fa fa-facebook"></i></a>
				<a class="tw-login" href="#" title=""><i class="fa fa-twitter"></i></a>
			</div>
		</div>
	</div>
</div><!-- LOGIN POPUP -->

<div class="account-popup-area signup-popup-box">
	<div class="account-popup">
		<span class="close-popup"><i class="la la-close"></i></span>
		<h3>Sign Up</h3>
		<div class="select-user">
			<span>Candidate</span>
			<span>Employer</span>
		</div>
		<form>
			<div class="cfield">
				<input type="text" placeholder="Username" />
				<i class="la la-user"></i>
			</div>
			<div class="cfield">
				<input type="password" placeholder="********" />
				<i class="la la-key"></i>
			</div>
			<div class="cfield">
				<input type="text" placeholder="Email" />
				<i class="la la-envelope-o"></i>
			</div>
			<div class="dropdown-field">
				<select data-placeholder="Please Select Specialism" class="chosen">
					<option>Web Development</option>
					<option>Web Designing</option>
					<option>Art & Culture</option>
					<option>Reading & Writing</option>
				</select>
			</div>
			<div class="cfield">
				<input type="text" placeholder="Phone Number" />
				<i class="la la-phone"></i>
			</div>
			<button type="submit">Signup</button>
		</form>
		<div class="extra-login">
			<span>Or</span>
			<div class="login-social">
				<a class="fb-login" href="#" title=""><i class="fa fa-facebook"></i></a>
				<a class="tw-login" href="#" title=""><i class="fa fa-twitter"></i></a>
			</div>
		</div>
	</div>
</div><!-- SIGNUP POPUP -->

<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/modernizr.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/script.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/wow.min.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/slick.min.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/parallax.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/select-chosen.js" type="text/javascript"></script>
<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollbar.min.js" type="text/javascript"></script>

</body>
</html>

