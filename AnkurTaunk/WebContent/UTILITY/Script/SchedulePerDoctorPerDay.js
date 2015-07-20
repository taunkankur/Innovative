/**
 * 
*/

/**
 * 
 */



       
      $(document).ready(function() {
    	  $('#idTable').hide();
            $( "#IDDoctorName" ).autocomplete({
                source: function( request, response ) {
                    $.ajax({
                        url: "http://localhost:8080/CS631/AutoComplete",
                        data: {queryTerm: request.term},
                        success: function( data ) {
                            response(data.split('|'));
                            
                        }
                    });
                },
            });
            
            $( "#IDDoctorEmpId" ).autocomplete({
                source: function( request, response ) {
                    $.ajax({
                        url: "http://localhost:8080/CS631/AutoComplete",
                        data: {queryTerm: request.term},
                        success: function( data ) {
                            response(data.split('|'));
                            
                        }
                    });
                },
            });
            
            $('#IDButton').click(function(){
            	
            	var doctorId=$('#IDDoctorEmpId').val();
            	ajaxCall(doctorId);
            });
            
        });     
        
      function ajaxCall(doctorId){
      	
      	$('#idTable').show();
      	$("#idTable tbody tr").remove()
      	var xml='<Patients> <Patient> <Name>Taunk</Name> <Gender>567</Gender> <BloodType>Limb</BloodType> <SSN>Tuesday</SSN> <PatientID>Tuesday</PatientID> </Patient> <Patient> <Name>Taunk</Name> <Gender>567</Gender> <BloodType>Limb</BloodType> <SSN>Tuesday</SSN> <PatientID>Tuesday</PatientID> </Patient> </Patients>';
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
      	
      	
      	
      }