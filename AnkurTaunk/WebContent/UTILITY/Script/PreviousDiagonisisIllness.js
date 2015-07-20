/**
 * 
 */



       
   /**
 * 
 */



       
      $(document).ready(function() {
    	  $('#idTable').hide();
           
    	  getPatientNameList();
    	  getPatientIdList();
            
    	  
    	  
            $('#IDButton').click(function(){
            	
            	
            	getPreviousIllnessAndDiagonisis();
            });
            
        });     
      
      
      
      function getPatientNameList(){
    	  $( "#IDPatientName" ).autocomplete({
              source: function( request, response ) {
                  $.ajax({
                     url: "http://localhost:8080/CS631/AutoComplete?requestType=PatientNameList&queryTerm="+request.term,
                     success: function( data ) {
                          response(data.split('|'));
                          
                      }
                  });
              },
              select: function(event, ui) {
                 getSpecificPatientId(ui.item.value);
                  
              },
          });
      }
      
      function getPatientIdList(){
    	  $( "#IDPatientId" ).autocomplete({
              source: function( request, response ) {
                  $.ajax({
                     url: "http://localhost:8080/CS631/AutoComplete?requestType=PatientIdList&queryTerm="+request.term,
                     success: function( data ) {
                          response(data.split('|'));
                          
                      }
                  });
              },
              select: function(event, ui) {
            	  
                 getSpecificPatientName(ui.item.value);
                 
              },
          });
      }
        
      
      function getSpecificPatientName(patientId){
    	  $.ajax({
              url: "http://localhost:8080/CS631/AutoComplete?requestType=PatientNameSpecific&queryTerm="+patientId,
              success: function( data ) {
                 
                   $( "#IDPatientName" ).val(data);
                  
               }
           });
    	  
      }
      function getSpecificPatientId(patientName){
    	  
    	  $.ajax({
              url: "http://localhost:8080/CS631/AutoComplete?requestType=PatientIdSpecific&queryTerm="+patientName,
              success: function( data ) {
                  
                  $('#IDPatientId').val(data);
               }
           });
    	  
      }

      
      
      function getPreviousIllnessAndDiagonisis(){
    	  $('#idTable').show();
        	$("#idTable tbody tr").remove()
    	  var patientName=$('#IDPatientName').val();
    	  var patientId=$('#IDPatientId').val();

    		$.ajax({
    			url : 'http://localhost:8080/CS631/WebServiceCall?requestType=previousIllnessDiagonisis'+'&patientName='+patientName+'&patientId='+patientId,
    			type : 'get',
    			success : function(xml) {
    				
    				var xmlDoc = $.parseXML( xml ),    				
    	      	    $xml = $( xmlDoc );
    	      	    $($xml).find("DiagonisisAndIllnesses>DiagonisisAndIllness").each(function(){
    	      	       
    	      	       var DateTime=$(this).find("DiagonisisAndIllnesses>DiagonisisAndIllness>DateTime").text();
    	      	    	var IllnessId=$(this).find("DiagonisisAndIllnesses>DiagonisisAndIllness>IllnessId").text();
    	      	    	var Description=$(this).find("DiagonisisAndIllnesses>DiagonisisAndIllness>Description").text();
    	      	    	var Suggestion=$(this).find("DiagonisisAndIllnesses>DiagonisisAndIllness>Suggestion").text();
    	      	    	
    	      	    	$('#idTable > tbody:last').append('<tr><td>'+DateTime+'</td><td>'+IllnessId+'</td><td>'+Description+'</td><td>'+Suggestion+'</td></tr>');
    	      	    	
    	      	     });
    			},
    			error : function() {
    				alert("Could not get services. Please try again.");
    			}
    		});
    	}
        
      
