/**
 * 
 */



       
      $(document).ready(function() {
    	  $('#idTable').hide();
           
    	  getPatientNameList();
    	  getPatientIdList();
            
    	  
    	  
            $('#IDButton').click(function(){
            	
            	
            	getNewPatient();
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

      
      
      function getNewPatient(){
    	  $('#idTable').show();
        	$("#idTable tbody tr").remove()
    	  var patientName=$('#IDPatientName').val();
    	  var patientId=$('#IDPatientId').val();

    		$.ajax({
    			url : 'http://localhost:8080/CS631/WebServiceCall?requestType=getNewPatient'+'&patientName='+patientName+'&patientId='+patientId,
    			type : 'get',
    			success : function(xml) {
    				var xmlDoc = $.parseXML( xml ),
    	      	    $xml = $( xmlDoc );
    	      	    $($xml).find("Patients>Patient").each(function(){
    	      	       
    	      	    	var Name=$(this).find("Patients>Patient>Name").text();
    	      	    	var Gender=$(this).find("Patients>Patient>Gender").text();
    	      	    	var BloodType=$(this).find("Patients>Patient>BloodType").text();
    	      	    	var SSN=$(this).find("Patients>Patient>SSN").text();
    	      	    	var PatientID=$(this).find("Patients>Patient>PatientID").text();
    	      	    	
    	      	    	$('#idTable > tbody:last').append('<tr><td>'+Name+'</td><td>'+Gender+'</td><td>'+BloodType+'</td><td>'+SSN+'</td><td>'+PatientID+'</td></tr>');
    	      	    	
    	      	     });
    			},
    			error : function() {
    				alert("Could not get services. Please try again.");
    			}
    		});
    	}