/**
 * 
 */
$(document).ready(function() {
    	  $('#idTable').hide();
    	  $('#idTable1').hide();
            $( "#IDPatientName" ).autocomplete({
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
            
            $( "#IDPatientEmpId" ).autocomplete({
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
            	
            	var doctorId=$('#IDPatientEmpId').val();
            	ajaxCall(doctorId)
            });
            
        });    

function ajaxCall(doctorId){
  	
  	
  	$("#idTable tbody tr").remove()
  	var xml='<Patients assigned="0"> <Patient> <Name>Taunk</Name> <Status>567</Status> <DoctorsID>Limb</DoctorsID> </Patient>  </Patients>';
  	var xmlDoc = $.parseXML( xml ),
  	    $xml = $( xmlDoc );
  	

if($($xml).find("Patients").attr('assigned')==1){
	
	$('#idTable').show();
  	    $($xml).find("Patients>Patient").each(function(){
  	       
  	    	var Name=$(this).find("Patients>Patient>Name").text();
  	    	var DoctorsID=$(this).find("Patients>Patient>DoctorsID").text();
  	    	
  
  	    	
  	    	$('#idTable > tbody:last').append('<tr><td>'+Name+'</td><td>'+DoctorsID+'</td><td><input type="button" id="idSave" value="Book" onclick="buttonAction(\''+Name+'\',\''+DoctorsID+'\')"/></td></tr>');
  	    	
  	     });
  	 }else {
  		$('#idTable1').show();
  	 var xml1=' <Patients assigned="0"> <Doctors> <Doctor> <Name>1234</Name> <Specialist>xyz</Specialist> </Doctor> <Doctor> <Name>1234</Name> <Specialist>xyz</Specialist> </Doctor> <Doctor> <Name>1234</Name> <Specialist>xyz</Specialist> </Doctor> </Doctors> </Patients>';
  	 var xmlDoc1 = $.parseXML( xml1 ),
	    $xml1 = $( xmlDoc1 );
	    $($xml1).find("Patients>Doctors>Doctor").each(function(){
	       
	    	var Name=$(this).find("Patients>Doctors>Doctor>Name").text();
	    	var Specialist=$(this).find("Patients>Doctors>Doctor>Specialist").text();
	    

	    	
	    	$('#idTable1 > tbody:last').append('<tr><td>'+Name+'</td><td>'+Specialist+'</td><td><input type="button" id="idSave" value="Book" onclick="buttonAction(\''+Name+'\',\''+Specialist+'\')"/></td></tr>');
	    	
	     });
  	 }   
  	
  }

function buttonAction(doctorId,timeAvailable){
	
	alert(doctorId+' booked for '+ timeAvailable);
	
}