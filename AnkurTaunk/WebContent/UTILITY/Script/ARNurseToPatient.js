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
            	
            	var NurseId=$('#IDPatientEmpId').val();
            	ajaxCall(NurseId)
            });
            
        });    

function ajaxCall(NurseId){
  	
  	
  	$("#idTable tbody tr").remove()
  	var xml='<Patients assigned="1"> <Patient> <Name>Taunk</Name> <Status>567</Status> <NursesID>Limb</NursesID> </Patient>  </Patients>';
  	var xmlDoc = $.parseXML( xml ),
  	    $xml = $( xmlDoc );
  	

if($($xml).find("Patients").attr('assigned')==1){
	
	$('#idTable').show();
  	    $($xml).find("Patients>Patient").each(function(){
  	       
  	    	var Name=$(this).find("Patients>Patient>Name").text();
  	    	var NursesID=$(this).find("Patients>Patient>NursesID").text();
  	    	
  
  	    	
  	    	$('#idTable > tbody:last').append('<tr><td>'+Name+'</td><td>'+NursesID+'</td><td><input type="button" id="idSave" value="Book" onclick="buttonAction(\''+Name+'\',\''+NursesID+'\')"/></td></tr>');
  	    	
  	     });
  	 }else {
  		$('#idTable1').show();
  	 var xml1=' <Patients assigned="0"> <Nurses> <Nurse> <Name>1234</Name> <Specialist>xyz</Specialist> </Nurse> <Nurse> <Name>1234</Name> <Specialist>xyz</Specialist> </Nurse> <Nurse> <Name>1234</Name> <Specialist>xyz</Specialist> </Nurse> </Nurses> </Patients>';
  	 var xmlDoc1 = $.parseXML( xml1 ),
	    $xml1 = $( xmlDoc1 );
	    $($xml1).find("Patients>Nurses>Nurse").each(function(){
	       
	    	var Name=$(this).find("Patients>Nurses>Nurse>Name").text();
	    	var Specialist=$(this).find("Patients>Nurses>Nurse>Specialist").text();
	    

	    	
	    	$('#idTable1 > tbody:last').append('<tr><td>'+Name+'</td><td>'+Specialist+'</td><td><input type="button" id="idSave" value="Book" onclick="buttonAction(\''+Name+'\',\''+Specialist+'\')"/></td></tr>');
	    	
	     });
  	 }   
  	
  }

function buttonAction(NurseId,timeAvailable){
	
	alert(NurseId+' booked for '+ timeAvailable);
	
}