<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
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
	$('#idSearchedWord').html(searchName);
	
	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Description&searchFor="+searchName,
	      //  contentType: "application/json; charset=utf-8",
	        async: false,
	     	success: function (d) {
	     		 xml=d;
	     		
	        },
	        error: function () {
	            alert('Error');
	        }
	    });
	 
	//var xml= loadXMLDoc();
    
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
    		 $('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>GENERAL : </span>'+description+'</td></tr>');
    	 else
    		 $('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>GENRAL : </span> NO Description</td></tr>');
    	 
    	 if(nistDescription!=='')
    		 $('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>NIST : </span> '+nistDescription+'</td></tr>');
    	 else
    		 $('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>NIST : </span> NO Desctiption</td></tr>');
     }else{
    	 $('#idTableDescription > tbody:last').append('<tr><td>NO DESCRIPTION</td></tr>');
     }
     
    
 
   
     
     $.each(SuperClass , function(i, val) { 
    	 if(i===0 && SuperClass[0]===''){
    		// $('#idTableSuperClass > tbody:last').append('<tr><td>No Classes Found</td></tr>');
    		 $("#idSuperClass ul").append('<li style="list-style-type: none;"><span class="tab">No Classes Found</span>	</li>');
    	 }else{
    		 
    		 if(SuperClass[i]!==''){
    			 $("#idSuperClass ul").append('<li style="list-style-type: none;"><span class="tab">'+SuperClass [i]+'</span></li>');
        		 //$('#idTableSuperClass > tbody:last').append('<tr><td>'+SuperClass [i]+'</td></tr>');
        	 }
    	 }
    	 
    });


     
     $.each(SubClass , function(i, val) { 
    	 if(i===0 && SubClass[i]===''){
    		 $("#idSubClass ul").append('<li style="list-style-type: none;"><span class="tab">No Classes Found</span></li>');
    		// $('#idTableSubClass > tbody:last').append('<tr><td>No Classes Found</td></tr>');
    	 }else{
    		 
    		 if(SubClass[i]!=='' ){
    			 $("#idSubClass ul").append('<li style="list-style-type: none;"><span class="tab">'+SubClass [i]+'</span></li>');
        		// $('#idTableSubClass > tbody:last').append('<tr><td>'+SubClass [i]+'</td></tr>');
        	 }
    	 }
    	 
    });
     
     
     $.each(EquivalentClass , function(i, val) { 
    	 if(i===0 && EquivalentClass[i]===''){
    		 $("#idEquClass ul").append('<li style="list-style-type: none;"><span class="tab">No Classes Found</span></li>');
    		// $('#idTableEquivalentClass > tbody:last').append('<tr><td>No Classes Found</td></tr>');
    	 }else{
    		 
    		 if(EquivalentClass[i]!==''){
    			 $("#idEquClass ul").append('<li style="list-style-type: none;"><span class="tab">'+EquivalentClass [i]+'</span></li>');
        		// $('#idTableEquivalentClass > tbody:last').append('<tr class="pure-table-odd"><td>'+EquivalentClass [i]+'</td></tr>');
        	 }
    	 }
    	 
    });
     
}

function loadXMLDoc() {
/* 	xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", "http://ec2-54-148-7-18.us-west-2.compute.amazonaws.com/rest/api/description/"+searchName, false );
    xmlHttp.send( null );
    
    return xmlHttp.responseText; */
    
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/WSOntology/rest/api/description/"+searchName,
        contentType: "application/json; charset=utf-8",
        async: false,
     	success: function (d) {
          return d;
           
        },
        error: function () {
            alert('fejl');
        }
    });
/*     $.get("http://localhost:8080/WSOntology/rest/api/description/"+searchName,
    		  function(data){
    	alert("Data Loaded: " + data);
    	return data;
    		    
    		  }); */
}
</script>
</head>
<body onload="loadMe()">

<table class="pure-table" id="idTableDescription" border="1" align="center" width="98%" style=""> 
<thead><tr><td>Description -  <span id="idSearchedWord"></span></td></tr></thead>
  <tbody>
    <tr class="pure-table-odd"></tr>
  </tbody>
</table>

<br><br>

<table width="100%" align="center" border="0" height="90%" style="overflow-y: auto; ">
<tr >


<td valign="top" align="center">
<div id="idSuperClass" style="width:100%; max-height:500px; overflow:auto">
<ul id="content">
<li style="list-style-type: none;"><span style='color: grey;font: italic bold 30px/40px Georgia, serif;'>SuperClass</span></li>
</ul>
</div>
</td>


<td valign="top" align="center">
<div id="idSubClass" style="width:100%; max-height:500px; overflow:auto">
<ul id="content">
<li style="list-style-type: none;"><span style='color: grey;font: italic bold 30px/40px Georgia, serif;'>Direct SubClasses</span></li>
</ul>
</div>
</td>


<td valign="top" align="center">
<div id="idEquClass" style="width:100%; max-height:500px; overflow:auto">
<ul id="content">
<li style="list-style-type: none;"><span style='color: grey;font: italic bold 30px/40px Georgia, serif;'>EquivalentClass</span></li>
</ul>
</div>
</td>


</tr>
</table>











</body>
</html>