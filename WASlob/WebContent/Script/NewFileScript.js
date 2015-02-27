/**
 * 
 */

var searchTermFromText;
function loadImage() {
	var ImageCount = 0;

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

	}, 3000);

}

$(document).ready(function() {
	$('#iDProgressBarBooks').hide();
	$('#iDProgressBarSlides').hide();
	$('#iDProgressBarVideo').hide();
	$('#iDProgressBarArticle').hide();
	$('#iDProgressBar').hide();
	$('#idSearchText1').hide();
	$('#submit1').hide();

	$("#idIframeDescription").attr(	"src","UtilityHTML/WelcomePage.html");
	
 var availableTags;
$.ajax({
   type: "GET",
   url: "WSOntologyCall.do?searchType=Json&searchFor=None",

   async: false,
	success: function (d) {
		
		availableTags=d.split(',');
		
   },
   error: function () {
       //alert('Error');
   }
});   


$( "#idSearchText" ).autocomplete({
 source: availableTags
});

$( "#idSearchText1" ).autocomplete({
	 source: availableTags
	});

var lastScrollTop = 0;
$(window).scroll(function(event){
   var st = $(this).scrollTop();
   if (st > lastScrollTop){
       // downscroll code
	   $('#idSearchText1').fadeIn(500);
		$('#submit1').fadeIn(500);
		//$('#idUpClick').fadeIn(500);
		//$('#idDwnClick').fadeOut(500);
		
   } else {
      // upscroll code
	   $('#idSearchText1').fadeOut(500);
		$('#submit1').fadeOut(500);
		//$('#idUpClick').fadeOut(500);
		//$('#idDwnClick').fadeIn(500);
   }
   lastScrollTop = st;
});



$("#idUpClick").on("click", function(){
	
	$('#idSearchText1').fadeIn(1000);
	$('#submit1').fadeIn(1000);
	//$('#idUpClick').hide();
	//$('#idDwnClick').show();
	$('html,body').animate({
        scrollTop: $("#idHeader").offset().top},
        1000);
  
  });

$("#idDwnClick").on("click", function(){
	
	$('#idSearchText1').fadeOut(1000);
	$('#submit1').fadeOut(1000);
	//$('#idDwnClick').hide();
	//$('#idUpClick').show();
	$('html,body').animate({
        scrollTop: $("#idTrendingData").offset().top},
        1000);
  });


$('#submit').click(function(){
	loadProfressbar();
	searchTermFromText=$('#idSearchText').val();
	//alert($('#idSearchText').val());
	searchTermFromText=capitaliseFirstLetters(searchTermFromText);
	loadSearchNameInBox(searchTermFromText);
	loadDescriptionData(searchTermFromText);
	loadArticleData(searchTermFromText);
	loadVideoData(searchTermFromText);
	loadSlidesData(searchTermFromText);
	loadBookData(searchTermFromText);
});


$('#submit1').click(function(){
	
	
	//removeVideoList();
		loadProfressbar();
		searchTermFromText=$('#idSearchText1').val();
		
		//alert($('#idSearchText').val());
		searchTermFromText=capitaliseFirstLetters(searchTermFromText);
		loadSearchNameInBox(searchTermFromText);
		loadDescriptionData(searchTermFromText);
		loadArticleData(searchTermFromText);
		loadVideoData(searchTermFromText);
		loadSlidesData(searchTermFromText);
		loadBookData(searchTermFromText);
	
	 
	
	
});



(function($){
    $.fn.extend({
        center: function () {
            return this.each(function() {
                var top = ($(window).height() - $(this).outerHeight()) / 2;
                var left = ($(window).width() - $(this).outerWidth()) / 2;
                $(this).css({position:'absolute', margin:0, top: (top > 0 ? top : 0)+'px', left: (left > 0 ? left : 0)+'px'});
            });
        }
    }); 
})(jQuery);

$('#idButtonArticle').click(function(){
	
	$("#idIframePopUp").attr(	"src","UtilityJSP/Article.jsp?SearchName="+searchTermFromText.replace(" ", ""));

});

$('#idButtonVideo').click(function(){

	$("#idIframePopUp").attr(	"src","UtilityJSP/YouTubeVideo.jsp?SearchName="+searchTermFromText.replace(" ", ""));

});
$('#idButtonSlides').click(function(){
	
	 
	 $("#idIframePopUp").attr(	"src","UtilityJSP/Slides.jsp?SearchName="+searchTermFromText.replace(" ", ""));
});

$('#idButtonBooks').click(function(){
	

	

	$("#idIframePopUp").attr(	"src","UtilityJSP/BookPage.jsp?SearchName="+searchTermFromText+'&pageNumber=*');
	});

$('#content li').live('click', function ()
		{
		    var selected = $(this).text();
	    
		    $("#idIframePopUp").attr(	"src","UtilityJSP/BookPage.jsp?SearchName="+searchTermFromText+'&pageNumber='+selected);

		});

}); 



