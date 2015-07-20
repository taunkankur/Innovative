/**
 * 
 */
$(document).ready(function() {
    	  $('#idTable').hide();
    	  $('#idTable1').hide();
    	  getPatientNameList();
    	  getPatientIdList();
            
            $('#IDButton').click(function(){
            	
            	
            	assignRemovePatientToRoomBed();
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



function assignRemovePatientToRoomBed(){
  	
  	
	 $('#idTable').hide();
	  $('#idTable1').hide();
  	
  	var patientName=$('#IDPatientName').val();
    	  var patientId=$('#IDPatientId').val();
  	$.ajax({
			url : 'http://localhost:8080/CS631/WebServiceCall?requestType=ARDoctorRB'+'&patientName='+patientName+'&patientId='+patientId,
			type : 'get',
			success : function(xml) {
				var responsexml=xml;
			  	
				var xmlDoc = $.parseXML( responsexml ),
		  	    $xml = $( xmlDoc );

		if($($xml).find("Patients").attr('assigned')==1){
			$("#idTable tbody tr").remove();
			$('#idTable').show();
			
			
		  	   
		  	       
		  	    	var Name=$($xml).find("Patients>Patient>Name").text();
		  	    	var Status=$($xml).find("Patients>Patient>Status").text();
		  	    	var BedId=$($xml).find("Patients>Patient>BedId").text();
		  	    	var dateTimeFrom=$($xml).find("Patients>Patient>DateTImeFrom").text();
		  	    	var dateTimeTo=$($xml).find("Patients>Patient>DateTImeTo").text();
		  	    	
		  	    	$('#idTable > tbody:last').append('<tr><td>'+Name+'</td><td>'+Status+'</td><td>'+BedId+'</td><td>'+dateTimeFrom+'</td><td>'+dateTimeTo+'</td><td><input type="button" id="idSave" value="Remove" onclick="removeRoom(\''+patientName+'\',\''+patientId+'\',\''+BedId+'\',\''+dateTimeFrom+'\',\''+dateTimeTo+'\')"/></td></tr>');
		  	    	
		  	 
		  	 }else {
		  		$("#idTable1 tbody tr").remove();
		  		$('#idTable1').show();
		  	 
		  	 var xmlDoc1 = $.parseXML(responsexml),
			    $xml1 = $( xmlDoc1 );
			    $($xml1).find("Patients>Beds>BedInfo").each(function(){
			       
			    	var BedId=$(this).find("Patients>Beds>BedInfo>BedId").text();
			    	var CliniName=$(this).find("Patients>Beds>BedInfo>CliniName").text();
			    	var dateTimeFrom=$(this).find("Patients>Beds>BedInfo>DateTImeFrom").text();
		  	    	var dateTimeTo=$(this).find("Patients>Beds>BedInfo>DateTImeTo").text();

			    	
			    	$('#idTable1 > tbody:last').append('<tr><td>'+BedId+'</td><td>'+CliniName+'</td><td>'+dateTimeFrom+'</td><td>'+dateTimeTo+'</td><td><input type="button" id="idSave" value="Assign" onclick="assignRoom(\''+patientName+'\',\''+patientId+'\',\''+BedId+'\',\''+CliniName+'\',\''+dateTimeFrom+'\',\''+dateTimeTo+'\')"/></td></tr>');
			    	
			     });
		  	 } 
			},
			error : function() {
				alert("Could not get services. Please try again.");
			}
		});
  	
  	
  
  
  	
  }

function assignRoom(patientName,patientId, bedId, clinicName,dateTimeFrom,dateTimeTo){
	

	$.ajax({
        url: 'http://localhost:8080/CS631/WebServiceCall?requestType=AssignRoom'+'&clinicName='+clinicName+'&patientId='+patientId+'&bedId='+bedId+'&dateTimeFrom='+dateTimeFrom+'&dateTimeTo='+dateTimeTo,
        success: function( data ) {
            alert(data);
       },
       error: function(){
    	   alert('Not Assigned - Error');
       }
     });
}

function removeRoom(patientName,patientId, bedId, clinicName,dateTimeFrom,dateTimeTo){
	
	
	$.ajax({
        url: 'http://localhost:8080/CS631/WebServiceCall?requestType=RemovedRoom'+'&clinicName='+clinicName+'&patientId='+patientId+'&bedId='+bedId+'&dateTimeFrom='+dateTimeFrom+'&dateTimeTo='+dateTimeTo,
        success: function( data ) {
            alert(data);
       },
 error: function(){
	 alert('Not Removed - Error');
       }
     });
}



