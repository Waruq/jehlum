<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<aside class="col-lg-3 column border-right">
				 		<div class="widget">
				 			<div class="tree_widget-sec">
				 				<ul>
<%-- 				 				<li><a href="${pageContext.servletContext.contextPath}/displayNotification" title="">View Notifications</a></li>
 --%>				 					<li >
				 						<a href="${pageContext.servletContext.contextPath}/displayNotification" title=""><i class="la la-file-text"></i>Notifications</a>
				 						<ul>
				 							
				 							
				 						</ul>
				 					</li>
				 					<li >
				 						<a href="${pageContext.servletContext.contextPath}/viewAllJobs" title=""><i class="la la-briefcase"></i>Manage Jobs</a>
				 						<ul>
<%-- 				 							<li><a href="${pageContext.servletContext.contextPath}/viewAllJobs" title="">View My Jobs</a></li> --%>
				 							<!-- <li><a href="#" title="">Social Network</a></li>
				 							<li><a href="#" title="">Contact Information</a></li> -->
				 						</ul>
				 					</li>
				 					<li class="inner-child">
				 						<a href="#" title=""><i class="la la-money"></i>Transactions</a>
				 						<ul>
				 							<li><a href="#" title="">My Profile</a></li>
				 							<li><a href="#" title="">Social Network</a></li>
				 							<li><a href="#" title="">Contact Information</a></li>
				 						</ul>
				 					</li>
				 					<li class="inner-child">
				 						<a href="#" title=""><i class="la la-paper-plane"></i>Resumes</a>
				 						<ul>
				 							<li><a href="#" title="">My Profile</a></li>
				 							<li><a href="#" title="">Social Network</a></li>
				 							<li><a href="#" title="">Contact Information</a></li>
				 						</ul>
				 					</li>
				 					<li class="inner-child">
				 						<a href="#" title=""><i class="la la-user"></i>Packages</a>
				 						<ul>
				 							<li><a href="#" title="">My Profile</a></li>
				 							<li><a href="#" title="">Social Network</a></li>
				 							<li><a href="#" title="">Contact Information</a></li>
				 						</ul>
				 					</li>
				 					<li class="inner-child">
				 					 <c:url value="/createAdd" var="createadd"></c:url>
				 						<a href="${createadd}" title=""><i class="la la-file-text"></i>Post a New Job</a>
<!-- 				 						<ul> -->
<!-- 				 							<li><a href="#" title="">My Profile</a></li> -->
<!-- 				 							<li><a href="#" title="">Social Network</a></li> -->
<!-- 				 							<li><a href="#" title="">Contact Information</a></li> -->
<!-- 				 						</ul> -->
				 					</li>
				 					<li class="inner-child">
				 						<a href="#" title=""><i class="la la-flash"></i>Job Alerts</a>
				 						<ul>
				 							<li><a href="#" title="">My Profile</a></li>
				 							<li><a href="#" title="">Social Network</a></li>
				 							<li><a href="#" title="">Contact Information</a></li>
				 						</ul>
				 					</li>
				 					<li class="inner-child"> 
				 						<a href="#" title=""><i class="la la-lock"></i>Change Password</a>
				 						<ul>
				 							<li><a href="#" title="">My Profile</a></li>
				 							<li><a href="#" title="">Social Network</a></li>
				 							<li><a href="#" title="">Contact Information</a></li>
				 						</ul>
				 					</li>
				 					<li><a href="${pageContext.servletContext.contextPath}/logout" title=""><i class="la la-unlink"></i>Logout</a></li>
				 				</ul>
				 			</div>
				 		</div>
				 	</aside>