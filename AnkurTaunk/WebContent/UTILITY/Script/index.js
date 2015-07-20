/**
 * 
 */
function loadImage(){
		
		
		//$('#image').attr('src','Image/Profile1.jpg');
	 	//var cars = ["Profile1", "Profile2","Profile3"];
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
$(document).ready(function() {
	var ImageCount=0;

	
	
	
	$('#IdHome').fadeIn();
	$('#IdNews').hide();
	$('#IdProjects').hide();
	$('#IdPersonal').hide();

	
	$('#IDAcademic').click(function() {
		window.open('#loginScreen', '_self');
		$('#idIframePopUp').attr('src','HTML/AcademicProject.html');
	});

	
	$('#IdMenuBarHome').click(function() {
		
		$(this).addClass('active');
		$('#IdMenuBarNews').removeClass('active');
		$('#IdMenuBarProjects').removeClass('active');
		$('#IdMenuBarPersonal').removeClass('active');
		
		$('#IdHome').fadeIn();
		$('#IdNews').hide();
		$('#IdProjects').hide();
		$('#IdPersonal').hide();
		

	});

	$('#IdMenuBarNews').click(function() {
		
		$(this).addClass('active');
		$('#IdMenuBarHome').removeClass('active');
		$('#IdMenuBarProjects').removeClass('active');
		$('#IdMenuBarPersonal').removeClass('active');
		
		$('#IdHome').hide();
		$('#IdNews').fadeIn();
		$('#IdProjects').hide();
		$('#IdPersonal').hide();
	});

	$('#IdMenuBarProjects').click(function() {

		$(this).addClass('active');
		$('#IdMenuBarHome').removeClass('active');
		$('#IdMenuBarNews').removeClass('active');
		$('#IdMenuBarPersonal').removeClass('active');
		
		$('#IdHome').hide();
		$('#IdNews').hide();
		$('#IdProjects').fadeIn();
		$('#IdPersonal').hide();
	});
	
	$('#IdMenuBarPersonal').click(function() {

		$(this).addClass('active');
		$('#IdMenuBarHome').removeClass('active');
		$('#IdMenuBarNews').removeClass('active');
		$('#IdMenuBarProjects').removeClass('active');
		
		$('#IdHome').hide();
		$('#IdNews').hide();
		$('#IdProjects').hide();
		$('#IdPersonal').fadeIn();
	});

});