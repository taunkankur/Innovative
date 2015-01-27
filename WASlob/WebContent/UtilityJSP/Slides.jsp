<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.lang.*"%>

<html>
<head>

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript" src="../Script/sortable.js"></script> 
<link href="http://www.joostdevalk.nl/" rev="made" />
 <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<!-- <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.4/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="http://cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script> -->
	
<style type="text/css">

a img {
	border: 0;
}
table.sortable {
	border-spacing: 0;
	border: 1px solid #000;
	border-collapse: collapse;
}
table.sortable th, table.sortable td {
	text-align: left;
	padding: 2px 4px 2px 4px;
	width: 100px;
	border-style: solid;
	border-color: #444;
}
table.sortable th {
	border-width: 1px 1px 1px 1px;
	background-color: #ccc;
	border-color: gray;
}
table.sortable td {
	border-width: 1px 1px 1px 1px;
	border-color: gray;
}
table.sortable tr.odd td {
	background-color: #fff;
}
table.sortable tr.even td {
	background-color: #fff;
}
table.sortable tr.sortbottom td {
	border-top: 1px solid #444;
	background-color: #ccc;
	font-weight: bold;
}



a:link {color:blue;text-decoration:none;}
a:visited {color:#800080;text-decoration:none;}
a:hover {text-decoration:underline;background-color: rgb(218, 222, 224);}
</style>
<script>



  
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
	
	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Slides&searchFor="+searchName,
	      //  contentType: "application/json; charset=utf-8",
	        async: false,
	     	success: function (d) {
	     		 xml=d;
	     		
	        },
	        error: function () {
	            alert('Error');
	        }
	    });
    
    // alert($(xml).find("title").text());
     xmlDoc = $.parseXML( xml ),
     $xml = $( xmlDoc );
     console.log($xml);
     
     $($xml).find("Slideshows>Slideshow").each(function(){
    	 var url=$(this).find('Slideshows>Slideshow>URL').text();
		    var VedTitle=$(this).find('Slideshows>Slideshow>Title').text();
		      var VedThumbNail=$(this).find('Slideshows>Slideshow>ThumbnailSmallURL').text();
		       var VedDesc=$(this).find('Slideshows>Slideshow>Description').text();
		       var PublishedDateTime=$(this).find('Slideshows>Slideshow>Created').text();
		       var UpdatedDateTime=$(this).find('Slideshows>Slideshow>Updated').text();
		        $('#table_id > tbody:last').append('<tr> <td  ><a href="" data-lightbox="image-1" data-title="My caption"></a><img alt="" src="'+VedThumbNail+'"></td><td><a href="'+url+'"  target="blank">'+VedTitle+'</a></td><td>'+VedDesc+'</td><td>'+PublishedDateTime+'</td><td>'+UpdatedDateTime+'</td></tr>');

		     
		      });
   //  $('#table_id').DataTable();
    

}

function loadXMLDoc() {
	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://ec2-54-148-7-18.us-west-2.compute.amazonaws.com/rest/api/slides/"+searchName, false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText;
}
</script>


<script type=javascript>
 


</script>
<!--  <style type="text/css">
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

</style> -->

<style type="text/css">
.headerSortDown:after,
.headerSortUp:after{
    content: ' ';
    position: relative;
    left: 10px;
    border: 8px solid transparent;
}
.headerSortDown:after{

    top: 15px;
    border-top-color: silver;
}
.headerSortUp:after{
    bottom: 30px;
    border-bottom-color: silver;
}
</style>
</head>

<body onload='loadMe()'>
<br><br>
<div id="idContainer" align="center" >

<table border="1" id="table_id" class="sortable pure-table" style="width: 96%; box-shadow: 10px 10px 5px #888888;" >
<thead>

<tr >

  <td class="  headerSortDown  " style="width: 3%" align="center" > Slide </td>

  <td class="  headerSortDown  " style="width: 7%">Title</td>
  <td class="  headerSortDown  " style="width: 40%" align="center" >Description</td>
  <td class="  headerSortDown  " style="width: 13%">Published Time</td>
  <td class="  headerSortDown  "  style="width: 13%">Updated Time</td>

  </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>
</div>


</body>
</html>