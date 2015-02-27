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
	
	var Data=$.QueryString["Data"];
	var SearchName=$.QueryString["SearchName"];
	
	$('#idSpanDesGenral').html(SearchName);
	$('#idSpanDesNIST').html(SearchName);
	
	xmlDoc = $.parseXML( Data ),
    $xml = $( xmlDoc );
    
    var description=$($xml).find('OwlRootNode>Description').text();
    var nistDescription=$($xml).find('OwlRootNode>NistDef').text();
    var SuperClass= $($xml).find("OwlRootNode>SuperClass").text().split('|');
    var SubClass= $($xml).find("OwlRootNode>SubClass").text().split('|');
    var EquivalentClass= $($xml).find("OwlRootNode>EquivalentClass").text().split('|');
   
    if(description!=='' || nistDescription!==''){
   	 
   	 if(description!==''){
   		 
   	 $('#idGeneralDesc').html(description);
   		// $('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>GENERAL : </span>'+description+'</td></tr>');
    }
   	 else{
   		 $('#idGeneralDesc').html('No Description..');
   		//$('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>GENERAL : </span> NO Description</td></tr>');
   	 }
   		 
   	 
   	 if(nistDescription!==''){
   		 $('#idNistDesc').html(nistDescription);
   		
   	//	 $('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>NIST : </span> '+nistDescription+'</td></tr>');
   	 }else{
   		 $('#idNistDesc').html(' No Desctiption..');
   		//$('#idTableDescription > tbody:last').append('<tr><td><span style=\'color: grey;font: italic bold 20px/30px Georgia, serif;\'>NIST : </span> NO Desctiption</td></tr>');
   	 }
   		 
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
	});
}