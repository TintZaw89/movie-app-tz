<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="components/video_modal.css"
	media="screen" />
<title>Streaming Video</title>
<%@include file="components/allCss.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="components/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="card">
					<div class="card-body">
						<h2>Video</h2>
						<!--  <input type="file" accept="file:///C:/Users/WCT/Desktop/*"/>-->
						<!-- <embed src="video/bf3vu.mp4" autostart="false" showcontrols="true" ShowStatusBar="true" width="1080" height="720"></embed> -->
						<div id="videoDiv" >
							<video controls autoplay id="video1"
								class="video-js vjs-default-skin" width="1080" height="720"
								src="video/bf3vu3.mp4" type='video/mp4' /></video>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>