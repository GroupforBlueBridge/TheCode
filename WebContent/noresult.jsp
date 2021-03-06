
<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@page import="LogAction.LoginAction"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@page import ="java.util.ArrayList" %>

<!DOCTYPE html>
<html lang="en-us">
	<head>
		<meta charset="utf-8">
		<!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->

		<title> URL Management System</title>
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- Use the correct meta names below for your web application
			 Ref: http://davidbcalhoun.com/2010/viewport-metatag 
			 
		<meta name="HandheldFriendly" content="True">
		<meta name="MobileOptimized" content="320">-->
		
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<!-- Basic Styles -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/font-awesome.min.css">

		<!-- SmartAdmin Styles : Please note (smartadmin-production.css) was created using LESS variables -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-production.css">
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-skins.css">

		<!-- SmartAdmin RTL Support is under construction
		<link rel="stylesheet" type="text/css" media="screen" href="css/smartadmin-rtl.css"> -->

		<!-- We recommend you use "your_style.css" to override SmartAdmin
		     specific styles this will also ensure you retrain your customization with each SmartAdmin update.
		<link rel="stylesheet" type="text/css" media="screen" href="css/your_style.css"> -->

		<!-- Demo purpose only: goes with demo.js, you can delete this css when designing your own WebApp -->
		<link rel="stylesheet" type="text/css" media="screen" href="css/demo.css">

		<!-- FAVICONS -->
		<link rel="shortcut icon" href="img/favicon/favicon.ico" type="image/x-icon">
		<link rel="icon" href="img/favicon/favicon.ico" type="image/x-icon">

		<!-- GOOGLE FONT -->
		<!--  <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400italic,700italic,300,400,700">-->
	</head>
<body class="">
		<!-- possible classes: minified, fixed-ribbon, fixed-header, fixed-width-->

		<!-- HEADER -->
		<header id="header">
			<div id="logo-group">

				<!-- PLACE YOUR LOGO HERE -->
				<span id="logo"> <img src="img/url.jpg" alt="SmartAdmin"> </span>
				<!-- END LOGO PLACEHOLDER -->
				<!-- span id="logo"> <img src="img/logo.png" alt="SmartAdmin"> </span> -->
				<!-- END LOGO PLACEHOLDER -->

				<!-- Note: The activity badge color changes when clicked and resets the number to 0
				Suggestion: You may want to set a flag when this happens to tick off all checked messages / notifications -->


				<!-- AJAX-DROPDOWN : control this dropdown height, look and feel from the LESS variable file -->
				<div class="ajax-dropdown">

					<!-- the ID links are fetched via AJAX to the ajax container "ajax-notifications" -->
					

					<!-- notification content -->
					<div class="ajax-notifications custom-scroll">

						<div class="alert alert-transparent">
							<h4>Click a button to show messages here</h4>
							This blank page message helps protect your privacy, or you can show the first message here automatically.
						</div>

						<i class="fa fa-lock fa-4x fa-border"></i>

					</div>
					<!-- end notification content -->

					
					<!-- end footer -->

				</div>
				<!-- END AJAX-DROPDOWN -->
			</div>

