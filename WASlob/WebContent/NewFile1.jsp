<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SLOB - Security Learning By Ontology Browsing</title>
<link rel="shortcut icon" href="Image/nsf.jpg">
<link rel="apple-touch-icon" href="Image/nsf.jpg">
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
	    	showProcessBar();
			hideDataTable();
	    	selectedWord=$('#idSearchText').val();
	    	
	    	selectedWord=capitaliseFirstLetter(selectedWord);
	    	
	    	togglLable( selectedWord);
	    	var iframe = document.getElementById("resultFrame");
	    	iframe.contentWindow.ResetSearchvalue(selectedWord);
	    	
	    	iframe.contentWindow.reloadPageTreeView();
			//iframe.contentWindow.LoadDescription();
			
			//iframe.contentWindow.Reset();
	    	
	    }); 
	});
	
	function togglLable( searchValue){
		$('#idLable').html(searchValue);
	}
	
	
	function capitaliseFirstLetter(string)
	{
	    return string.charAt(0).toUpperCase() + string.slice(1);
	}
	

		

</script>

<script>
function hideProcessBar(){
	$('#idProcessingBar').hide();
}

function showProcessBar(){
	$('#idProcessingBar').show();
}

function hideDataTable(){
	$('#idDataTable').hide();
	
}

function showDataTable(){
	$('#idDataTable').show();
}
  
	 $(document).ready(function() {
		 hideProcessBar();
		 showDataTable();
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
  /* position:absolute;*/
  
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
  height: 99%;
}
  </style>
</head>
<body onload="loadImage()">


	<div id="idHeader" align="center" style="height: 6%; ">
		<table border="0" >
			<tr >
				<td  ><img alt="" id="image" height="60px"></td>
				<td ><img alt="" src="Image/SLOBLogo.JPG" height="50px" ></td>
				
			</tr>
		</table>
	</div>




	<hr width="100%">
	
	
	
	<div id="idBody"align="center" style="height: 95%;">
		<table border="0"  width="100%" height="100%">
			<tr>
			
				<td  style=" width: 17%" valign="top">
				<br><br><br><br><br><br>
				<table border="0"  style="width:100%;  border-collapse:collapse;    table-layout:fixed;">
				<tr><td><div align="center"><label id="idLable" style="color: grey;font: italic bold 20px/30px Georgia, serif;" > Select or Enter Word</label></div></td></tr>
				<tr><td> <div id="tree" style="height: 500px"></div></td></tr>
				<tr><td><br><input type="text"  id='idSearchText' class="ui-widget" style="width: 80%" >
				<input type="button" value="Search" id='idSearchButton' style="height: 27px"></td></tr>
				</table>
				
			
				
				
			
					 
				
				</td>
				<td>
				<div id="idProcessingBar">
				
				<h4 style="color: grey;font: italic bold 20px/30px Georgia, serif;" id="idNoSaveVideo" align="center"> Form loading. Please wait...</h4>
				</div>
						<div id="idDataTable" style="height: 99%" >
						<iframe  style="border: none;height: 99%" align="middle" id="resultFrame" src="TreeView1.html" width="100%" ></iframe></div> </td>
				
			</tr>
		</table>
	</div>


	
	<!-- <div id="idFooter" align="center"><span class="copyright"> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; © 2014 - All Right Reserved</span></div> -->
	<div align="center" id="footer" ><span > 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; © 2014 - All Right Reserved</span></div>
</body>
</body>
</html>