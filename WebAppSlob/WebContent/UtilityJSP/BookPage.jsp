<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#image {
  line-height: 1.5em;
  list-style-image: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/4621/treehouse-marker.png);
  
  }
</style>

  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
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
	if(searchName==="refresh"){
		
	}
	
	xml= loadXMLDoc();
    
    // alert($(xml).find("title").text());
     xmlDoc = $.parseXML( xml ),
     $xml = $( xmlDoc );
     var BookPage= $($xml).find("OwlRootNode>BookPage").text().split(',');
     
     
     $.each(BookPage , function(i, val) { 
    	 if(i===0 && BookPage[0]===''){
    		 alert('No Book Pages');
    	 }else{
    		 
    		 if(BookPage[i]!==''){
    		
        		 $('ul').append('<li><a >'+BookPage [i]+'</a></li>');
        	 }
    	 }
    	 
    });
    
     
     $(document).ready(function() {
 	    
    	 $('a','#idPageList').click(function(){
    		  var currentAnchor = $(this);
    		  
    		  $('#idPageView').attr('src','http://docs.google.com/gview?url=http://cis.csi.cuny.edu/slob/static/textbook/goodrich/'+currentAnchor.text() +'.docx&embedded=true');
    		//  alert(currentAnchor.text());
    		  
    		});
 	    	
 	   
 	});
     
     
}

function loadXMLDoc() {
	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://cis.csi.cuny.edu:8080/WebServiceOntology/rest/api/book/"+searchName, false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText;
}
</script>
</head>
<body onload='loadMe()'>

<table border="0">
<tr >
<td width="300px" >
<div >
<h3><code>Select Page</code></h3>
  <ul id="idPageList">


</ul>
</div>
</td>
<td>
<div align="center">
<iframe src="" style="width:900px; height:800px;" frameborder="0" id='idPageView'></iframe>
</div>
</td>
</tr>
</table>

</body>
</html>