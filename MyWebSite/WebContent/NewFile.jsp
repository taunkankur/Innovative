<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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

</head>
 
<body onload="loadImage()">

<table border="0">
<tr>
<td >
<table border="0">
<tr>
<td  width="20%"><img  id="image" alt="" src="" ></td>
</tr>
</table>

<table border="0">
<tr>
<td width="300" align="right" height="380px">

<div id='cssmenu'>
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
   <li><a href=''><span style="font-family: Arial, Sans-Serif; font-size: 15px">Personal</span></a></li>
   <li><a href='HTML/Link.html' target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px">Links</span></a></li>
   <li class='last'><a href='HTML/Contact.html' target="iframe_a"><span style="font-family: Arial, Sans-Serif; font-size: 15px">Contact</span></a></li>
</ul>
</div>
<br>
<br>

<div style='bottom:0;left:15;'>                      
    <a href="Document/Travel History.pdf" target="_blank" style="text-decoration: none">
        <img src="Image/PDF-download.png" style="border: 0; float: none; margin-right:3%"  width="15%" height="15%" /> 
        <span>Resume</span>
    </a>  
</div>
</td>


</tr>
</table >
</td >
<td width="100%">


<div  align="center" style='position:absolute;top: 0;left:15; ;'>
<img alt="" src="Image/profile.jpg" width="10%" height="20%"> 
<img alt="" src="Image/njit-logo.jpg" width="80%" height="20%"> </div>



<iframe name="iframe_a" width="70%" height="70%"  src="HTML/AboutMe.html" align="bottom"  	style="position:absolute; bottom: 1cm;top:25%;border-style: none inset inset none;"></iframe>





</td>
</tr>
</table>






<div align="center"><span class="copyright"> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;copyrights © 2014 - Ankur Taunk</span></div>
</body>
</html>