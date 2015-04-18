/**
 * 
 */
var landingPageData;
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

   async: true,
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

$('#idPageNumberClick').live('click', function ()
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
	     		landingPageData=descriptionData;
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
	     	     
	     	     var pageInformation='<span style=color:#1a0dab><b>\tGood Rich :- </b></span>';
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
	     		    		//	 $("#idBooksList ul").append('<li style="list-style-type: none;"><b>'+count+'. </b><a style="color: #000000; text-decoration: none;"  href="#loginScreen" >'+BookPage [i]+'</a></li>');
	     		    			
	     		    			pageInformation= pageInformation+'<a style="color: #545454; text-decoration: none;"  href="#loginScreen" id="idPageNumberClick"><b>'+BookPage [i]+'</b></a>'+' | ';
	     		    			 
	     		    			 // $('ul').append('<li><a >'+BookPage [i]+'</a></li>');
	     		        	 }
	     		    	 }
	     		  }else{
	     		  	
	     		  } 
	     	    	 
	     	    	 
	     	    	 
	     	    });
	     	    $("#idTableForPageDisplay").append('<td>'+pageInformation.replace('undefined','')+'</td>'); 
	     		}else{
	     	    //	noBooksDataFound();
	     			
	     			$("#idTableForPageDisplay").append('<td style="color: #545454; ">No Prescribed Book</td>');
	     			$('#iDProgressBarBooks').hide();
	     	    }
	     		
	        },
	        error: function () {
	        //    alert('Error');
	        }
	    });
    
    // alert($(xml).find("title").text());
	 
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=GoogleBookAPI&searchFor="+searchTermFromText,
	      //  contentType: "application/json; charset=utf-8",
	        beforeSend:removeBookList(),
	        async: true,
	     	success: function (googleBookAPIData) {
	     		
	     	//	 var googleBookAPIData='<?xml version="1.0" encoding="UTF-8"?><Results><Row Pinned="2"><VolAuth>Mark Ciampa</VolAuth><VolDesc>Reflecting the latest trends and developments from the information security field, best-selling Security+ Guide to Network Security Fundamentals, Fourth Edition, provides a complete introduction to practical network and computer security and maps to the CompTIA Security+ SY0-301 Certification Exam. The text covers the fundamentals of network security, including compliance and operational security; threats and vulnerabilities; application, data, and host security; access control and identity management; and cryptography. The updated edition includes new topics, such as psychological approaches to social engineering attacks, Web application attacks, penetration testing, data loss prevention, cloud computing security, and application programming development security. The new edition features activities that link to the Information Security Community Site, which offers video lectures, podcats, discussion boards, additional hands-on activities and more to provide a wealth of resources and up-to-the minute information. Important Notice: Media content referenced within the product description or the product text may not be available in the ebook version.</VolDesc><VolTitle>Security+ Guide to Network Security Fundamentals</VolTitle><RateCount>1</RateCount><AvgRating>5.0</AvgRating><PublishedDate>2011-07-25</PublishedDate><Publisher>Cengage Learning</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/CIHYWBrg9JQC</SelfLink><PreviewLink>http://books.google.com/books?id=CIHYWBrg9JQC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=1&amp;source=gbs_api</PreviewLink><PageCount>608</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Barry BuzanOle WÃ¦verJaap de Wilde</VolAuth><VolDesc>Two schools of thought now exist in security studies: traditionalists want to restrict the subject to politico-military issues; while wideners want to extend it to the economic, societal and environmental sectors. This book sets out a comprehensive statement of the new security studies, establishing the case for the broader agenda.</VolDesc><VolTitle>Security</VolTitle><RateCount>5</RateCount><AvgRating>4.5</AvgRating><PublishedDate>1998</PublishedDate><Publisher>Lynne Rienner Publishers</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/j4BGr-Elsp8C</SelfLink><PreviewLink>http://books.google.com/books?id=j4BGr-Elsp8C&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=2&amp;source=gbs_api</PreviewLink><PageCount>239</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Matt Bishop</VolAuth><VolDesc>The importance of computer security has increased dramatically during the past few years. Bishop provides a monumental reference for the theory and practice of computer security. Comprehensive in scope, this book covers applied and practical elements, theory, and the reasons for the design of applications and security techniques.</VolDesc><VolTitle>Computer Security</VolTitle><RateCount>8</RateCount><AvgRating>4.5</AvgRating><PublishedDate>2003</PublishedDate><Publisher>Addison-Wesley Professional</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/pfdBiJNfWdMC</SelfLink><PreviewLink>http://books.google.com/books?id=pfdBiJNfWdMC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=3&amp;source=gbs_api</PreviewLink><PageCount>1084</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Paleri</VolAuth><VolDesc>National security, in theory and practice, is about governing a nation for the well-being of the people. It is a group subject and is not the domain of a single expert of a kind. It is teamwork under leadership of excellence. What is important is the consistency of purpose providing comfort to the people of a national and thereby the people of the world in their physical, mental and emotional domains as an ongoing process throughout their lives.</VolDesc><VolTitle>National Security</VolTitle><RateCount>1</RateCount><AvgRating>5.0</AvgRating><PublishedDate>2008</PublishedDate><Publisher>Tata McGraw-Hill Education</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/DMzcGe0-HQwC</SelfLink><PreviewLink>http://books.google.com/books?id=DMzcGe0-HQwC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=4&amp;source=gbs_api</PreviewLink><PageCount>521</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Joseph J. Romm</VolAuth><VolDesc>Published by the Council on Foreign Relations Press, 58 East 68th St., New York, NY 10021. Annotation copyright by Book News, Inc., Portland, OR</VolDesc><VolTitle>Defining National Security</VolTitle><RateCount>1</RateCount><AvgRating>2.0</AvgRating><PublishedDate>1993</PublishedDate><Publisher>Council on Foreign Relations</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/shxDOnuVcyYC</SelfLink><PreviewLink>http://books.google.com/books?id=shxDOnuVcyYC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=5&amp;source=gbs_api</PreviewLink><PageCount>122</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Dieter Gollmann</VolAuth><VolDesc>This text moves away from the multi-level security approach to compare and evaluate design alternatives in computer security. It provides technology-proof insights, and covers the technical issues of computer security in the network environment.</VolDesc><VolTitle>Computer Security</VolTitle><RateCount>4</RateCount><AvgRating>4.5</AvgRating><PublishedDate>2011-02-28</PublishedDate><Publisher>John Wiley &amp; Sons</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/KTYxTfyjiOQC</SelfLink><PreviewLink>http://books.google.com/books?id=KTYxTfyjiOQC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=6&amp;source=gbs_api</PreviewLink><PageCount>436</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Peter J. Katzenstein</VolAuth><VolDesc>Contributors ask whether it is more useful to conceive of the world as arrayed in regional, cultural, institutional complexes or organized along the conventional dimensions of power, alliance, and geography. They argue that perspectives that neglect the roles of culture and identity are no longer adequate to explain the complexities of a world undergoing rapid change.</VolDesc><VolTitle>The Culture of National Security</VolTitle><RateCount/><AvgRating/><PublishedDate>1996-01</PublishedDate><Publisher>Columbia University Press</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/bPjkBhKWBOsC</SelfLink><PreviewLink>http://books.google.com/books?id=bPjkBhKWBOsC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=7&amp;source=gbs_api</PreviewLink><PageCount>562</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Richard E. Smith</VolAuth><VolDesc>Elementary Information Security is certified to comply fully with the NSTISSI 4011: the federal training standard for information security professionalsComprehensive and accessible, Elementary Information Security covers the entire range of topics required for US government courseware certification NSTISSI 4011 and urges students to analyze a variety of security problems while gaining experience with basic tools of the trade. Written for the one-term undergraduate course, the text emphasizes both the technical and non-technical aspects of information security and uses practical examples and real-world assessment tools. Early chapters in the text discuss individual computers and small LANS, while later chapters deal with distributed site security and the Internet. Cryptographic topics follow the same progression, starting on a single computer and evolving to Internet-level connectivity. Mathematical concepts throughout the text are defined and tutorials with mathematical tools are provided to ensure students grasp the information at hand. Rather than emphasizing memorization, this text challenges students to learn how to analyze a variety of security problems and gain experience with the basic tools of this growing trade.Key Features:-Covers all topics required by the US government curriculum standard NSTISSI 4011.- Unlike other texts on the topic, the author goes beyond defining the math concepts and provides students with tutorials and practice with mathematical tools, making the text appropriate for a broad range of readers.- Problem Definitions describe a practical situation that includes a security dilemma.- Technology Introductions provide a practical explanation of security technology to be used in the specific chapters- Implementation Examples show the technology being used to enforce the security policy at hand- Residual Risks describe the limitations to the technology and illustrate various tasks against it.- Each chapter includes worked examples of techniques students will need to be successful in the course. For instance, there will be numerous examples of how to calculate the number of attempts needed to crack secret information in particular formats; PINs, passwords and encryption keys.Instructor resources include an Instructors Manual, PowerPoint Lecture outlines, and a complete Test Bank.</VolDesc><VolTitle>Elementary Information Security</VolTitle><RateCount/><AvgRating/><PublishedDate>2011-10-18</PublishedDate><Publisher>Jones &amp; Bartlett Publishers</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/WrYRQi0BQDQC</SelfLink><PreviewLink>http://books.google.com/books?id=WrYRQi0BQDQC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=8&amp;source=gbs_api</PreviewLink><PageCount>890</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Michael WhitmanHerbert Mattord</VolAuth><VolDesc>Management of Information Security, Third Edition focuses on the managerial aspects of information security and assurance. Topics covered include access control models, information security governance, and information security program assessment and metrics. Coverage on the foundational and technical components of information security is included to reinforce key concepts. This new edition includes up-to-date information on changes in the field such as revised sections on national and international laws and international standards like the ISO 27000 series. With these updates, Management of Information Security continues to offer a unique overview of information security from a management perspective while maintaining a finger on the pulse of industry changes and academic relevance. Important Notice: Media content referenced within the product description or the product text may not be available in the ebook version.</VolDesc><VolTitle>Management of Information Security</VolTitle><RateCount/><AvgRating/><PublishedDate>2010-01-19</PublishedDate><Publisher>Cengage Learning</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/z23UjH0VUmMC</SelfLink><PreviewLink>http://books.google.com/books?id=z23UjH0VUmMC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=9&amp;source=gbs_api</PreviewLink><PageCount>592</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Paul Reid</VolAuth><VolDesc>Covering biometric options, ranging from fingerprint identification to eye scanning, this book describes guidelines, applications, and procedures for implementing them for network security systems. It is for security, system, and network administrators and managers, as well as those interested in the application of biometric technology.</VolDesc><VolTitle>Biometrics for Network Security</VolTitle><RateCount>1</RateCount><AvgRating>4.0</AvgRating><PublishedDate>2004-01</PublishedDate><Publisher>Prentice Hall Professional</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/NfPYJbxVvs0C</SelfLink><PreviewLink>http://books.google.com/books?id=NfPYJbxVvs0C&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=10&amp;source=gbs_api</PreviewLink><PageCount>252</PageCount><Language>en</Language></Row></Results>';
	     		 
	     		 xmlDoc = $.parseXML( googleBookAPIData ),
	     		    $xml = $( xmlDoc );
	     		 
	     		    $($xml).find("Results>Row").each(function(i){
	     		    	
	     		    	var bookTitle=$(this).find('Results>Row>VolTitle').text();
	     		    	var bookAuthor=$(this).find('Results>Row>VolAuth').text();
	     		    	var bookURL=$(this).find('Results>Row>PreviewLink').text();
	     		    	
	     		    	if(i<5){
	     		    	$("#idBooksList ul").append('<li style="list-style-type: none;"><a target="_blank" style="color: #1a0dab; text-decoration: none;" href='+bookURL+'><span class="tab truncate"><b>'+bookTitle+'</b></span></a><br /><span style="list-style-type: none; color:#545454 ;" >'+bookAuthor+'</span></li>');
	     		    }else{
	     		    	
	     		    }
	     		    });
	     		
	        },
	        error: function () {
	        //    alert('Error');
	        }
	    });
	
		
	 
	/* var xml;
		var googleBookAPIData='<?xml version="1.0" encoding="UTF-8"?><Results><Row Pinned="2"><VolAuth>Mark Ciampa</VolAuth><VolDesc>Reflecting the latest trends and developments from the information security field, best-selling Security+ Guide to Network Security Fundamentals, Fourth Edition, provides a complete introduction to practical network and computer security and maps to the CompTIA Security+ SY0-301 Certification Exam. The text covers the fundamentals of network security, including compliance and operational security; threats and vulnerabilities; application, data, and host security; access control and identity management; and cryptography. The updated edition includes new topics, such as psychological approaches to social engineering attacks, Web application attacks, penetration testing, data loss prevention, cloud computing security, and application programming development security. The new edition features activities that link to the Information Security Community Site, which offers video lectures, podcats, discussion boards, additional hands-on activities and more to provide a wealth of resources and up-to-the minute information. Important Notice: Media content referenced within the product description or the product text may not be available in the ebook version.</VolDesc><VolTitle>Security+ Guide to Network Security Fundamentals</VolTitle><RateCount>1</RateCount><AvgRating>5.0</AvgRating><PublishedDate>2011-07-25</PublishedDate><Publisher>Cengage Learning</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/CIHYWBrg9JQC</SelfLink><PreviewLink>http://books.google.com/books?id=CIHYWBrg9JQC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=1&amp;source=gbs_api</PreviewLink><PageCount>608</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Barry BuzanOle WÃ¦verJaap de Wilde</VolAuth><VolDesc>Two schools of thought now exist in security studies: traditionalists want to restrict the subject to politico-military issues; while wideners want to extend it to the economic, societal and environmental sectors. This book sets out a comprehensive statement of the new security studies, establishing the case for the broader agenda.</VolDesc><VolTitle>Security</VolTitle><RateCount>5</RateCount><AvgRating>4.5</AvgRating><PublishedDate>1998</PublishedDate><Publisher>Lynne Rienner Publishers</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/j4BGr-Elsp8C</SelfLink><PreviewLink>http://books.google.com/books?id=j4BGr-Elsp8C&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=2&amp;source=gbs_api</PreviewLink><PageCount>239</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Matt Bishop</VolAuth><VolDesc>The importance of computer security has increased dramatically during the past few years. Bishop provides a monumental reference for the theory and practice of computer security. Comprehensive in scope, this book covers applied and practical elements, theory, and the reasons for the design of applications and security techniques.</VolDesc><VolTitle>Computer Security</VolTitle><RateCount>8</RateCount><AvgRating>4.5</AvgRating><PublishedDate>2003</PublishedDate><Publisher>Addison-Wesley Professional</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/pfdBiJNfWdMC</SelfLink><PreviewLink>http://books.google.com/books?id=pfdBiJNfWdMC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=3&amp;source=gbs_api</PreviewLink><PageCount>1084</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Paleri</VolAuth><VolDesc>National security, in theory and practice, is about governing a nation for the well-being of the people. It is a group subject and is not the domain of a single expert of a kind. It is teamwork under leadership of excellence. What is important is the consistency of purpose providing comfort to the people of a national and thereby the people of the world in their physical, mental and emotional domains as an ongoing process throughout their lives.</VolDesc><VolTitle>National Security</VolTitle><RateCount>1</RateCount><AvgRating>5.0</AvgRating><PublishedDate>2008</PublishedDate><Publisher>Tata McGraw-Hill Education</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/DMzcGe0-HQwC</SelfLink><PreviewLink>http://books.google.com/books?id=DMzcGe0-HQwC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=4&amp;source=gbs_api</PreviewLink><PageCount>521</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Joseph J. Romm</VolAuth><VolDesc>Published by the Council on Foreign Relations Press, 58 East 68th St., New York, NY 10021. Annotation copyright by Book News, Inc., Portland, OR</VolDesc><VolTitle>Defining National Security</VolTitle><RateCount>1</RateCount><AvgRating>2.0</AvgRating><PublishedDate>1993</PublishedDate><Publisher>Council on Foreign Relations</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/shxDOnuVcyYC</SelfLink><PreviewLink>http://books.google.com/books?id=shxDOnuVcyYC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=5&amp;source=gbs_api</PreviewLink><PageCount>122</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Dieter Gollmann</VolAuth><VolDesc>This text moves away from the multi-level security approach to compare and evaluate design alternatives in computer security. It provides technology-proof insights, and covers the technical issues of computer security in the network environment.</VolDesc><VolTitle>Computer Security</VolTitle><RateCount>4</RateCount><AvgRating>4.5</AvgRating><PublishedDate>2011-02-28</PublishedDate><Publisher>John Wiley &amp; Sons</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/KTYxTfyjiOQC</SelfLink><PreviewLink>http://books.google.com/books?id=KTYxTfyjiOQC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=6&amp;source=gbs_api</PreviewLink><PageCount>436</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Peter J. Katzenstein</VolAuth><VolDesc>Contributors ask whether it is more useful to conceive of the world as arrayed in regional, cultural, institutional complexes or organized along the conventional dimensions of power, alliance, and geography. They argue that perspectives that neglect the roles of culture and identity are no longer adequate to explain the complexities of a world undergoing rapid change.</VolDesc><VolTitle>The Culture of National Security</VolTitle><RateCount/><AvgRating/><PublishedDate>1996-01</PublishedDate><Publisher>Columbia University Press</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/bPjkBhKWBOsC</SelfLink><PreviewLink>http://books.google.com/books?id=bPjkBhKWBOsC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=7&amp;source=gbs_api</PreviewLink><PageCount>562</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Richard E. Smith</VolAuth><VolDesc>Elementary Information Security is certified to comply fully with the NSTISSI 4011: the federal training standard for information security professionalsComprehensive and accessible, Elementary Information Security covers the entire range of topics required for US government courseware certification NSTISSI 4011 and urges students to analyze a variety of security problems while gaining experience with basic tools of the trade. Written for the one-term undergraduate course, the text emphasizes both the technical and non-technical aspects of information security and uses practical examples and real-world assessment tools. Early chapters in the text discuss individual computers and small LANS, while later chapters deal with distributed site security and the Internet. Cryptographic topics follow the same progression, starting on a single computer and evolving to Internet-level connectivity. Mathematical concepts throughout the text are defined and tutorials with mathematical tools are provided to ensure students grasp the information at hand. Rather than emphasizing memorization, this text challenges students to learn how to analyze a variety of security problems and gain experience with the basic tools of this growing trade.Key Features:-Covers all topics required by the US government curriculum standard NSTISSI 4011.- Unlike other texts on the topic, the author goes beyond defining the math concepts and provides students with tutorials and practice with mathematical tools, making the text appropriate for a broad range of readers.- Problem Definitions describe a practical situation that includes a security dilemma.- Technology Introductions provide a practical explanation of security technology to be used in the specific chapters- Implementation Examples show the technology being used to enforce the security policy at hand- Residual Risks describe the limitations to the technology and illustrate various tasks against it.- Each chapter includes worked examples of techniques students will need to be successful in the course. For instance, there will be numerous examples of how to calculate the number of attempts needed to crack secret information in particular formats; PINs, passwords and encryption keys.Instructor resources include an Instructors Manual, PowerPoint Lecture outlines, and a complete Test Bank.</VolDesc><VolTitle>Elementary Information Security</VolTitle><RateCount/><AvgRating/><PublishedDate>2011-10-18</PublishedDate><Publisher>Jones &amp; Bartlett Publishers</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/WrYRQi0BQDQC</SelfLink><PreviewLink>http://books.google.com/books?id=WrYRQi0BQDQC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=8&amp;source=gbs_api</PreviewLink><PageCount>890</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Michael WhitmanHerbert Mattord</VolAuth><VolDesc>Management of Information Security, Third Edition focuses on the managerial aspects of information security and assurance. Topics covered include access control models, information security governance, and information security program assessment and metrics. Coverage on the foundational and technical components of information security is included to reinforce key concepts. This new edition includes up-to-date information on changes in the field such as revised sections on national and international laws and international standards like the ISO 27000 series. With these updates, Management of Information Security continues to offer a unique overview of information security from a management perspective while maintaining a finger on the pulse of industry changes and academic relevance. Important Notice: Media content referenced within the product description or the product text may not be available in the ebook version.</VolDesc><VolTitle>Management of Information Security</VolTitle><RateCount/><AvgRating/><PublishedDate>2010-01-19</PublishedDate><Publisher>Cengage Learning</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/z23UjH0VUmMC</SelfLink><PreviewLink>http://books.google.com/books?id=z23UjH0VUmMC&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=9&amp;source=gbs_api</PreviewLink><PageCount>592</PageCount><Language>en</Language></Row><Row Pinned="2"><VolAuth>Paul Reid</VolAuth><VolDesc>Covering biometric options, ranging from fingerprint identification to eye scanning, this book describes guidelines, applications, and procedures for implementing them for network security systems. It is for security, system, and network administrators and managers, as well as those interested in the application of biometric technology.</VolDesc><VolTitle>Biometrics for Network Security</VolTitle><RateCount>1</RateCount><AvgRating>4.0</AvgRating><PublishedDate>2004-01</PublishedDate><Publisher>Prentice Hall Professional</Publisher><SelfLink>https://www.googleapis.com/books/v1/volumes/NfPYJbxVvs0C</SelfLink><PreviewLink>http://books.google.com/books?id=NfPYJbxVvs0C&amp;printsec=frontcover&amp;dq=security&amp;hl=&amp;cd=10&amp;source=gbs_api</PreviewLink><PageCount>252</PageCount><Language>en</Language></Row></Results>';
			
		if(googleBookAPIData.trim()!=='false'){
				
	 		
	 		xml=googleBookAPIData;
	 		xmlDoc = $.parseXML( xml ),
	 	     $xml = $( xmlDoc );
	 		
	 		
	 		if($($xml).find("result>hits").attr('computed')!=='0'){
	 			
	 		//	$('#iDProgressBarArticle').hide();
	 	     $($xml).find("result>hits>hit>info").each(function(i){
	 		if(i<4){
	 			
	 			var author='<b>Authors - </b>';
	 			 $(this).find("authors").each(function(i){
	 				 
	 				author=author+$(this).find("author").text()+' <b>|</b> ';
	 			 });
	 			 
	 			var count=i;
	 			count=count+1;
	 			var theURL = $(this).find("title").text();
	    			var pieceOneTitle = theURL.substr(0,80);
	    			var pieceTwoTitle = theURL.substr(80, 75);

	 			       $("#idBooksList ul").append('<li style="list-style-type: none;"><a target="_blank" style="color: #1a0dab; text-decoration: none;" href='+$(this).find('title').attr('ee') +'><span class="tab truncate"><b>'+count+'.  '+pieceOneTitle+'-<br />' +pieceTwoTitle+'</b></span></a>		'+'<br />'+'<span style="list-style-type: none; color:#545454 ;" >'+author+'</span></li>');
	 			}else{

	 			}    
	 			}); 
	 		 }else{
	 			noArticleDataFound();
	 		 }
	 		}else{
	 			
	 			noArticleDataFound();
	 			
	 		}*/
     
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
	
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	$("#idTableForPageDisplay td:last-child").remove();
	
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