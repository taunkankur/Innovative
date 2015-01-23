<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<!--    <style type="text/css">
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
}.CSSTableGenerator tr:last-child td:last-child {
	-moz-border-radius-bottomright:0px;
	-webkit-border-bottom-right-radius:0px;
	border-bottom-right-radius:0px;
}
.CSSTableGenerator table tr:first-child td:first-child {
	-moz-border-radius-topleft:0px;
	-webkit-border-top-left-radius:0px;
	border-top-left-radius:0px;
}
.CSSTableGenerator table tr:first-child td:last-child {
	-moz-border-radius-topright:0px;
	-webkit-border-top-right-radius:0px;
	border-top-right-radius:0px;
}.CSSTableGenerator tr:last-child td:first-child{
	-moz-border-radius-bottomleft:0px;
	-webkit-border-bottom-left-radius:0px;
	border-bottom-left-radius:0px;
}.CSSTableGenerator tr:hover td{
	background-color:#cccccc;
		

}
.CSSTableGenerator td{
	vertical-align:middle;
	
	background-color:white;

	border:1px solid #C3C2C2;
	border-width:0px 1px 1px 0px;
	text-align:left;
	padding:7px;
	font-size:15px;
	font-family:Arial;
	font-weight:normal;
	color:#000000;
}.CSSTableGenerator tr:last-child td{
	border-width:0px 1px 0px 0px;
}.CSSTableGenerator tr td:last-child{
	border-width:0px 0px 1px 0px;
}.CSSTableGenerator tr:last-child td:last-child{
	border-width:0px 0px 0px 0px;
}
.CSSTableGenerator tr:first-child td{
		background:-o-linear-gradient(bottom, #003366 5%, #003f7f 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #003366), color-stop(1, #003f7f) );
	background:-moz-linear-gradient( center top, #003366 5%, #003f7f 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#003366", endColorstr="#003f7f");	background: -o-linear-gradient(top,#003366,003f7f);

	background-color:#003366;
	border:0px solid #ffffff;
	text-align:center;
	border-width:0px 0px 1px 1px;
	font-size:14px;
	font-family:Arial;
	font-weight:bold;
	color:#ffffff;
}
.CSSTableGenerator tr:first-child:hover td{
	background:-o-linear-gradient(bottom, #003366 5%, #003f7f 100%);	background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #003366), color-stop(1, #003f7f) );
	background:-moz-linear-gradient( center top, #003366 5%, #003f7f 100% );
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr="#003366", endColorstr="#003f7f");	background: -o-linear-gradient(top,#003366,003f7f);

	background-color:#003366;
}
.CSSTableGenerator tr:first-child td:first-child{
	border-width:0px 0px 1px 0px;
}
.CSSTableGenerator tr:first-child td:last-child{
	border-width:0px 0px 1px 1px;
}

</style> -->

<style type="text/css">
a:hover {
    background-color: rgb(218, 222, 224);
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
	
	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Article&searchFor="+searchName.replace(" ", ""),
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
     $($xml).find("result>hits>hit>info").each(function(){
       // alert($(this).find("result>hits>hit[id=2362951]>info>title").text());
        $( "#div1" ).append( $(this).find("result>hits>hit>info>title").text() );
      //alert($($xml).find("result>hits>hit>info>year").text());
        $('#myTable > tbody:last').append('<tr><td align="left" ><a target="_blank" style="color: #000000; text-decoration: none;" href='+$(this).find('title').attr('ee') +'>'+$(this).find('title').text()+'</a></td> <td>'+$(this).find("year").text()+'</td></tr>');
      });
}

/*  function loadXMLDoc() {
 	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://ec2-54-148-7-18.us-west-2.compute.amazonaws.com/rest/api/article/"+searchName, false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText; 
    
    
    $.get("http://localhost:8080/WSOntology/rest/api/article/"+searchName,
    		  function(data){
    	return data;
    		    alert("Data Loaded: " + data);
    		  });
}  */
</script>
</head>
<body onload="loadMe()" >
<br><br>


<div class="CSSTableGenerator" align="center">
<table id="myTable" border="1" align="center" class=" pure-table pure-table-bordered " style="box-shadow: 10px 10px 5px #888888;" width="98%">
<thead >
        <tr>
            <th align="center" >DBLP Article</th>
           
            <th>Year</th>
        </tr>
    </thead>
  <tbody>
    <tr></tr>
  </tbody>
</table>
</div>
</body>
</html>