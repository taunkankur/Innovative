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
  
  a.ex5:hover, a.ex5:active {text-decoration: underline;}
</style>

  <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/redmond/jquery-ui.css" rel="stylesheet" type="text/css"/>
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script type="text/javascript">
var pageNumber;
var searchName;
function  loadMe() {
	$('#iDProgressBar').show();
	$('#idPageView').hide();
	
	
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
	pageNumber=$.QueryString["pageNumber"];
	if(searchName==="refresh"){
		
	}
	
 if(pageNumber.indexOf('.') >= 0)
pageNumber=pageNumber.split('.')[1].trim(); 

	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Book&searchFor="+searchName,
	
	        async: false,
	     	success: function (d) {
	     		$('#idPageView').show();
	     		$('#iDProgressBar').hide();
	     		 xml=d;
	     		
	        },
	        error: function () {
	            alert('Error');
	        }
	    });
    
    // alert($(xml).find("title").text());
     xmlDoc = $.parseXML( xml ),
     $xml = $( xmlDoc );
     var BookPage= $($xml).find("OwlRootNode>BookPage").text().split(',');
     
     
     $.each(BookPage , function(i, val) { 
    	 if(i===0 && BookPage[0]===''){
    		 alert('No Book Pages');
    	 }else{
    		 
    		 if(BookPage[i]!==''){
    		
        		 $('ul').append('<li><a class="ex5"  >'+BookPage [i]+'</a></li>');
        	 }
    	 }
    	 
    });
    
     
     var offset=20;
     $('#idPageView').attr('src','http://localhost:8080/PDFHighlight/NewFile.jsp?PageNumber='+pageNumber+'&WordToHighLight='+searchName);
     $(document).ready(function() {
 	    
    	 $('a','#idPageList').click(function(){
    		  var currentAnchor = $(this);
    		  pageNumber=currentAnchor.text();
    		  pageNumber=((pageNumber*1) + (offset*1));
    		  
    		  
    		  $('#idPageView').attr('src','http://localhost:8080/PDFHighlight/NewFile.jsp?PageNumber='+pageNumber+'&WordToHighLight='+searchName);
    		//  alert(currentAnchor.text());
    		  
    		});
 	    	
 	   
 	});
     
     
}

function loadXMLDoc() {
	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://ec2-54-148-7-18.us-west-2.compute.amazonaws.com/rest/api/book/"+searchName, false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText;
}
</script>
<style type="text/css">
html,body,iframe {
	height: 99%;
	width: 100%;
}
</style>
</head>

<body onload='loadMe()'>

<table border="0" width="100%" height="100%">
<tr >
<td width="10%" align="left">
<div >
<h3 style="color: grey;font: italic bold 20px/30px Georgia, serif;"><code>Select Page</code></h3>
  <ul id="idPageList" style="color: grey;font: italic bold 15px/25px Georgia, serif;">


</ul>
</div>
</td>
<td>
<div align="left" >
<iframe src="" style="width:100%; height:800px; " frameborder="0" id='idPageView' scrolling="no"></iframe>
</div>
</td>
</tr>
</table>
<div id="iDProgressBar" align="center" style="padding-top: ">
		<img alt="" src="../Image/loader_wide.gif" width="50%" height="50%">
	</div>
</body>
</html>