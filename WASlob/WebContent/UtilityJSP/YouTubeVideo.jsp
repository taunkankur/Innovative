<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


<!--   <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.min.js"></script> 
<script type="text/javascript" src="../Script/jquery-latest.js"></script>  --> 

<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<link type="text/css" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1/themes/redmond/jquery-ui.css" rel="stylesheet" />
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>

<script type="text/javascript" src="../Script/sortable.js"></script> 
<link href="http://www.joostdevalk.nl/" rev="made" />


<!-- <link rel="stylesheet" type="text/css" href="http://cdn.datatables.net/1.10.4/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="../Script/dataTable.js"></script> -->



  
  
<script type="text/javascript" src="../Script/jquery.youtubepopup.min.js"></script>


<script type="text/javascript">

var divClonePinned;
var divCloneOrignal;
function buttonAction(action,ClassName,VedURL){
	
	
	$.ajax({
        type: "GET",
        url: "WSOntologyCall.do?searchType="+action+"&searchFor="+ClassName+"&VedURL="+VedURL+"&StudentId=at375",
 		async: false,
     	success: function (d) {
     		 if(d==1){
     			 
     		
     			
     			$("#idPinned").replaceWith(divClonePinned); 
     			$("#idOrignal").replaceWith(divCloneOrignal); 
     			
     			
                

     			loadMe();
     		 }
        },
        error: function () {
            alert('Error');
        }
    });
}
</script>
<script type="text/javascript">


$(document).ready(function() {
	
	
		$('#idSaved').click(function(){
			$('#idOrignal').hide();
			$('#idPinned').show();
			
		});
		
		$('#idUnSaved').click(function(){
			$('#idOrignal').show();
			$('#idPinned').hide();
		});
});

var searchName;
function  loadMe() {
	
	$('#idContainer').show();
	$('#idPinned').hide();
		$('#idNoVideo').hide();
	 $('#idNoSaveVideo').hide();
	divClonePinned = $("#idPinned").clone(); 
	divCloneOrignal=$("#idOrignal").clone(); 
	
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
	
	searchAllVideo();
    	
   
      
/*      $('#table_id1').DataTable();
     $('#table_id2').DataTable();  */
    

}


