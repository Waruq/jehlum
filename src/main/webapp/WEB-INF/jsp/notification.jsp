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
		<img src="images/loader.gif" alt="" />
		<span>Skip Loader</span>
	</div>

	<div class="theme-layout" id="scrollup">

		<div class="responsive-header">
			<div class="responsive-menubar">
				<div class="res-logo">
					<a href="index.html" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a>
				</div>
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
					<a href="#" title="" class="post-job-btn"><i class="la la-plus"></i>Post Jobs</a>
					<ul class="account-btns">
					  <li class=""><a href="/logout"><i class="la la-key"></i> Log out</a></li>

					</ul>
				</div>
				<!-- Btn Extras -->
				<form class="res-search">
					<input type="text" placeholder="Job title, keywords or company name" />
					<button type="submit"><i class="la la-search"></i></button>
				</form>
				<div class="responsivemenu">
					<ul>
						<li class="menu-item-has-children">
							<a href="#" title="">Home</a>
							<ul>
								<li><a href="index.html" title="">Home Layout 1</a></li>
								<li><a href="index2.html" title="">Home Layout 2</a></li>
								<li><a href="index3.html" title="">Home Layout 3</a></li>
								<li><a href="index4.html" title="">Home Layout 4</a></li>
								<li><a href="index5.html" title="">Home Layout 5</a></li>
							</ul>
						</li>
						<li class="menu-item-has-children">
							<a href="#" title="">Employers</a>
							<ul>
								<li><a href="employer_list1.html" title=""> Employer List 1</a></li>
								<li><a href="employer_list2.html" title="">Employer List 2</a></li>
								<li><a href="employer_list3.html" title="">Employer List 3</a></li>
								<li><a href="employer_list4.html" title="">Employer List 4</a></li>
								<li><a href="employer_single1.html" title="">Employer Single 1</a></li>
								<li><a href="employer_single2.html" title="">Employer Single 2</a></li>
								<li class="menu-item-has-children">
									<a href="#" title="">Employer Dashboard</a>
									<ul>
										<li><a href="employer_manage_jobs.html" title="">Employer Job Manager</a></li>
										<li><a href="employer_packages.html" title="">Employer Packages</a></li>
										<li><a href="employer_post_new.html" title="">Employer Post New</a></li>
										<li><a href="employer_profile.html" title="">Employer Profile</a></li>
										<li><a href="employer_resume.html" title="">Employer Resume</a></li>
										<li><a href="employer_transactions.html" title="">Employer Transaction</a></li>
										<li><a href="employer_job_alert.html" title="">Employer Job Alert</a></li>
										<li><a href="employer_change_password.html" title="">Employer Change Password</a></li>
									</ul>
								</li>
							</ul>
						</li>
						<li class="menu-item-has-children">
							<a href="#" title="">Candidates</a>
							<ul>
								<li><a href="candidates_list.html" title="">Candidates List 1</a></li>
								<li><a href="candidates_list2.html" title="">Candidates List 2</a></li>
								<li><a href="candidates_list3.html" title="">Candidates List 3</a></li>
								<li><a href="candidates_single.html" title="">Candidates Single 1</a></li>
								<li><a href="candidates_single2.html" title="">Candidates Single 2</a></li>
								<li class="menu-item-has-children">
									<a href="#" title="">Candidates Dashboard</a>
									<ul>
										<li><a href="candidates_my_resume.html" title="">Candidates Resume</a></li>
										<li><a href="candidates_my_resume_add_new.html" title="">Candidates Resume new</a></li>
										<li><a href="candidates_profile.html" title="">Candidates Profile</a></li>
										<li><a href="candidates_shortlist.html" title="">Candidates Shortlist</a></li>
										<li><a href="candidates_job_alert.html" title="">Candidates Job Alert</a></li>
										<li><a href="candidates_dashboard.html" title="">Candidates Dashboard</a></li>
										<li><a href="candidates_cv_cover_letter.html" title="">CV Cover Letter</a></li>
										<li><a href="candidates_change_password.html" title="">Change Password</a></li>
										<li><a href="candidates_applied_jobs.html" title="">Candidates Applied Jobs</a></li>
									</ul>
								</li>
							</ul>
						</li>
						<li class="menu-item-has-children">
							<a href="#" title="">Blog</a>
							<ul>
								<li><a href="blog_list.html"> Blog List 1</a></li>
								<li><a href="blog_list2.html">Blog List 2</a></li>
								<li><a href="blog_list3.html">Blog List 3</a></li>
								<li><a href="blog_single.html">Blog Single</a></li>
							</ul>
						</li>
						<li class="menu-item-has-children">
							<a href="#" title="">Job</a>
							<ul>
								<li><a href="job_list_classic.html">Job List Classic</a></li>
								<li><a href="job_list_grid.html">Job List Grid</a></li>
								<li><a href="job_list_modern.html">Job List Modern</a></li>
								<li><a href="job_single1.html">Job Single 1</a></li>
								<li><a href="job_single2.html">Job Single 2</a></li>
								<li><a href="job-single3.html">Job Single 3</a></li>
							</ul>
						</li>
						<li class="menu-item-has-children">
							<a href="#" title="">Pages</a>
							<ul>
								<li><a href="about.html" title="">About Us</a></li>
								<li><a href="404.html" title="">404 Error</a></li>
								<li><a href="contact.html" title="">Contact Us 1</a></li>
								<li><a href="contact2.html" title="">Contact Us 2</a></li>
								<li><a href="faq.html" title="">FAQ's</a></li>
								<li><a href="how_it_works.html" title="">How it works</a></li>
								<li><a href="login.html" title="">Login</a></li>
								<li><a href="pricing.html" title="">Pricing Plans</a></li>
								<li><a href="register.html" title="">Register</a></li>
								<li><a href="terms_and_condition.html" title="">Terms & Condition</a></li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
		</div>

		<header class="stick-top">
			<div class="menu-sec">
				<div class="container">
					<div class="logo">
						<a href="index.html" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a>
					</div>
					<!-- Logo -->
					<div class="btn-extars">
						<a href="#" title="" class="post-job-btn"><i class="la la-plus"></i>Post Jobs</a>
						<ul class="account-btns">
					  <li class=""><a href="/logout"><i class="la la-key"></i> Log out</a></li>

					</ul>
					</div>
					<!-- Btn Extras -->
					<nav>
						<ul>
							<li class="menu-item-has-children">
								<a href="#" title="">Home</a>
								<ul>
									<li><a href="index.html" title="">Home Layout 1</a></li>
									<li><a href="index2.html" title="">Home Layout 2</a></li>
									<li><a href="index3.html" title="">Home Layout 3</a></li>
									<li><a href="index4.html" title="">Home Layout 4</a></li>
									<li><a href="index5.html" title="">Home Layout 5</a></li>
								</ul>
							</li>
							<li class="menu-item-has-children">
								<a href="#" title="">Employers</a>
								<ul>
									<li><a href="employer_list1.html" title=""> Employer List 1</a></li>
									<li><a href="employer_list2.html" title="">Employer List 2</a></li>
									<li><a href="employer_list3.html" title="">Employer List 3</a></li>
									<li><a href="employer_list4.html" title="">Employer List 4</a></li>
									<li><a href="employer_single1.html" title="">Employer Single 1</a></li>
									<li><a href="employer_single2.html" title="">Employer Single 2</a></li>
									<li class="menu-item-has-children">
										<a href="#" title="">Employer Dashboard</a>
										<ul>
											<li><a href="employer_manage_jobs.html" title="">Employer Job Manager</a></li>
											<li><a href="employer_packages.html" title="">Employer Packages</a></li>
											<li><a href="employer_post_new.html" title="">Employer Post New</a></li>
											<li><a href="employer_profile.html" title="">Employer Profile</a></li>
											<li><a href="employer_resume.html" title="">Employer Resume</a></li>
											<li><a href="employer_transactions.html" title="">Employer Transaction</a></li>
											<li><a href="employer_job_alert.html" title="">Employer Job Alert</a></li>
											<li><a href="employer_change_password.html" title="">Employer Change Password</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li class="menu-item-has-children">
								<a href="#" title="">Candidates</a>
								<ul>
									<li><a href="candidates_list.html" title="">Candidates List 1</a></li>
									<li><a href="candidates_list2.html" title="">Candidates List 2</a></li>
									<li><a href="candidates_list3.html" title="">Candidates List 3</a></li>
									<li><a href="candidates_single.html" title="">Candidates Single 1</a></li>
									<li><a href="candidates_single2.html" title="">Candidates Single 2</a></li>
									<li class="menu-item-has-children">
										<a href="#" title="">Candidates Dashboard</a>
										<ul>
											<li><a href="candidates_my_resume.html" title="">Candidates Resume</a></li>
											<li><a href="candidates_my_resume_add_new.html" title="">Candidates Resume new</a></li>
											<li><a href="candidates_profile.html" title="">Candidates Profile</a></li>
											<li><a href="candidates_shortlist.html" title="">Candidates Shortlist</a></li>
											<li><a href="candidates_job_alert.html" title="">Candidates Job Alert</a></li>
											<li><a href="candidates_dashboard.html" title="">Candidates Dashboard</a></li>
											<li><a href="candidates_cv_cover_letter.html" title="">CV Cover Letter</a></li>
											<li><a href="candidates_change_password.html" title="">Change Password</a></li>
											<li><a href="candidates_applied_jobs.html" title="">Candidates Applied Jobs</a></li>
										</ul>
									</li>
								</ul>
							</li>
							<li class="menu-item-has-children">
								<a href="#" title="">Blog</a>
								<ul>
									<li><a href="blog_list.html"> Blog List 1</a></li>
									<li><a href="blog_list2.html">Blog List 2</a></li>
									<li><a href="blog_list3.html">Blog List 3</a></li>
									<li><a href="blog_single.html">Blog Single</a></li>
								</ul>
							</li>
							<li class="menu-item-has-children">
								<a href="#" title="">Job</a>
								<ul>
									<li><a href="job_list_classic.html">Job List Classic</a></li>
									<li><a href="job_list_grid.html">Job List Grid</a></li>
									<li><a href="job_list_modern.html">Job List Modern</a></li>
									<li><a href="job_single1.html">Job Single 1</a></li>
									<li><a href="job_single2.html">Job Single 2</a></li>
									<li><a href="job-single3.html">Job Single 3</a></li>
								</ul>
							</li>
							<li class="menu-item-has-children">
								<a href="#" title="">Pages</a>
								<ul>
									<li><a href="about.html" title="">About Us</a></li>
									<li><a href="404.html" title="">404 Error</a></li>
									<li><a href="contact.html" title="">Contact Us 1</a></li>
									<li><a href="contact2.html" title="">Contact Us 2</a></li>
									<li><a href="faq.html" title="">FAQ's</a></li>
									<li><a href="how_it_works.html" title="">How it works</a></li>
									<li><a href="login.html" title="">Login</a></li>
									<li><a href="pricing.html" title="">Pricing Plans</a></li>
									<li><a href="register.html" title="">Register</a></li>
									<li><a href="terms_and_condition.html" title="">Terms & Condition</a></li>
								</ul>
							</li>
						</ul>
					</nav>
					<!-- Menus -->
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

								
							</div>
							<div class="pagination">
								<ul>
									<li class="prev"><a href="default.htm"><i class="la la-long-arrow-left"></i> Prev</a></li>
									<li><a href="default.htm">1</a></li>
									<li class="active"><a href="default.htm">2</a></li>
									<li><a href="default.htm">3</a></li>
									<li><span class="delimeter">...</span></li>
									<li><a href="default.htm">14</a></li>
									<li class="next"><a href="default.htm">Next <i class="la la-long-arrow-right"></i></a></li>
								</ul>
							</div>
							<!-- Pagination -->
						</div>
						
						
					</div>
				</div>
			</div>
		</section>

		<footer>
			<div class="block">
				<div class="container">
					<div class="row">
						<div class="col-lg-3 column">
							<div class="widget">
								<div class="about_widget">
									<div class="logo">
										<a href="index.html" title=""><img src="${pageContext.servletContext.contextPath}/resources/images/resource/logo.png" alt="" /></a>
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
								</div>
								<!-- About Widget -->
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
			</div>
			<div class="bottom-line">
				<span>� 2018 jehlum All rights reserved. Design by Waruq</span>
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