<ul>
							<li>
								contact us: 2282550468@qq.com / best.xutao@foxmail.com / 648923307@qq.com
							<a href="help.jsp">or you just want some instruction?</a>
							</li>
						</ul>

			<!-- pulled right: nav area -->
			<div class="pull-right">

				

				<!-- search mobile button (this is hidden till mobile view port) -->
				<div id="search-mobile" class="btn-header transparent pull-right">
					<span> <a href="javascript:void(0)" title="Search"><i class="fa fa-search"></i></a> </span>
				</div>
				<!-- end search mobile button -->

				
				<!-- end input: search field -->
				

			</div>
			<!-- end pulled right: nav area -->

		</header>
		<!-- END HEADER -->

		<!-- Left panel : Navigation area -->
		<!-- Note: This width of the aside area can be adjusted through LESS variables -->
		<aside id="left-panel">

			<!-- User info -->
			<div class="login-info">
				<span> <!-- User image size is adjusted inside CSS, it should stay as it --> 
					
					<a href="javascript:void(0);" id="show-shortcut">
						
						<span>
							<s:property value='email'/> 
						</span>
						<i class="fa fa-angle-down"></i>
					</a> 
					
				</span>
			</div>
			<!-- end user info -->

			<!-- NAVIGATION : This navigation is also responsive

			To make this navigation dynamic please make sure to link the node
			(the reference to the nav > ul) after page load. Or the navigation
			will not initialize.
			-->
			<nav>
				<ul>
					<li>
						<a href='<s:url action="friendinformation"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Home</span></a>
					</li>
						
					<li>
						<a href='<s:url action="Allinformation"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-table"></i> <span class="menu-item-parent">Look Information</span></a>
						
					</li>
					
					<li>
						<a href='<s:url action="friendaccept"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-home"></i> <span class="menu-item-parent">Friend</span></a>
					</li>
					<li>
						<a href='<s:url action="news"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-calendar"></i> <span class="menu-item-parent">News</span></a>
					</li>
					<li>
						<a href='<s:url action="Addhref"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-calendar"></i> <span class="menu-item-parent">Add New Url</span></a>
					</li>
									
					<li>
						<a href='<s:url action="searchref"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-desktop"></i> <span class="menu-item-parent">Search</span></a>
					</li>
					<li>
						<a href='<s:url action="helphref"><s:param name="email" value='email' /></s:url>'><i class="fa fa-lg fa-fw fa-inbox"></i> <span class="menu-item-parent">Help Information</span></a>
					</li>
					
					<li>
						<a href="login.jsp"><i class="fa fa-lg fa-fw fa-pencil-square-o"></i> <span class="menu-item-parent">Logout</span></a>
					</li>
					
				</ul>
			</nav>
			<span class="minifyme"> <i class="fa fa-arrow-circle-left hit"></i> </span>

		</aside>
		<!-- END NAVIGATION -->


		<!-- MAIN PANEL -->
		<div id="main" role="main">

			<!-- RIBBON -->
			<div id="ribbon">

				<span class="ribbon-button-alignment"> <span id="refresh" class="btn btn-ribbon" data-title="refresh"  rel="tooltip" data-placement="bottom" data-original-title="<i class='text-warning fa fa-warning'></i> Warning! This will reset all your widget settings." data-html="true"><i class="fa fa-refresh"></i></span> </span>

				<!-- breadcrumb -->
				<ol class="breadcrumb">
					<li>Home</li><li>Search By Tag</li>
				</ol>
				<!-- end breadcrumb -->

				
			</div>
			<!-- END RIBBON -->
			<!-- MAIN CONTENT -->
			<div id="content">
				
				<!-- widget grid -->
				<section id="widget-grid" class="">
				
				<!-- START ROW -->
				
					<div class="row">
				
						<!-- NEW COL START -->
						<article class="col-sm-12 col-md-12 col-lg-8">
				
							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget" id="wid-id-1" data-widget-colorbutton="false" data-widget-editbutton="false" data-widget-custombutton="false">
								
				
								<!-- widget div-->
								<div>
				
									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
				
									</div>
									<!-- end widget edit box -->
				
									<!-- widget content -->
									<div class="widget-body no-padding">
			
										<s:form action="search" class="smart-form">
											<input name="email" type="hidden" value="<s:property value="email"/>" />
											
				
											<fieldset>
												
												<section>
													<label class="label">Searched Tag</label>
													<label class="input">
														<input type="text" name="tagname" class="input-sm">
													</label>
												</section>
												
												
											
											</fieldset>
																							
											<footer>
													<button type="submit" class="btn btn-primary">
														Submit
													</button>
													<button type="button" class="btn btn-default" onclick="window.history.back();">
														Back
													</button>
											</footer>
										</s:form>
				


									</div>
									<!-- end widget content -->
				
								</div>
								<!-- end widget div -->
				
							</div>
							<!-- end widget -->
				
						</article>
						<article class="col-sm-12 col-md-12 col-lg-10">

							<!-- Widget ID (each widget will need unique ID)-->
							<div class="jarviswidget jarviswidget-color-greenLight" id="wid-id-3" data-widget-editbutton="false">
								
								<header>
									<span class="widget-icon"> <i class="fa fa-table"></i> </span>
									<h2>Search Result</h2>

								</header>		
				
				<!-- widget div-->
								<div>

									<!-- widget edit box -->
									<div class="jarviswidget-editbox">
										<!-- This area used as dropdown edit box -->
									</div>
									<!-- end widget edit box -->

									<!-- widget content -->
									<div class="widget-body no-padding" overflow="auto">

										<table class="table table-bordered">
										 
											<thead>
												<tr>
													<th> Personal Url</th>
													
													<th> Domain</th>
													<th> Delete</th>
													<th> Status</th>
												</tr>
											</thead>
											
											
												
												<tr>
												
												<h1  style="color:red ">No Result</h1>
												</tr>
												
									 		
											
										</table>
										
										
									</div>
									<!-- end widget content -->

								</div>
								<!-- end widget div -->

							</div>
							<!-- end widget -->
					</article>
					</div>
						<!-- END COL -->
						</section>
						
			</div>
	
			<!-- END MAIN CONTENT -->
	
			<!-- End main Panel -->
			<!-- PACE LOADER - turn this on if you want ajax loading to show (caution: uses lots of memory on iDevices)-->
		<script data-pace-options='{ "restartOnRequestAfter": true }' src="js/plugin/pace/pace.min.js"></script>

		<!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
		
		<script>
			if (!window.jQuery) {
				document.write('<script src="js/libs/jquery-2.0.2.min.js"><\/script>');
			}
		</script>

		
		<script>
			if (!window.jQuery.ui) {
				document.write('<script src="js/libs/jquery-ui-1.10.3.min.js"><\/script>');
			}
		</script>


		<!-- MAIN APP JS FILE -->
		<script src="js/app.js"></script>

		<!-- PAGE RELATED PLUGIN(S) 
		<script src="..."></script>-->

		

		<script type="text/javascript">
		
		// DO NOT REMOVE : GLOBAL FUNCTIONS!
		
		$(document).ready(function() {
			
			pageSetUp();
		
		})

		</script>

		<!-- Your GOOGLE ANALYTICS CODE Below -->
		<script type="text/javascript">
			var _gaq = _gaq || [];
				_gaq.push(['_setAccount', 'UA-XXXXXXXX-X']);
				_gaq.push(['_trackPageview']);
			
			(function() {
				var ga = document.createElement('script');
				ga.type = 'text/javascript';
				ga.async = true;
				ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
				var s = document.getElementsByTagName('script')[0];
				s.parentNode.insertBefore(ga, s);
			})();

		</script>

</body>
</html>