function loadDescriptionData(searchTermFromText){
	loadSearchNameInBox(searchTermFromText);
	$('#idTrendingData').show();
	//$('#idDwnClick').show();
	//$("#idIframeDescription").attr(	"src","UtilityJSP/Description.jsp?SearchName="+searchTermFromText);
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Description&searchFor="+searchTermFromText.replace(" ", ""),

	        async: true,
	     	success: function (descriptionData) {
	     		$('#iDProgressBar').hide();
	     		$('#idIframeDescription').show();
	     		
	     		$("#idIframeDescription").attr(	"src","UtilityHTML/Description.html?Data="+descriptionData+"&SearchName="+searchTermFromText);
	     		 
	     		
	        },
	        error: function () {
	         //   alert('Error');
	        }
	    });
	
	
	
		  
		  
}



function loadArticleData(searchTermFromText){
	
	articleProgressBar();
var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Article&searchFor="+searchTermFromText.replace(" ", ""),

	        async: true,
	        beforeSend:removeArticleList(),
	     	success: function (ArticleData, textStatus, xhr) {
	     		
	     		if(ArticleData.trim()!=='false'){
	     			
	     		
	     		xml=ArticleData;
	     		xmlDoc = $.parseXML( xml ),
	     	     $xml = $( xmlDoc );
	     		
	     		
	     		if($($xml).find("result>hits").attr('computed')!=='0'){
	     			
	     			$('#iDProgressBarArticle').hide();
	     	     $($xml).find("result>hits>hit>info").each(function(i){
	     		if(i<5){
	     			
	     			var author='<b>Authors - </b>';
	     			 $(this).find("authors").each(function(i){
	     				 
	     				author=author+$(this).find("author").text()+' <b>|</b> ';
	     			 });
	     			 
	     			var count=i;
	     			count=count+1;
	     			var theURL = $(this).find("title").text();
		    			var pieceOneTitle = theURL.substr(0,80);
		    			var pieceTwoTitle = theURL.substr(80, 75);

	     			       $("#idArticleList ul").append('<li style="list-style-type: none;"><a target="_blank" style="color: #1a0dab; text-decoration: none;" href='+$(this).find('title').attr('ee') +'><span class="tab truncate"><b>'+count+'.  '+pieceOneTitle+'-<br />' +pieceTwoTitle+'</b></span></a>		'+'<br />'+'<span style="list-style-type: none; color:#545454 ;" >'+author+'</span></li>');
	     			}else{

	     			}    
	     			}); 
	     		 }else{
	     			noArticleDataFound();
	     		 }
	     		}else{
	     			
	     			noArticleDataFound();
	     			
	     		}
	        },
	        error: function () {
	        //    alert('Error');
	        } 
	    });
	
	
	 

    
 
		  
}




