<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<script src="./Script/jquery/jquery.js" type="text/javascript"></script>
<script src="./Script/jquery/jquery-ui.custom.js" type="text/javascript"></script>
<script src="./Script/jquery/jquery.cookie.js" type="text/javascript"></script>
<script src="./Script/DynamicTree/jquery.dynatree.js"	type="text/javascript"></script>
<script src="./Script/DynamicTree/DynTree.js" type="text/javascript"></script>
<link href="./Script/DynamicTree//skin/ui.dynatree.css" rel="stylesheet"
	type="text/css">


<script type="text/javascript">
	var ImageCount = 0;

	function loadImage() {
		$('#image').attr('src', 'Image/Security1.jpg');
		var cars = [ "security2.jpg", "Security1.jpg", "security3.jpg" ];
		ImageCount = cars.length;
		setInterval(function() {
			if (ImageCount === 0) {
				ImageCount = cars.length - 1;
			} else {
				ImageCount--;
			}

			var src = $(this).attr("src");
			$("#image").fadeOut(function() {
				$(this).attr("src", 'Image/' + cars[ImageCount]).fadeIn();
			});
			//$("#image").fadeOut(
			//function(){
			// $("#image").fadeOut('slow').attr('src', 'Image/'+cars[ImageCount]+'.jpg').fadeIn('slow');
			//  }
			//); // end fadeOut

		}, 3000);

	}
	
	$(document).ready(function() {
	    $("#idSearchButton").click(function(){
	    	selectedWord=$('#idSearchText').val();
	    	
	    	var iframe = document.getElementById("resultFrame");
	    	iframe.contentWindow.ResetSearchvalue(selectedWord);
	    	
			
			iframe.contentWindow.LoadDescription();
			
			iframe.contentWindow.Reset();
	    	
	    }); 
	});
	
</script>






</head>
<body onload="loadImage()">

	<div style="position: absolute; ">
		<table border="0" style="">
			<tr>
				<td width="55%"><img alt="" height="30%" id="image"></td>
				<td><img alt="" src="Image/SLOBLogo.JPG" height="50%"></td>
			</tr>
		</table>
	</div>
	<br>
	<br>
	<br>
	<br>
	<hr width="100%">
	<div align="center">
		<table border="0"  width="100%" height="50%">
			<tr>
				<td  style="height: 100%; width: 18%"><input type="text" size="41" id='idSearchText'> 
				<input type="button" value="Search" id='idSearchButton'>
				<div id="tree" style="height: 600px; width: 335px"></div></td>
				<td><iframe  style="border: none" align="left" id="resultFrame" src="TreeView.html" width="100%" height="750px"></iframe> </td>
			</tr>
		</table>
	</div>

	<!--  <input type="button" id="idAjaxCall">-->

	<div align="center"
		style="position: absolute; margin-left: -150px; bottom: 0px; left: 30%;">
		<table border="0" align="center">
			<tr>
				<td width="250px" height="60px" align="center"><img alt=""
					src="http://ppopp2013.ics.uci.edu/pics/nsf.jpg"
					width="100px" height="60px"></td>
				<td width="300px" height="60px" align="center"><img alt=""
					src="http://web.njit.edu/~bieber/home-images/njit-logo.jpg"
					width="200px" height="60px"></td>
				<td width="300px" height="60px"><img alt=""
					src="http://thekingsmanpaper.com/wp-content/uploads/2014/10/CUNY-Logo-300x182.png"
					width="250px" height="60px"></td>
				<td width="300px" height="60px"><img alt=""
					src="http://www.montclair.edu/university-communications/marketing-and-advertising/logos/color/2in.jpeg"
					width="250px" height="60px"></td>
			</tr>
		</table>
	</div>
</body>
</html>