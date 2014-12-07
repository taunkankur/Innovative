<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
<script type="text/javascript" src="../Script/jquery.youtubepopup.min.js"></script>

<link rel="stylesheet" type="text/css" href="//cdn.datatables.net/1.10.4/css/jquery.dataTables.css">

<script type="text/javascript" charset="utf8" src="//cdn.datatables.net/1.10.4/js/jquery.dataTables.js"></script>
<script type="text/javascript">
$(document).ready( function () {
  
} );
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
     $($xml).find("Results>Row").each(function(){
       // alert($(this).find("result>hits>hit[id=2362951]>info>title").text());
        //$( "#div1" ).append( $(this).find("Results>Row>VedTitle").text() );
      //alert($($xml).find("result>hits>hit>info>year").text());
      
      var VedTitle=$(this).find('Results>Row>VedTitle').text();
      var VedThumbNail=$(this).find('Results>Row>VedThumbNail').text();
      var VedURL=$(this).find('Results>Row>VedURL').text();
      var ViewCount=$(this).find('Results>Row>ViewCount').text();
      var NumLikes=$(this).find('Results>Row>NumLikes').text();
      var NumDislikes=$(this).find('Results>Row>NumDislikes').text();
      var NumRaters=$(this).find('Results>Row>NumRaters').text();
      var PublishedDateTime=$(this).find('Results>Row>PublishedDateTime').text();
        $('#table_id > tbody:last').append('<tr> <td> <img alt="" src="'+VedThumbNail+'"> </td><td><a class="youtube"  href="" id="'+VedURL+'">'+VedTitle+'</a></td><td>'+ViewCount+'</td><td>'+NumLikes+'</td><td>'+NumDislikes+'</td><td>'+NumRaters+'</td><td>'+PublishedDateTime+'</td></tr>');
       
      });
     $('#table_id').DataTable();
     $("a.youtube").YouTubePopup({ idAttribute: 'id' });

}

function loadXMLDoc() {
	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://localhost:8080/WebServiceOntology/rest/api/video/Electronic Token", false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText;
}
</script>
<script type="text/javascript">
$(function () {
	
	
});
</script>
</head>

  <body onload="loadMe()">
<!--   <table border="1" id="table_id" class="display">
  <thead>
  <tr>
  <td> Video </td>
  <td>Topic</td>
  <td>View Count</td>
  <td>No oF Likes</td>
  <td>No oF DisLikes</td>
  <td>No oF Raters</td>
  <td>PublishedDateTime</td>

  </tr>
  </thead>
     <tbody>
  <tr>
  <td> <img alt="" src=""> </td>
  <td><a class="youtube"  href="" id="XTsaZWzVJ4c">Ontology</a></td>
  <td>1234</td>
  <td>2</td>
  <td>5</td>
  <td>22</td>
  </tr>
  
    <tr>
  <td> <img alt="" src=""></td>
  <td><a class="youtube"  href="" id="yFRc-wpQc9c">Security</a></td>
  <td>123554</td>
  <td>22</td>
  <td>35</td>
  <td>222</td>
  </tr>
  
   <tr>
  <td> <img alt="" src=""></td>
  <td><a class="youtube"  href="" id="wtVIhGGdJvE">Network</a></td>
  <td>12343</td>
  <td>223</td>
  <td>352</td>
  <td>2212</td>
  </tr>
  </tbody>
  </table> -->


<table border="1" id="table_id" class="display">
  <thead>
  <tr>
  <td> Video </td>
  <td>Topic</td>
  <td>View Count</td>
  <td>No oF Likes</td>
  <td>No oF DisLikes</td>
  <td>No oF Raters</td>
  <td>PublishedDateTime</td>

  </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>
  </body>
  
</html>