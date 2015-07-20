<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ankur Taunk..</title>

<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script> 
<script type="text/javascript" src="./UTILITY/Script/index.js"></script>  
  
<link rel="stylesheet"	href="./UTILITY/CSS/HorizontalMenuBar.css">
<link rel="stylesheet"	href="./UTILITY/CSS/GridLayout.css">
<link rel="stylesheet"	href="./UTILITY/CSS/PopUpWindow.css">
</head>
<body onload="loadImage()" >

<!-- Header Logic -->
<div style=" height:15vh" >
<table border="0" width="100%" height="100%">
<tr>
<td width="9%" ><img  id="" alt="" src="Image/TickTock.gif" width="100%" ></td>
<td width="91%" align="center" >
<table border="0" width="100%" height="100%">
<tr>
<td>
<table>
<tr>
<td width="80%"><h4 class="heading" align="center">"Visualize the Future and Encash it in Present" -- Ankur Taunk</h4></td>
<td width="10%"><a href="Document/Ankur_Taunk_Resume.pdf" target="_blank" style="text-decoration: none">
        <img src="Image/PDFLogo.png" style="border: 0; float: none; "  width="30%" height="8%"  /> 
        <span>Resume</span>
    </a> </td>
<td width="10%"><a href="https://github.com/taunkankur" target="_blank" style="text-decoration: none">
        <img src="Image/Git.jpg" style="border: 0; float: none; "  width="35%" height="10%"  /> 
        <span>Repository</span>
    </a></td>
</tr>
</table>


  </td>
</tr>
<tr><td>
<div class="nav" >
      <ul>
        <li><a href="#" id="IdMenuBarHome">Home..</a></li>
        <li><a href="#" id="IdMenuBarNews">Life Events..</a></li>
        <li><a href="#" id="IdMenuBarProjects">Projects..</a></li>
        <li><a href="#" id="IdMenuBarPersonal">Personal..</a></li>
      </ul>
    </div>		</td></tr>
</table>



</td>
</tr>

</table>

</div>

<!-- Body Logic -->
<div style=" height:75vh" id="IdHome">
<table border="0" width="100%" height="100%" align="center">
<tr>
<td width="55%" ><iframe src="HTML/AboutMe.html" width="100%" height="100%" style="border: none; overflow-y: hidden; "></iframe> </td>
<td width="45%" align="center"><iframe src="HTML/LinkedInRecommendations.html" width="100%" height="100%" style="border: none;"></iframe></td>
</tr>
</table>

</div>
 
 <div id="IdNews" style=" height:75vh">
 <table border="0" width="100%" height="100%" align="center">
<tr>
<td width="95%" ><iframe src="HTML/News.html" width="100%" height="100%" style="border: none; overflow-y: hidden; "></iframe> </td>
</tr>
</table>
 </div>
 
 <div id="IdProjects" style=" height:75vh">
  <table border="0" width="100%" height="100%" align="center">
<tr>
<td width="95%" ><iframe src="HTML/Projects.html" width="100%" height="100%" style="border: none; overflow-y: hidden; "></iframe> </td>
</tr>
</table>
 </div>
 
 
 <div id="IdPersonal" style=" height:75vh">
  <table border="0" width="100%" height="100%" align="center">
<tr>
<td width="95%" ><iframe src="HTML/Personal.html" width="100%" height="100%" style="border: none; overflow-y: hidden; "></iframe> </td>
</tr>
</table>
 </div>
 
 <div id="loginScreen">
		<a id="idPopusAnchor" href="#idTrendingData" class="cancel">&times;</a>
		<iframe id="idIframePopUp" width="100%" height="100%" src="" style="border: none"></iframe>
	</div>
	<br>
<!-- Footer Logic -->
<hr width="99%" class="style-two">
<div align="center">
<table border="0">
<tr>
<td><b> Come, Let's Connect </b></td>
<td><a href="https://www.facebook.com/ankur.taunk" target="_blank"><img align="middle" src="./Image/facebook.jpg"  height="10%"> </a> </td >
<td><a href="http://www.quora.com/Ankur-Taunk" target="_blank"><img align="left" src="./Image/Quora.jpg"  height="13%"> </a></td>
<td><a href=" https://twitter.com/a_taunk" target="_blank"><img align="middle" src="./Image/twitter.jpg" height="11%"></a></td>
<td><a href="https://www.linkedin.com/pub/ankur-taunk/19/511/99b" target="_blank"><img align="left" src="./Image/LinkedIn.png"  height="19%"></a></td>

</tr>
</table>
</div>
</body>
</body>
</html>