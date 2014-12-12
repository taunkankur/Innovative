<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
	background-color:#6699cc;

	border:1px solid #ffffff;
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
}</style>
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
     
     var description=$($xml).find('OwlRootNode>Description').text();
     var nistDescription=$($xml).find('OwlRootNode>NistDef').text();
     var SuperClass= $($xml).find("OwlRootNode>SuperClass").text().split('|');
     var SubClass= $($xml).find("OwlRootNode>SubClass").text().split('|');
     var EquivalentClass= $($xml).find("OwlRootNode>EquivalentClass").text().split('|');
    
     if(description!=='' || nistDescription!==''){
    	 
    	 if(description!=='')
    		 $('#idTableDescription > tbody:last').append('<tr><td>GENRAL : '+description+'</td></tr>');
    	 else
    		 $('#idTableDescription > tbody:last').append('<tr><td>GENRAL : NO Description</td></tr>');
    	 
    	 if(nistDescription!=='')
    		 $('#idTableDescription > tbody:last').append('<tr><td>NIST : '+nistDescription+'</td></tr>');
    	 else
    		 $('#idTableDescription > tbody:last').append('<tr><td>NIST : NO Desctiption</td></tr>');
     }else{
    	 $('#idTableDescription > tbody:last').append('<tr><td>NO DESCRIPTION</td></tr>');
     }
     
    
 
   
     
     $.each(SuperClass , function(i, val) { 
    	 if(i===0 && SuperClass[0]===''){
    		 $('#idTableSuperClass > tbody:last').append('<tr><td>No Classes Found</td></tr>');
    	 }else{
    		 
    		 if(SuperClass[i]!==''){
        		 $('#idTableSuperClass > tbody:last').append('<tr><td>'+SuperClass [i]+'</td></tr>');
        	 }
    	 }
    	 
    });


     
     $.each(SubClass , function(i, val) { 
    	 if(i===0 && SubClass[i]===''){
    		 $('#idTableSubClass > tbody:last').append('<tr><td>No Classes Found</td></tr>');
    	 }else{
    		 
    		 if(SubClass[i]!==''){
        		 $('#idTableSubClass > tbody:last').append('<tr><td>'+SubClass [i]+'</td></tr>');
        	 }
    	 }
    	 
    });
     
     
     $.each(EquivalentClass , function(i, val) { 
    	 if(i===0 && EquivalentClass[i]===''){
    		 $('#idTableEquivalentClass > tbody:last').append('<tr><td>No Classes Found</td></tr>');
    	 }else{
    		 
    		 if(EquivalentClass[i]!==''){
        		 $('#idTableEquivalentClass > tbody:last').append('<tr><td>'+EquivalentClass [i]+'</td></tr>');
        	 }
    	 }
    	 
    });
     
}

function loadXMLDoc() {
	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://cis.csi.cuny.edu:8080/WebServiceOntology/rest/api/description/"+searchName, false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText;
}
</script>
</head>
<body onload="loadMe()">
<div class="CSSTableGenerator"  >
<table id="idTableDescription" border="1" align="center">
<thead><tr><td>Description</td></tr></thead>
  <tbody>
    <tr></tr>
  </tbody>
</table>
</div>
<br><br>
<div class="CSSTableGenerator"  >
<table id="idTableSuperClass" border="1" align="center">
<thead><tr><td>Super  Classes</td></tr></thead>
  <tbody>
    <tr></tr>
  </tbody>
</table>
</div>
<br><br>
<div class="CSSTableGenerator"  >
<table id="idTableSubClass" border="1" align="center">
<thead><tr><td>Sub  Classes</td></tr></thead>
  <tbody>
    <tr></tr>
  </tbody>
</table>
</div>
<br><br>
<div class="CSSTableGenerator"  >
<table id="idTableEquivalentClass" border="1" align="center">
<thead><tr><td>Equivalent  Classes</td></tr></thead>
  <tbody>
    <tr></tr>
  </tbody>
</table>
</div>
</body>
</html>