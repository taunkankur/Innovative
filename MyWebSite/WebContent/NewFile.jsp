<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ankur Taunk..</title>
<link rel="stylesheet" href="Style/styles.css">
<script src="http://code.jquery.com/jquery-2.1.0.min.js"></script>
<script type="text/javascript">

var ImageCount=0;

function loadImage(){
	$('#image').attr('src','Image/back3.jpg');
 	var cars = ["back3", "back9","back7"];
	ImageCount=cars.length;
	setInterval(function(){
		 if(ImageCount===0){
			ImageCount=cars.length-1;
		}else{
			ImageCount--;
		}
		 
		 var src = $(this).attr("src");
		  $("#image").fadeOut(function() {
		    $(this).attr("src", 'Image/'+cars[ImageCount]+'.jpg').fadeIn();
		  });
		 //$("#image").fadeOut(
				  //function(){
				   // $("#image").fadeOut('slow').attr('src', 'Image/'+cars[ImageCount]+'.jpg').fadeIn('slow');
				//  }
				//); // end fadeOut
		
		
	}, 4000); 
	
}





</script>
<style type="text/css">
#footer {
   position:absolute;
   bottom:0;
   width:99.5%;
   height:20px;   /* Height of the footer */
   background:#c2c6b3;
}

.heading{
color: grey;
font: italic bold 20px/30px Georgia, serif;
}
</style>
<style type="text/css">
html, body    {
  height: 99%;
}
</style>
</head>
 
<body onload="loadImage()">

<div id="idHeader" style="height: 20%; ">
<table border="0" width="100%">
<tr>
<td width="10%"><img  id="image" alt="" src="" width="100%" ></td>
<td width="10%"></td>
<td width="10%"><img alt="" src="Image/profile.jpg" width="100%" style="box-shadow: 10px 10px 5px #888888;"> </td>
<td width="40%" align="center" valign="middle"><h4 class="heading" >" Visualize the Future and Encash it in Present "</h4></td>
<td width="30%" align="right"><img alt="" src="Image/njit-logo.jpg" width="80%" ></td>
</tr>
</table>
</div>


<div id="idBody" style="height: 80%;" >
<table border="0" width="100%" style="height: 95%;">
<tr>
<td width="15%" align="center">
<div id='cssmenu'  style="box-shadow: 10px 10px 5px #888888;">
<ul>
   <li><a href='HTML/AboutMe.html' target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px" >About</span></a></li>
   <li><a href='HTML/News.html' target="iframe_a" ><span style="font-family: Arial, Sans-Serif; font-size: 15px">News</span></a></li>
   <li class='active has-sub'><a href='#'><span style="font-family: Arial, Sans-Serif; font-size: 15px">Work Exp. / Project</span></a>
      <ul>
      <li ><a href='HTML/AcademicProject.html' target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px">Academic</span></a>
       <!--   <li class='has-sub'><a href='#'><span style="font-family: Arial, Sans-Serif; font-size: 15px">Academic</span></a>
           <ul>
                <li><a href='#'><span style="font-family: Arial, Sans-Serif; font-size: 15px">Sub Product</span></a></li>
               <li class='last'><a href='#'><span style="font-family: Arial, Sans-Serif; font-size: 15px">Sub Product</span></a></li>
            </ul>--> 
         </li>
         <li ><a href='HTML/ProfessionalProject.html'  target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px">Professional</span></a>
        <!--  <li class='has-sub'><a href='HTML/ProfessionalProject.html'><span style="font-family: Arial, Sans-Serif; font-size: 15px">Professional</span></a>
            <ul>
               <li><a href='#'><span style="font-family: Arial, Sans-Serif; font-size: 15px">Sub Product</span></a></li>
               <li class='last'><a href='#'><span style="font-family: Arial, Sans-Serif; font-size: 15px">Sub Product</span></a></li>
            </ul>
         </li>-->
      </ul>
   </li>
   <li><a href='HTML/Personal.html' target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px">Personal</span></a></li>
   <li><a href='HTML/Link.html' target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px">Links</span></a></li>
   <li class='last'><a href='HTML/Contact.html' target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px">Contact</span></a></li>
</ul>
</div>
<br>
<br>

<div >                      
    <a href="Document/Ankur_Taunk_Resume.pdf" target="_blank" style="text-decoration: none">
        <img src="Image/PDF-download.png" style="border: 0; float: none; "  width="50px" height="50px"  /> 
        <span>Resume</span>
    </a>  
    <br>
    <a href="https://github.com/taunkankur" target="_blank" style="text-decoration: none">
        <img src="Image/Git.jpg" style="border: 0; float: none; "  width="50px" height="50px"  /> 
        <span>Repository</span>
    </a> 
</div>
</td>
<td>
<iframe name="iframe_a" width="97%"  height="100%" src="HTML/AboutMe.html"  scrolling="auto" style="border-style: none inset inset none; box-shadow: 10px 10px 5px #888888;"  ></iframe>
</td>
</tr>
</table>
</div>




<div align="center" id="footer" ><span > 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; © 2014 - Ankur Taunk</span></div>
</body>
</html>