function searchAllVideo(){
	var xml;
	 $.ajax({
	        type: "GET",
	        url: "WSOntologyCall.do?searchType=Video&searchFor="+searchName.replace(" ", ""),
	 		async: false,
	     	success: function (d) {
	     		
	     		if(d.trim()!=='false' && d.trim()!=="<Results/>")
	     		xml=d;
	     		else{
	     			$('#idContainer').hide();
	     			$('#idNoVideo').show();
	     		}
	     			
	     		
	        },
	        error: function () {
	            alert('Error');
	        }
	    });
   
	 var pinned=false;
 
    xmlDoc = $.parseXML( xml ),
    $xml = $( xmlDoc );
    console.log($xml);
    $($xml).find("Results>Row").each(function(){
    
   	 if($(this).attr('Pinned')==1 ){
   	
   		 pinned=true;
   		 var videoValues={};
   		 videoValues. ClassName=$(this).find('Results>Row>ClassName').text();
   		 videoValues. VedTitle=$(this).find('Results>Row>VedTitle').text();
   		 videoValues. VedThumbNail=$(this).find('Results>Row>VedThumbNail').text();
   		 videoValues. VedURL=$(this).find('Results>Row>VedURL').text();
   		 videoValues. ViewCount=$(this).find('Results>Row>ViewCount').text();
   		 videoValues. NumLikes=$(this).find('Results>Row>NumLikes').text();
   		 videoValues. NumDislikes=$(this).find('Results>Row>NumDislikes').text();
   		 videoValues. NumRaters=$(this).find('Results>Row>NumRaters').text();
   		 videoValues. PublishedDateTime=$(this).find('Results>Row>PublishedDateTime').text();
   		 appednUnPinnedData(videoValues);
   		 //$('#table_id2 > tbody:last').append('<tr> <td> <img alt="" src="'+videoValues.VedThumbNail+'"> </td><td><a class="youtube"  href="" id="'+videoValues.VedURL+'">'+videoValues.VedTitle+'</a></td><td>'+videoValues.ViewCount+'</td><td>'+videoValues.NumLikes+'</td><td>'+videoValues.NumDislikes+'</td><td>'+videoValues.NumRaters+'</td><td>'+videoValues.PublishedDateTime+'</td><td><input type="button" id="idSave" value="Delete" onclick="buttonAction(\'VideoUnPin\',\''+videoValues.ClassName+'\',\''+videoValues.VedURL+'\')"/></td></tr>');
		       
   	 }if ($(this).attr('Pinned')==0 ){
   		 
   		 var videoValues={};
   		 videoValues.ClassName=$(this).find('Results>Row>ClassName').text();
   		 videoValues. VedTitle=$(this).find('Results>Row>VedTitle').text();
   		 videoValues. VedThumbNail=$(this).find('Results>Row>VedThumbNail').text();
   		 videoValues. VedURL=$(this).find('Results>Row>VedURL').text();
   		 videoValues. ViewCount=$(this).find('Results>Row>ViewCount').text();
   		 videoValues. NumLikes=$(this).find('Results>Row>NumLikes').text();
   		 videoValues. NumDislikes=$(this).find('Results>Row>NumDislikes').text();
   		 videoValues. NumRaters=$(this).find('Results>Row>NumRaters').text();
   		 videoValues. PublishedDateTime=$(this).find('Results>Row>PublishedDateTime').text();
   		 appednPinnedData(videoValues);
   		// $('#table_id1 > tbody:last').append('<tr> <td> <img alt="" src="'+videoValues.VedThumbNail+'"> </td><td><a class="youtube"  href="" id="'+videoValues.VedURL+'">'+videoValues.VedTitle+'</a></td><td>'+videoValues.ViewCount+'</td><td>'+videoValues.NumLikes+'</td><td>'+videoValues.NumDislikes+'</td><td>'+videoValues.NumRaters+'</td><td>'+videoValues.PublishedDateTime+'</td><td><input type="button" id="idSave" value="Save" onclick="buttonAction(\'VideoPin\',\''+videoValues.ClassName+'\',\''+videoValues.VedURL+'\')"/></td></tr>');     
   	      
   	 }if ($(this).attr('Pinned')==2 ){
   		 
   		$('#idPinned').hide();
   		$('#idOrignal').hide();
   		$('#header').hide();
   		pinned=true;
   		
   		var videoValues={};
  		 videoValues.ClassName=$(this).find('Results>Row>ClassName').text();
  		 videoValues. VedTitle=$(this).find('Results>Row>VedTitle').text();
  		 videoValues. VedThumbNail=$(this).find('Results>Row>VedThumbNail').text();
  		 videoValues. VedURL=$(this).find('Results>Row>VedURL').text();
  		 videoValues. ViewCount=$(this).find('Results>Row>ViewCount').text();
  		 videoValues. NumLikes=$(this).find('Results>Row>NumLikes').text();
  		 videoValues. NumDislikes=$(this).find('Results>Row>NumDislikes').text();
  		 videoValues. NumRaters=$(this).find('Results>Row>NumRaters').text();
  		 videoValues. PublishedDateTime=$(this).find('Results>Row>PublishedDateTime').text();
   		appedDynamicVideo(videoValues)
   	 }
   	 if(pinned==false){
    	 $('#idPinned').hide();
    	 $('#idNoSaveVideo').show();
     }
   
    		         
     $("a.youtube").YouTubePopup({ idAttribute: 'id' });
    }); 
}
function appednUnPinnedData(videoValues){
	  $('#table_id2 > tbody:last').append('<tr> <td align="center"> <img alt="" src="'+videoValues.VedThumbNail+'"> </td><td  ><a class="youtube"  href="" id="'+videoValues.VedURL+'">'+videoValues.VedTitle+'</a></td><td>'+videoValues.ViewCount+'</td><td>'+videoValues.NumLikes+'</td><td>'+videoValues.NumDislikes+'</td><td>'+videoValues.NumRaters+'</td><td>'+videoValues.PublishedDateTime+'</td><td><input type="button" id="idSave" value="Delete" onclick="buttonAction(\'VideoUnPin\',\''+videoValues.ClassName+'\',\''+videoValues.VedURL+'\')"/></td></tr>');
}

function appednPinnedData(videoValues){
	 $('#table_id1 > tbody:last').append('<tr> <td align="center"> <img alt="" src="'+videoValues.VedThumbNail+'"> </td><td  ><a class="youtube"  href="" id="'+videoValues.VedURL+'">'+videoValues.VedTitle+'</a></td><td>'+videoValues.ViewCount+'</td><td>'+videoValues.NumLikes+'</td><td>'+videoValues.NumDislikes+'</td><td>'+videoValues.NumRaters+'</td><td>'+videoValues.PublishedDateTime+'</td><td><input type="button" id="idSave" value="Save" onclick="buttonAction(\'VideoPin\',\''+videoValues.ClassName+'\',\''+videoValues.VedURL+'\')"/></td></tr>');
}


function appedDynamicVideo(videoValues){
	 $('#table_id3 > tbody:last').append('<tr> <td align="center"> <img alt="" src="'+videoValues.VedThumbNail+'"> </td><td  ><a class="youtube"  href="" id="'+videoValues.VedURL+'">'+videoValues.VedTitle+'</a></td><td>'+videoValues.ViewCount+'</td><td>'+videoValues.NumLikes+'</td><td>'+videoValues.NumDislikes+'</td><td>'+videoValues.NumRaters+'</td><td>'+videoValues.PublishedDateTime+'</td></tr>');
}


