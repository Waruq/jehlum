<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css" />

</head>

<body>

	<div class="page-loading">
		<img src="${pageContext.servletContext.contextPath}/resources/images/loader.gif" alt="" />
		<span>Skip Loader</span>
	</div>

	<div class="theme-layout" id="scrollup">

		<div class="responsive-header">
			<div class="responsive-menubar">
				<div class="res-logo">
					<a href="/" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a>
				</div>
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
					<a href="/" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a>
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
				<div data-velocity="-.1" style="background: url(${pageContext.servletContext.contextPath}/resources/images/resource/mslider1.jpg) repeat scroll 50% 422.28px transparent;" class="parallax scrolly-invisible no-parallax"></div>
				<!-- PARALLAX BACKGROUND IMAGE -->
				<div class="container fluid">
					<div class="row">
						<div class="col-lg-12">
							<div class="inner-header">
								<h3>Notifications</h3>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>

		<section>
			<div class="block">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<div class="blog-sec">
								
									<div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title open">JK SSB</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												   <c:forEach items="${JKSSB}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>
													

												</div>

											</div>
										</div>
									</div>
								
								    <div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">JKPSC</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${JKPSC}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div>
									
									 <div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">Kashmir University</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${KashmirUniversity}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="http://kashmiruniversity.net/${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div>
									
									 <div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">Central University</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${CentralUniversity}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div>
									
									 <div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">IUST</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${IUST}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div>
									<div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">SSC</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${SSC}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div>
									<div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">Central University Jammu</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${CUJAMMU}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div>
									<div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">Cluster University Jammu</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${CLUJAMMU}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">JKBOPEE</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${JKBOPEE}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">JKBOSE</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${JKBOSE}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">Chenab Valley Power Projects</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${CVPP}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">GCET KASHMIR</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${GCETKASHMIR}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">DPS SRINAGAR</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${DPSSRINAGAR}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">JK BANK</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${JKBANK}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">JK RMSA</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${JKRMSA}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">NIT SRINAGAR</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${NITSRINAGAR}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">SKIMS</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${SKIMS}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">SKUAST</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${SKUAST}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div><div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">SMVDU</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${SMVDU}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									</div>
									<div class="widget border" style="margin-top: 10px;">
										<h3 class="sb-title closed">UPSC</h3>
										<div class="specialism_widget">
											<div class="simple-checkbox">
												<div class="row">
												<c:forEach items="${UPSC}" var="n">
													<div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
														<div class="my-blog">
															<div class="blog-details">
																<p>${n.notificationText} </p>
																<a href="${n.notificationUrl}" title="">Read More <i class="la la-long-arrow-right"></i></a>
															</div>
														</div>
													</div>
													</c:forEach>

												</div>

											</div>
										</div>
									
								</div>
								</div>
						
							<!-- <div class="pagination">
								<ul>
									<li class="prev"><a href="default.htm"><i class="la la-long-arrow-left"></i> Prev</a></li>
									<li><a href="default.htm">1</a></li>
									<li class="active"><a href="default.htm">2</a></li>
									<li><a href="default.htm">3</a></li>
									<li><span class="delimeter">...</span></li>
									<li><a href="default.htm">14</a></li>
									<li class="next"><a href="default.htm">Next <i class="la la-long-arrow-right"></i></a></li>
								</ul>
							</div> -->
							<!-- Pagination -->
						</div>
						
						
					</div>
				</div>
			</div>
		</section>

		<footer>
		
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
	</div>
	<!-- LOGIN POPUP -->

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
	</div>
	<!-- SIGNUP POPUP -->

	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.min.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/modernizr.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/script.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/wow.min.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/slick.min.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/parallax.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/select-chosen.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/isotop.js" type="text/javascript"></script>
	<script src="${pageContext.servletContext.contextPath}/resources/js/jquery.scrollbar.min.js" type="text/javascript"></script>

</body>

</html>
