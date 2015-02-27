<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLOB-Security Learning By Ontology Browsing..</title>
<link rel="shortcut icon" href="Image/nsf.jpg">
<link rel="apple-touch-icon" href="Image/nsf.jpg">


<!-- Scripts for this File -->
<script src="./Script/jquery/jquery-2.1.3.min.js" type="text/javascript"></script>
<script src="./Script/NewFileScript.js" type="text/javascript"></script>


<!-- Scripts for Left Tree View of Class name -->
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
<script src="./Script/jquery/jquery.js" type="text/javascript"></script>
<script src="./Script/jquery/jquery-ui.custom.js" type="text/javascript"></script>
<script src="./Script/jquery/jquery.cookie.js" type="text/javascript"></script>
<script src="./Script/DynamicTree/jquery.dynatree.js"
	type="text/javascript"></script>
<script src="./Script/DynamicTree/DynTree_1.js" type="text/javascript"></script>

<!-- CSS for left Tree View of Class Name -->
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<link href="./Script/DynamicTree//skin/ui.dynatree.css" rel="stylesheet"
	type="text/css">

<!-- CSS for this JSP -->
<link href="./CSS/NewFileStylecss.css" rel="stylesheet" type="text/css">


</head>
<body onload="loadImage()">

	<!-- ------------------------------Header--------------------------- -->
	<div id="idHeader" style="width: 100%; height: 3%;">
		<table border="0" align="center">
			<tr>
				<td align="center"><img alt="" id="image" height="5%" /> <img
					alt="" src="Image/SLOBLogo.JPG" height="35%" width="50%" /></td>
			</tr>
		</table>
	</div>





	<!-- ------------------------------Container--------------------------- -->


	<hr width="100%">
	<div style="width: 100%; height: 2%;">

		<!-- Table for Search Box -->
		<table border="0" width="100%" align="center" height="50%">
			<tr>
				<td align="center"><input id="idSearchText" type="text"
					value=""> <input id="submit" type="submit" value="Search.."></td>
			</tr>

		</table>

	</div>
	<hr width="100%">
	<div style="width: 100%; height: 44%;">

		<!-- Table for Tree view and the description for the selected terms -->
		<table border="0" width="100%" height="100%">
			<tr height="100%">
				<td width="20%"><div id="tree"
						style="height: 500px; width: 100%;"></div></td>
				<td width="80%">

					<div id="idIframe" style="width: 100%; height: 100%">
						<iframe id="idIframeDescription" width="100%" height="100%"
							style="border: none;"></iframe>
					</div>
				</td>
			</tr>

		</table>
	</div>

	<div style="width: 100%; height: 3%;">
		<table width="100%" height="100%" border="0">
			<tr>
				<td align="right" width="45%"><input id="idSearchText1"
					type="text" value="" style="height: 60%"></td>
				<td width="20%"><input id="submit1" type="submit"
					value="Search.." style="height: 60%"></td>
				<td align="right" width="5%"><img alt=""
					src="Image/navigate-up.jpg" id="idUpClick" width="50x"
					height="50px"> <!-- <input type="button"
					value="Click Up" id="idUpClick"> --></td>
				<td width="5%"><img alt="" src="Image/navigate-down.jpg"
					id="idDwnClick" width="50x" height="50px"> <!-- <input type="button" value="Click Down"
					id="idDwnClick"> --></td>
			</tr>
		</table>
	</div>

	<div style="width: 100%; height: 52%;" id="idTrendingData">
		<!-- Table for Trending Articles/Videos/Slides/BookPage -->
		<table border="0" width="100%" height="100%">
			<tr>
				<td width="50%">
					<div id="idArticleList" style="overflow: hidden" class="fancy elem">
						<span class="label"><div style="width: 100%; height: 100%">
								<img alt="" src="Image/trending.png" width="25px" height="25px">
								<b style="font-style: italic"><span
									style='color: grey; font: italic bold 20px/30px Georgia, serif;'>&nbsp;&nbsp;Article...&nbsp;</span><span
									style='color: black; font: italic bold 20px/30px Georgia, serif;'
									id="idSpanArticle"></span></b>
							</div></span> <br> <br> <br>
						<div id="iDProgressBarArticle" align="center">
							<img alt="" src="Image/loading-bar.gif" width="20%" height="20%">
						</div>

						<ul id="idLiArticle">
							<li style="list-style-type: none;"></li>
						</ul>
						<span class="endlabel"><div align="right">
								<a id="idButtonArticle" href="#loginScreen"
									style='color: grey; font: italic bold 15px/20px Georgia, serif;'>Click
									for More</a>
							</div></span>

					</div>
				</td>
				<td width="50%">
					<div id="idVideoList" style="overflow: hidden" class="fancy elem">
						<span class="label"><div style="width: 100%; height: 100%">
								<img alt="" src="Image/trending.png" width="25px" height="25px">
								<b style="font-style: italic"><span
									style='color: grey; font: italic bold 20px/30px Georgia, serif;'>&nbsp;&nbsp;Video...&nbsp;</span><span
									style='color: black; font: italic bold 20px/30px Georgia, serif;'
									id="idSpanVideo"></span></b>
							</div></span><br> <br> <br>
						<div id="iDProgressBarVideo" align="center">
							<img alt="" src="Image/loading-bar.gif" width="20%" height="20%">
						</div>

						<ul id="idLiVideo">
							<li style="list-style-type: none;"></li>
						</ul>
						<span class="endlabel"><div align="right">
								<a id="idButtonVideo" href="#loginScreen"
									style='color: grey; font: italic bold 15px/20px Georgia, serif;'>Click
									for More</a>
							</div></span>

					</div>
				</td>
			</tr>
			<tr>
				<td width="50%">
					<div id="idSlidesList" style="overflow: hidden" class="fancy elem">
						<span class="label"><div style="width: 100%; height: 100%">
								<img alt="" src="Image/trending.png" width="25px" height="25px">
								<b style="font-style: italic"><span
									style='color: grey; font: italic bold 20px/30px Georgia, serif;'>&nbsp;&nbsp;Slides...&nbsp;</span><span
									style='color: black; font: italic bold 20px/30px Georgia, serif;'
									id="idSpanSlides"></span></b>
							</div></span><br> <br> <br>
						<div id="iDProgressBarSlides" align="center">
							<img alt="" src="Image/loading-bar.gif" width="20%" height="20%">
						</div>

						<ul id="idLiSlides">
							<li style="list-style-type: none;"></li>
						</ul>
						<span class="endlabel"><div align="right">
								<a id="idButtonSlides" href="#loginScreen"
									style='color: grey; font: italic bold 15px/20px Georgia, serif;'>Click
									for More</a>
							</div></span>

					</div>
				</td>
				<td width="50%">
					<div id="idBooksList" style="overflow: hidden" class="fancy elem">
						<span class="label">
							<div style="width: 100%; height: 100%">
								<img alt="" src="Image/trending.png" width="25px" height="25px">
								<b style="font-style: italic"> <span
									style='color: grey; font: italic bold 20px/30px Georgia, serif;'>&nbsp;&nbsp;Books...&nbsp;</span>
									<span
									style='color: black; font: italic bold 20px/30px Georgia, serif;'
									id="idSpanBooks"></span>
								</b>
							</div>
						</span> <br> <br> <br>

						<div id="iDProgressBarBooks" align="center">
							<img alt="" src="Image/loading-bar.gif" width="20%" height="20%">
						</div>

						<ul id="content">
							<li style="list-style-type: none;"></li>
						</ul>
						<span class="endlabel"><div align="right">
								<a id="idButtonBooks" href="#loginScreen"
									style='color: grey; font: italic bold 15px/20px Georgia, serif;'>Click
									for More</a>
							</div></span>

					</div>
				</td>
			</tr>
		</table>
	</div>

	<div id="iDProgressBar">
		<img alt="" src="Image/loading-bar.gif" width="100%" height="100%">
	</div>

	<div id="loginScreen">
		<a id="idPopusAnchor" href="#idTrendingData" class="cancel">&times;</a>
		<iframe id="idIframePopUp" width="100%" height="100%" src=""></iframe>
	</div>


	<div id="cover"></div>


	<!-- -------------------------------Footer------------------------------ -->
	<!-- <div id="idFooter" style="width: 100%;height: 2%">
<table border="1" width="100%" height="100%">
			<tr>
				<td></td>
				<td></td>
			</tr>
</table>
</div> -->


</body>
</html>