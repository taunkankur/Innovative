<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.lang.*"%>

<html>
<head>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>


<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.4/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script>
	
	
<script>
$(document).ready(function(){
	
	
	
	$("#action-button").click(function(){
		
		
		
		   $.ajax({
			   url:"http://localhost:8080/WebServiceOntology/rest/api/slides/"+$('#textId').val(),
			   success:function(result){
		    $("#myDiv").html(result);
		    
		    xmlDoc = $.parseXML( result ),
		     $xml = $( xmlDoc );
		     $($xml).find("Slideshows>Slideshow").each(function(){
		    var VedTitle=$(this).find('Slideshows>Slideshow>Title').text();
		      var VedThumbNail=$(this).find('Slideshows>Slideshow>Embed').text();
		       var VedDesc=$(this).find('Slideshows>Slideshow>Description').text();
		       var PublishedDateTime=$(this).find('Slideshows>Slideshow>Created').text();
		       var UpdatedDateTime=$(this).find('Slideshows>Slideshow>Updated').text();
		        $('#table_id > tbody:last').append('<tr> <td  ><a href="" data-lightbox="image-1" data-title="My caption"></a>'+VedThumbNail+'</td><td>'+VedTitle+'</td><td>'+VedDesc+'</td><td>'+PublishedDateTime+'</td><td>'+UpdatedDateTime+'</td></tr>');

		     
		      });
		 
		    	 $('#table_id').DataTable();
		    	
		    	      
		    	  
		    	   
		     
	
		     } });
		    
		  
		  
			
		});	
});


  
</script>




<script type="text/javascript">

var searchName;
function  loadMe() {
	
	(function($) {
	    $.QueryString = (function(a) {
	        if (a == "") return {};
	        var b = {};
	        for (var i = 0; i < a.length; ++i)
	        {
	            var p=a[i].split('=');
	            if (p.length != 2) continue;
	            b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
	        }
	        return b;
	    })(window.location.search.substr(1).split('&'))
	})(jQuery);
	
	searchName=$.QueryString["SearchName"];
	
	xml= loadXMLDoc();
    
    // alert($(xml).find("title").text());
     xmlDoc = $.parseXML( xml ),
     $xml = $( xmlDoc );
     console.log($xml);
     $($xml).find("Slideshows>Slideshow").each(function(){
		    var VedTitle=$(this).find('Slideshows>Slideshow>Title').text();
		      var VedThumbNail=$(this).find('Slideshows>Slideshow>Embed').text();
		       var VedDesc=$(this).find('Slideshows>Slideshow>Description').text();
		       var PublishedDateTime=$(this).find('Slideshows>Slideshow>Created').text();
		       var UpdatedDateTime=$(this).find('Slideshows>Slideshow>Updated').text();
		        $('#table_id > tbody:last').append('<tr> <td  ><a href="" data-lightbox="image-1" data-title="My caption"></a>'+VedThumbNail+'</td><td>'+VedTitle+'</td><td>'+VedDesc+'</td><td>'+PublishedDateTime+'</td><td>'+UpdatedDateTime+'</td></tr>');

		     
		      });
     $('#table_id').DataTable();
    

}

function loadXMLDoc() {
	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://cis.csi.cuny.edu:8080/WebServiceOntology/rest/api/slides/"+searchName, false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText;
}
</script>


<script type=javascript>
 


</script>
 <style type="text/css">
.CSSTableGenerator {
	margin:0px;padding:0px;
	width:100%;
	box-shadow: 10px 10px 5px #888888;
	border:1px solid #ffffff;
	
	-moz-border-radius-bottomleft:0px;
	-webkit-border-bottom-left-radius:0px;
	border-bottom-left-radius:0px;
	
	-moz-border-radius-bottomright:0px;
	-webkit-border-bottom-right-radius:0px;
	border-bottom-right-radius:0px;
	
	-moz-border-radius-topright:0px;
	-webkit-border-top-right-radius:0px;
	border-top-right-radius:0px;
	
	-moz-border-radius-topleft:0px;
	-webkit-border-top-left-radius:0px;
	border-top-left-radius:0px;
}.CSSTableGenerator table{
    border-collapse: collapse;
        border-spacing: 0;
	width:100%;
	height:100%;
	margin:0px;padding:0px;

</style>
</head>

<body onload='loadMe()'>








<table border="1" id="table_id" class="display">
<thead>

<tr >

  <td > Slide </td>

  <td >Title</td>
  <td >Description</td>
  <td >PublishedDateTime</td>
  <td >UpdatedDateTime</td>

  </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>



</body>
</html>