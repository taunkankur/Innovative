/**
 * 
 */



       
      $(document).ready(function() {
    	  $('#idTable').hide();
           
    	  getPatientNameList();
    	  getPatientIdList();
            
    	  
    	  
            $('#IDButton').click(function(){
            	
            	
            	getDoctorsAvailablity();
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

      
      
      function getDoctorsAvailablity(){
    	  $('#idTable').show();
        	$("#idTable tbody tr").remove()
    	  var patientName=$('#IDPatientName').val();
    	  var patientId=$('#IDPatientId').val();

    		$.ajax({
    			url : 'http://localhost:8080/CS631/WebServiceCall?requestType=getDoctorAvailability'+'&patientName='+patientName+'&patientId='+patientId,
    			type : 'get',
    			success : function(xml) {
    				var xmlDoc = $.parseXML( xml ),
    	      	    $xml = $( xmlDoc );
        				
    				 $($xml).find("Doctors>Doctor").each(function(){
    		      	       
    		      	       var doctorId=$(this).find("Doctors>Doctor>DoctorId").text();
    		      	    	var doctorName=$(this).find("Doctors>Doctor>Name").text();
    		      	    	var speciality=$(this).find("Doctors>Doctor>Specialist").text();
    		      	    	var timeAvailable=$(this).find("Doctors>Doctor>TimeAvailable").text();
    		      	    	
    		      	    	$('#idTable > tbody:last').append('<tr><td>'+doctorId+'</td><td>'+doctorName+'</td><td>'+speciality+'</td><td>'+timeAvailable+'</td><td><input type="button" id="idSave" value="Book" onclick="buttonAction(\''+doctorId+'\',\''+timeAvailable+'\')"/></td></tr>');
    		      	    	
    		      	     });
    			},
    			error : function() {
    				alert("Could not get services. Please try again.");
    			}
    		});
    	}
      
 
     
      function buttonAction(doctorId,timeAvailable){
      	
   
      	var patientName=$('#IDPatientName').val();
  	  var patientId=$('#IDPatientId').val();
      	$.ajax({
			url : 'http://localhost:8080/CS631/WebServiceCall?requestType=bookDoctorsAppointment'+'&patientName='+patientName+'&patientId='+patientId+'&timeAvailable='+timeAvailable,
			type : 'get',
			success : function(data) {
			
				if(data=='booked'){
					alert('Booked Successfully');
					getDoctorsAvailablity();
				}
					
			},
			error : function() {
				alert("Could not get services. Please try again.");
			}
		});
      	
      }