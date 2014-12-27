<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="http://code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
  <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
  <link rel="stylesheet" href="http://resources/demos/style.css">
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
		
		 
		//autoCompl();
		 
		$('#image').attr('src', 'Image/nsf.jpg');
		var cars = [ "nsf.jpg", "nsf.jpg", "nsf.jpg" ];
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
	    	togglLable( selectedWord);
	    	var iframe = document.getElementById("resultFrame");
	    	iframe.contentWindow.ResetSearchvalue(selectedWord);
	    	
			
			iframe.contentWindow.LoadDescription();
			
			iframe.contentWindow.Reset();
	    	
	    }); 
	});
	
	function togglLable( searchValue){
		$('#idLable').html(searchValue);
	}
	
</script>

<script>

  
	$(document).ready(function() {
	

	  var availableTags;
    $.ajax({
        type: "GET",
        url: "WSOntologyCall.do?searchType=Json&searchFor=None",
     
        async: false,
     	success: function (d) {
     		
     		availableTags=d.split(',');
     		
        },
        error: function () {
            alert('Error');
        }
    });   
    

    $( "#idSearchText" ).autocomplete({
      source: availableTags
    });
  });
  </script>

 <style>
 #footer {
   position:absolute;
  
   width:99.5%;
   height:20px;   /* Height of the footer */
   background:#c2c6b3;
}
  .ui-autocomplete {
    max-height: 250px;
    max-width: 305px;
    overflow-y: auto;
    /* prevent horizontal scrollbar */
    overflow-x: auto;
  }
  /* IE 6 doesn't support max-height
   * we use height instead, but this forces the menu to always be this tall
   */
  * html .ui-autocomplete {
    height: 250px;
    width: 305px
  }
  html, body    {
  height: 98%;
}
  </style>
</head>
<body onload="loadImage()">


	<div id="idHeader" align="center" style="height: 7%; ">
		<table border="0" >
			<tr >
				<td  ><img alt="" id="image" height="60px"></td>
				<td ><img alt="" src="Image/SLOBLogo.JPG" height="50px" ></td>
				
			</tr>
		</table>
	</div>




	<hr width="100%">
	
	
	
	<div id="idBody"align="center" style="height: 90%;">
		<table border="0"  width="100%" height="100%">
			<tr>
			
				<td  style=" width: 14%" valign="top">
				<div style="height: 60px; width: 300px"  align="center"><label id="idLable" style="color: grey;font: italic bold 20px/30px Georgia, serif;" > Select or Enter Word</label></div>
			
				<div id="tree" style="height: 400px; width: 300px" ></div>
				<br>	
				<hr width="100%">
					 
				<input type="text" size="20" id='idSearchText' class="ui-widget">
				<input type="button" value="Search" id='idSearchButton' style="height: 27px">
				</td>
				<td><iframe  style="border: none;height: 100%" align="middle" id="resultFrame" src="TreeView.html" width="100%" ></iframe> </td>
			</tr>
		</table>
	</div>

	<!--  <input type="button" id="idAjaxCall">-->

	<!-- <div align="center"
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
	</div> -->
	<br>
	<br>
	<!-- <div id="idFooter" align="center"><span class="copyright"> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; © 2014 - All Right Reserved</span></div> -->
	<div align="center" id="footer" ><span > 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; © 2014 - All Right Reserved</span></div>
</body>
</body>
</html>