</script>


<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
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
a:link {color:blue;text-decoration:none;}
a:visited {color:#800080;text-decoration:none;}
a:hover {text-decoration:underline;background-color: rgb(218, 222, 224);}
#idSave {
  background: #3498db;
  background-image: -webkit-linear-gradient(top, #3498db, #2980b9);
  background-image: -moz-linear-gradient(top, #3498db, #2980b9);
  background-image: -ms-linear-gradient(top, #3498db, #2980b9);
  background-image: -o-linear-gradient(top, #3498db, #2980b9);
  background-image: linear-gradient(to bottom, #3498db, #2980b9);
  -webkit-border-radius: 28;
  -moz-border-radius: 28;
  border-radius: 28px;
  font-family: Arial;
  color: #ffffff;
  font-size: 15px;
  padding: 2px 6px 2px 6px;
  text-decoration: none;
}

#idSave:hover {
  background: #3cb0fd;
  background-image: -webkit-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -moz-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -ms-linear-gradient(top, #3cb0fd, #3498db);
  background-image: -o-linear-gradient(top, #3cb0fd, #3498db);
  background-image: linear-gradient(to bottom, #3cb0fd, #3498db);
  text-decoration: none;
}
</style>
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
</style>
</head>

  <body onload="loadMe()">
  <br><br>
  <div id="header" align="center">
  <input type="button" id="idSaved" value="Favourite Videos">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
   <input type="button" id="idUnSaved" value=" Genral  Videos ">
   </div>
   <br><br>
   
    
  <h4 style="color: grey;font: italic bold 20px/30px Georgia, serif;" id="idNoVideo" align="center"> No  Video...  Coming Soon...</h4>
<div id="idContainer" >
<h4 style="color: grey;font: italic bold 20px/30px Georgia, serif;" id="idNoSaveVideo" align="center"> No Saved Video</h4>
<div id="idPinned" align="center" >
<table border="1" id="table_id2" class=" sortable pure-table" style="width: 96%; box-shadow: 10px 10px 5px #888888; " align="center">
  <thead>
  <tr>
  <td class=" headerSortDown  " style="width: 3%" align="center"> Video </td>
  <td class=" headerSortDown " style="width: 30%" align="center">Topic</td>
  <td class=" headerSortDown " style="width: 7%">#View</td>
  <td class=" headerSortDown " style="width: 7%">#Likes</td>
  <td class=" headerSortDown " style="width: 7%">#DisLikes</td>
  <td class=" headerSortDown " style="width: 7%">#Raters</td>
  <td class=" headerSortDown " style="width: 7%">DateTime</td>
  <td class=" headerSortDown " style="width: 3%">UnPin</td >
  </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>
</div>



<div id="idOrignal" align="center">
<table border="1" id="table_id1" class=" sortable pure-table" style="width: 96%;box-shadow: 10px 10px 5px #888888;">
  <thead>
  <tr>
  <td class="  headerSortDown  " style="width: 3%" align="center"> Video </td>
  <td class=" headerSortDown " style="width: 30%" align="center">Topic</td>
  <td class=" headerSortDown " style="width: 7%">#View</td>
  <td class=" headerSortDown " style="width: 7%">#Likes</td>
  <td class=" headerSortDown " style="width: 7%">#DisLikes</td>
  <td class=" headerSortDown " style="width: 7%">#Raters</td>
  <td class=" headerSortDown " style="width: 7%">DateTime</td>
  <td class=" headerSortDown " style="width: 3%">Pin</td >
  </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>

</div>


<div id="idDynamicVideo" align="center">
<table border="1" id="table_id3" class=" sortable pure-table" style="width: 96%;box-shadow: 10px 10px 5px #888888;">
  <thead>
  <tr>
  <td class="  headerSortDown  " style="width: 3%" align="center"> Video </td>
  <td class=" headerSortDown " style="width: 30%" align="center">Topic</td>
  <td class=" headerSortDown " style="width: 7%">#View</td>
  <td class=" headerSortDown " style="width: 7%">#Likes</td>
  <td class=" headerSortDown " style="width: 7%">#DisLikes</td>
  <td class=" headerSortDown " style="width: 7%">#Raters</td>
  <td class=" headerSortDown " style="width: 7%">DateTime</td>
  
  </tr>
  </thead>
  <tbody>
   
  </tbody>
</table>
</div>







<script type="text/javascript">
$(document).ready(function() 
	    { 
$("#table_id2").tablesorter(); 
$("#table_id1").tablesorter(); } 
);
</script>
</div>
  </body>
  
</html>