<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<img src="${pageContext.servletContext.contextPath}/resources/images/loader.gif" alt="" />
	<span>Skip Loader</span>
</div>

<div class="theme-layout" id="scrollup">
	
	<div class="responsive-header">
		<div class="responsive-menubar">
			<div class="res-logo"><a href="${pageContext.servletContext.contextPath}/" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a></div>
			<div class="menu-resaction">
				<div class="res-openmenu">
					<img src="${pageContext.servletContext.contextPath}/resources/images/icon.png" alt="" /> Menu
				</div>
				<div class="res-closemenu">
					<img src="${pageContext.servletContext.contextPath}/resources/images/icon2.png" alt="" /> Close
				</div>
			</div>
		</div>
		<div class="responsive-opensec">
			<div class="btn-extars">
			    <c:url value="/createAdd" var="createadd"></c:url>
				<a href="${createadd}" title="" class="post-job-btn"><i class="la la-plus"></i>Post Jobs</a>
				<ul class="account-btns">
					<li class=""><a href="/logout"><i class="la la-key"></i> Log out</a></li>
					
				</ul>
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
					<a href="index.html" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a>
				</div><!-- Logo -->
				<div class="btn-extars">
					  <c:url value="/createAdd" var="createadd"></c:url>
				<a href="${createadd}" title="" class="post-job-btn"><i class="la la-plus"></i>Post Jobs</a>
					<ul class="account-btns">
						<li class=""><a href="/logout"><i class="la la-key"></i> Log out</a></li>
<!-- 						<li class="signin-popup"><a title=""><i class="la la-external-link-square"></i> Login</a></li>
 -->					</ul>
				</div><!-- Btn Extras -->
				
			</div>
		</div>
	</header>

	<section class="overlape">
		<div class="block no-padding">
			<div data-velocity="-.1" style="background: url(${pageContext.servletContext.contextPath}/resources/images/resource/mslider1.jpg) repeat scroll 50% 422.28px transparent;" class="parallax scrolly-invisible no-parallax"></div><!-- PARALLAX BACKGROUND IMAGE -->
			<div class="container fluid">
				<div class="row">
					<div class="col-lg-12">
						<div class="inner-header">
							<h3>Welcome <sec:authorize access="isAuthenticated()">
							    <sec:authentication property="principal.username" /> 
							</sec:authorize></h3>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<section>
		<div class="block no-padding">
			<div class="container">
				 <div class="row no-gape">
				 	<jsp:include page="menu.jsp"></jsp:include>
				 	<div class="col-lg-9 column">
				 		<div class="padding-left">
					 		<div class="manage-jobs-sec">
					 			<h3>Manage Jobs</h3>
					 			<div class="extra-job-info">
						 			<span><i class="la la-clock-o"></i><strong>${fn:length(adds)}</strong> Job Posted</span>
						 			<span><i class="la la-file-text"></i><strong>20</strong> Application</span>
						 			<span><i class="la la-users"></i><strong>18</strong> Active Jobs</span>
						 		</div>
						 		<table>
						 			<thead>
						 				<tr>
						 					<td>Title</td>
						 					<td>Applications</td>
						 					<td>Created</td>
						 					<td>Status</td>
						 					<td>Action</td>
						 				</tr>
						 			</thead>
						 			<tbody>
						 			  <c:forEach items="${adds}" var="add">
						 				<tr>
						 					<td>
						 						<div class="table-list-title">
						 							<h3><a href="#" title="">${add.addtitle }</a></h3>
						 						</div>
						 					</td>
						 					<td>
						 						<span class="applied-field">3+ Applied</span>
						 					</td>
						 					<td>
						 						<span>${add.postTime}</span>
						 					</td>
						 					<td>
						 						<span class="status active">Active</span>
						 					</td>
						 					<td>
						 						<ul class="action_job">
						 							<li><span>View Job</span><a href="${pageContext.servletContext.contextPath}/viewAdd/${add.id}" title=""><i class="la la-eye"></i></a></li>
						 							<li><span>Edit</span><a href="#" title=""><i class="la la-pencil"></i></a></li>
						 							<li><span>Delete</span><a href="${pageContext.servletContext.contextPath}/delete/${add.id}" title=""><i class="la la-trash-o"></i></a></li>
						 						</ul>
						 					</td>
						 				</tr>
						 				</c:forEach>
						 				

						 			</tbody>
						 		</table>
					 		</div>
					 	</div>
					</div>
				 </div>
			</div>
		</div>
	</section>

	<footer>
		<%-- <div class="block">
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
								<span>info@jehlum.com</span>
								<div class="social">
									<a href="#" title=""><i class="fa fa-facebook"></i></a>
									<a href="#" title=""><i class="fa fa-twitter"></i></a>
									<a href="#" title=""><i class="fa fa-linkedin"></i></a>
									<a href="#" title=""><i class="fa fa-pinterest"></i></a>
									<a href="#" title=""><i class="fa fa-behance"></i></a>
								</div>
							</div><!-- About Widget -->
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
								<a href="#" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/dw1.png" alt="" /></a>
								<a href="#" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/dw2.png" alt="" /></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div> --%>
		<div class="bottom-line">
			<span>© 2018 jehlum All rights reserved. Design by Waruq</span>
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