function loadVideoData(searchTermFromText){
	
	
	videoProgressBar();
	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Video&searchFor="+searchTermFromText.replace(" ", ""),
	 		async: true,
	 		beforeSend:removeVideoList(),
	     	success: function (d) {
	     		
	     		
	     		
	     		$('#idTDArticle').show();
	     		if(d.trim()!=='false' && d.trim()!=="<Results/>"){
	     		xml=d;
	     		 xmlDoc = $.parseXML( xml ),
	     	    $xml = $( xmlDoc );
	     		$('#iDProgressBarVideo').hide();
	     	    $($xml).find("Results>Row").each(function(i){
	     	   	
	     	      
	     	   		 if(i<5){
	     		    			var count=i;
	     		    			count=count+1;
	     		    			var theURL = $(this).find("VedDesc").text();
	     		    			var pieceOne = theURL.substr(0,80);
	     		    			var pieceTwo = theURL.substr(80, 75);
	     			  	       $("#idVideoList ul").append('<li style="list-style-type: none;"><a target="_blank" style="color: #1a0dab; text-decoration: none;" href=https://www.youtube.com/watch?v='+$(this).find("VedURL").text()+'><span class="tab truncate"><img alt="" width="25px"  height="25px" src="'+$(this).find("VedThumbNail").text()+'"><b> '+$(this).find("VedTitle").text()+'</b></span></a>	'+'<br />'+'<span style="list-style-type: none; color:#545454 ;" >'+pieceOne +'-<br />' +pieceTwo+'</span></li>');
	     			  }else{
	     			  	
	     			  } 
	     	   	
	     	  
	     	     });
	     	}else{
	     		noVideoDataFound();
	     			 $('#idButtonVideo').hide();
	     			
	     		}
	     			
	     		
	        },
	        error: function () {
	          //  alert('Error');
	        }
	    });
   
	 
	
   
	
}

function loadSlidesData(searchTermFromText){
	
	slidesProgressBar();
	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Slides&searchFor="+searchTermFromText.replace(" ", ""),
	        beforeSend:removeSlidesList(),
	        async: true,
	     	success: function (d) {
	     		
	     		
	     		if(d.trim()!=='false'){
	     			
	     		
	     		$('#idTDSlides').show();
	     		 xml=d;
	     		xmlDoc = $.parseXML( xml ),
	     	    $xml = $( xmlDoc );
	     	    
	     		$('#iDProgressBarSlides').hide();
	     	    $($xml).find("Slideshows>Slideshow").each(function(i){
	     	   	 
	     	   	 
	     	  
	     	   	 var url=$(this).find('Slideshows>Slideshow>URL').text();
	     			    var VedTitle=$(this).find('Slideshows>Slideshow>Title').text();

	     			   	 if(i<5){
	     		    			var count=i;
	     		    			count=count+1;
	     		    			
	     		    			var theURL =$(this).find("Description").text();
	     		    			var pieceOne = theURL.substr(0,80);
	     		    			var pieceTwo = theURL.substr(80, 75);
	     			  	       $("#idSlidesList ul").append('<li style="list-style-type: none;"><a target="_blank" style="color: #1a0dab; text-decoration: none;" href='+$(this).find("URL").text()+'><span class="tab truncate"><img alt="" width="25px"  height="25px" src="'+$(this).find("ThumbnailSmallURL").text()+'"> <b>'+$(this).find("Title").text()+'</b></span></a>'+'<br />'+'<span style="list-style-type: none; color:#545454 ;" >'+pieceOne +'-<br />' +pieceTwo+'</span>	</li>');
	     			  }else{
	     			  	
	     			  } 
	     			      });}else{
	     			    	 noSlidesDataFound();
	     			      }
	     		
	        },
	        error: function () {
	          //  alert('Error');
	        }
	    });
   
   
    
}


function loadBookData(searchTermFromText){
	
	bookProgressbar();
	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Book&searchFor="+searchTermFromText,
	      //  contentType: "application/json; charset=utf-8",
	        beforeSend:removeBookList(),
	        async: true,
	     	success: function (d) {
	     		
	     		if(d.trim()!=='false' && d.trim()!=='<OwlRootNode><BookPage></BookPage></OwlRootNode>'){
	     		$('#iDProgressBarBooks').hide();
	     		$('#idTDBooks').show();
	     		 xml=d;
	     		xmlDoc = $.parseXML( xml ),
	     	     $xml = $( xmlDoc );
	     	     var BookPage= $($xml).find("OwlRootNode>BookPage").text().split(',');
	     	     
	     	     
	     	     $.each(BookPage , function(i, val) { 
	     	    	 
	     	    	 
	     	    	 
	     	    	 if(i<10){
	     	    			
	     	var count=i;
	     	count=count+1;
	     		  	      // $("#idVideoList ul").append('<li style="list-style-type: none;"><a target="_blank" style="color: #000000; text-decoration: none;" href=https://www.youtube.com/watch?v='+$(this).find("VedURL").text()+'><span class="tab truncate">'+$(this).find("VedTitle").text()+'</span></a>	</li>');
	     		  	      
	     	    		 if(i===0 && BookPage[0]===''){
	     	    			 $('#idButtonBooks').hide();
	     	    			 
	     	    			
	     		    		 //alert('No Book Pages');
	     		    	 }else{
	     		    		 
	     		    		 if(BookPage[i]!==''){
	     		    			 $("#idBooksList ul").append('<li style="list-style-type: none;"><b>'+count+'. </b><a style="color: #000000; text-decoration: none;"  href="#loginScreen" >'+BookPage [i]+'</a></li>');
	     		    			 
	     		    			 // $('ul').append('<li><a >'+BookPage [i]+'</a></li>');
	     		        	 }
	     		    	 }
	     		  }else{
	     		  	
	     		  } 
	     	    	 
	     	    	 
	     	    	 
	     	    });}else{
	     	    	noBooksDataFound();
	     	    }
	     		
	        },
	        error: function () {
	        //    alert('Error');
	        }
	    });
    
    // alert($(xml).find("title").text());
     
}

