<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <title>jQuery UI Tabs - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>

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
</script>
  <script type="text/javascript">
 
   $(document).ready(function() {
	   
	   
	     $( "#tabs" ).tabs();
	     

	   $('#tabs').tabs({
           activate: function(event ,ui){
               //console.log(event);
               alert(ui.newTab.index());
               console.log(ui.newTab.index());
           }
});	  
      $("#button").click(function(event){
    	
    	  $("#tabs" ).tabs( { active: 0 } );
	    	
      });
      
    
   });

</script>
</head>
<body onload="loadImage()">
 <input type="button" id="button">
	<div style="position: absolute; top: 0px;">
		<table border="0" style="margin: 0px auto;">
			<tr>
				<td width="55%"><img alt="" height="30%" id="image"></td>
				<td><img alt="" src="Image/SLOBLogo.JPG" height="50%"></td>
			</tr>
		</table>
	</div>
	<hr width="100%">
<div align="center">
		<table border="0">
			<tr>
				<td><input type="text" size="35"> <input type="button"
					value="Search">
				<div id="tree" style="height: 680px; width: 300px"></div></td>
				<td> <div id="tabs" >

						<ul >
							<li ><a href="#Description" >Description</a></li>
							<li ><a href="#Article" >Article</a></li>
							<li ><a href="#Video">Video</a></li>
							<li ><a href="#Slides" >Slides</a></li>
							<li ><a href="#Books" >Books</a></li>

						</ul>

						<div id="Description" >
							<iframe id="ifDescription" width="100%" height="635px"
								style="border: none;"></iframe>
						</div>
						<div id="Article" >
							<iframe id="ifArticle" width="100%" height="635px"
								style="border: none;"></iframe>
						</div>
						<div id="Video" >
							<iframe id="ifVideo" width="100%" height="635px"
								style="border: none;"></iframe>
						</div>
						<div id="Slides" >
							<iframe width="100%" height="635px" style="border: none;"></iframe>
						</div>
						<div id="Books" >
							<iframe id="ifBooks" width="100%" height="635px"
								style="border: none; overflow: hidden;" scrolling="no"></iframe>
						</div>


					</div> 

			</tr>
		</table>
	</div>
 
 <input type="button" id="button">
 <div align="center"
		style="position: absolute; margin-left: -150px; bottom: 0px; left: 30%;">
		<table border="0" align="center">
			<tr>
				<td width="250px" height="60px" align="center"><img alt=""
					src="http://cis.csi.cuny.edu/~project/iSecure/images/nsf1.gif"
					width="100px" height="60px"></td>
				<td width="300px" height="60px" align="center"><img alt=""
					src="http://branding.njit.edu/image/logos/njit_rgbd_362x160.gif"
					width="200px" height="60px"></td>
				<td width="300px" height="60px"><img alt=""
					src="http://cis.csi.cuny.edu/~project/iSecure/images/cunylogoweb.jpg"
					width="250px" height="60px"></td>
				<td width="300px" height="60px"><img alt=""
					src="http://www.montclair.edu/university-communications/marketing-and-advertising/logos/color/2in.jpeg"
					width="250px" height="60px"></td>
			</tr>
		</table>
	</div>
</body>
</html>