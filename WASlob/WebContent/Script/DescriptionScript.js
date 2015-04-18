/**
 * 
 */
function PopulateTable(){
	$(document).ready(function(){
		
	
	
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
	
	var Data=parent.landingPageData;
	var SearchName=$.QueryString["SearchName"];
	
	$('#idSpanDesGenral').html(SearchName);
	$('#idSpanDesNIST').html(SearchName);
	$('#idSpanDesSANS').html(SearchName);
	//alert(Data);
	if (Data==false) {
		alert("No OWL record for this file.");
		return;
	}
	xmlDoc = $.parseXML( Data ),
    $xml = $( xmlDoc );
    var sansDescription=$($xml).find('OwlRootNode>SANSDescription').text();
    var description=$($xml).find('OwlRootNode>Description').text();
    var nistDescription=$($xml).find('OwlRootNode>NistDef').text();
    var SuperClass= $($xml).find("OwlRootNode>SuperClass").text().split('|');
    var SubClass= $($xml).find("OwlRootNode>SubClass").text().split('|');
    var EquivalentClass= $($xml).find("OwlRootNode>EquivalentClass").text().split('|');
   
    if(description!=='' || nistDescription!=='' || sansDescription!==''){
   	 
   	 if(description!==''){
   		 
   	 $('#idGeneralDesc').html("<span class='desc_src'>GENERAL:</span>"+description);
   		
    }
   	 else{
   		//$('#idGeneralDesc').html('No Description..');
   		$("#idGeneralDescFancyElem").hide();
   	 }
   		 
   	 
   	 if(nistDescription!==''){
   		 $('#idNistDesc').html("<span class='desc_src'>NIST:</span>"+nistDescription);
   		
   	
   	 }else{
   		 //$('#idNistDesc').html(' No Desctiption..');
   		$("#idNistDescFancyElem").hide();
   	 }
   	 
   	if(sansDescription!==''){
  		 $('#idSANSDesc').html("<span class='desc_src'>SANS:</span>"+sansDescription);
  		
  	
  	 }else{
  		 //$('#idSANSDesc').html(' No Desctiption..');
  		$("#idSANSDescFancyElem").hide();
  	 }
   	 
   		 
    }else{
   	 //$('#idTableDescription > tbody:last').append('<tr><td>NO DESCRIPTION</td></tr>');
    	$("#idGeneralDescFancyElem").hide();
    	$("#idNistDescFancyElem").hide();
    	$("#idSANSDescFancyElem").hide();
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
    loadInitialData();
	});
}

function loadInitialData() {
	$.ajax({
		url: "dummy.xml"
	}).done(function( data ) {
		$xml = $(data);
		$("#tab1contents").empty();
		$most_viewed = $xml.find("most_viewed");
		$most_viewed.find("result").each(function(){
			$result = $(this)
			source	= $result.find("source").text();
			img		= $result.find("img").text();
			title	= $result.find("title").text();
			desc	= $result.find("desc").text();
			link	= $result.find("link").text();
			$("#tab1contents").append(createLinkTile(source, img, title, desc, link));
		});
		$("#tab2contents").empty();
		$most_relevant = $xml.find("most_relevant");
		$most_relevant.find("result").each(function(){
			$result = $(this)
			source	= $result.find("source").text();
			img		= $result.find("img").text();
			title	= $result.find("title").text();
			desc	= $result.find("desc").text();
			link	= $result.find("link").text();
			$("#tab2contents").append(createLinkTile(source, img, title, desc, link));
		});
		$("#tab3contents").empty();
		$highest_rated = $xml.find("highest_rated");
		$highest_rated.find("result").each(function(){
			$result = $(this)
			source	= $result.find("source").text();
			img		= $result.find("img").text();
			title	= $result.find("title").text();
			desc	= $result.find("desc").text();
			link	= $result.find("link").text();
			$("#tab3contents").append(createLinkTile(source, img, title, desc, link));
		});
		
	});
}

function createLinkTile(source, img, title, desc, link) {
	imgtxt = "";
	if (img != "") imgtxt = "<img src='" + img + "'/>";
	html = 
		"<div class='resTile' "+
		"onclick='window.open(\"" + link + "\")'>"+
		"<table width='100%'>"+
		"<tr>"+
		"<td rowspan='2' width='40px'>" + imgtxt + "</td>"+
		"<td class='resTileTitle'>"+ title + "</td>"+
		"</tr>"+
		"<tr>"+
		"<td class='resTileDesc'>"+ desc + "</td>"+
		"</tr>"+
		"</table>"+
		"</div>";
	return html;
}