function loadProfressbar(){
	
	$('#iDProgressBar').center();
	$('#idIframeDescription').hide();
	$('#iDProgressBar').show();
}

function removeVideoList(){
	
	

		
	
//	for( i=0;i<$( "#idLiVideo li" ).size();i++){
//		
//		$('#idLiVideo li:last').remove();
//		
//	}
	
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	$('#idLiVideo li:last').remove();
	
	 


}


function removeArticleList(){
	

	
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	$('#idLiArticle li:last').remove();
	
	 
	

}


function removeSlidesList(){
	

	
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	$('#idLiSlides li:last').remove();
	
	 
	

}


function removeBookList(){
	

	
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	$('#content li:last').remove();
	
	
	 
	

}
function loadSearchNameInBox(searchTermFromText){
	$('#idSpanArticle').html(searchTermFromText);
	$('#idSpanVideo').html(searchTermFromText);
	$('#idSpanSlides').html(searchTermFromText);
	$('#idSpanBooks').html(searchTermFromText);
}


function noArticleDataFound(){
	$('#iDProgressBarArticle img').attr('width','80%');
		$('#iDProgressBarArticle img').attr('height','80%');
		$('#iDProgressBarArticle img').attr('src','Image/NodataFound.PNG');
}

function noVideoDataFound(){
	$('#iDProgressBarVideo img').attr('width','80%');
	$('#iDProgressBarVideo img').attr('height','80%');
	$('#iDProgressBarVideo img').attr('src','Image/NodataFound.PNG');
}

function noSlidesDataFound(){
	$('#iDProgressBarSlides img').attr('width','80%');
	$('#iDProgressBarSlides img').attr('height','80%');
	$('#iDProgressBarSlides img').attr('src','Image/NodataFound.PNG');
}

function noBooksDataFound(){
	$('#iDProgressBarBooks img').attr('width','80%');
	$('#iDProgressBarBooks img').attr('height','80%');
	$('#iDProgressBarBooks img').attr('src','Image/NodataFound.PNG');
}

function articleProgressBar(){
	
	$('#iDProgressBarArticle img').attr('width','20%');
	$('#iDProgressBarArticle img').attr('height','20%');
	$('#iDProgressBarArticle img').attr('src','Image/loading-bar.gif');
	$('#iDProgressBarArticle').show();
}

function videoProgressBar(){
	
	$('#iDProgressBarVideo img').attr('width','20%');
	$('#iDProgressBarVideo img').attr('height','20%');
	$('#iDProgressBarVideo img').attr('src','Image/loading-bar.gif');
	$('#iDProgressBarVideo').show();
}

function slidesProgressBar(){
	$('#iDProgressBarSlides img').attr('width','20%');
	$('#iDProgressBarSlides img').attr('height','20%');
	$('#iDProgressBarSlides img').attr('src','Image/loading-bar.gif');
	$('#iDProgressBarSlides').show();
}

function bookProgressbar(){
	
	$('#iDProgressBarBooks img').attr('width','20%');
	$('#iDProgressBarBooks img').attr('height','20%');
	$('#iDProgressBarBooks img').attr('src','Image/loading-bar.gif');
	$('#iDProgressBarBooks').show();
}