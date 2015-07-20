/**
 * 
 */

//auto expand textarea
$(document).ready(function() {
	
	$(function() {
		onServiceChangeDoctor();
		onServiceChangeClinic();
		onServiceChangeBedId();
		getPatientId();
		$("#datepickerFrom").datepicker();
		$("#datepickerTo").datepicker({
			   onSelect: function(dateText, inst) { 
				   $("#clinics").trigger("select");
					$("#bedids").trigger("select");
			   }
			});
	});

	
	$('#idButtonUpdateRecord').click(function() {
		updateNewPatient();
	});
	$('#doctors').select(function() {
		onServiceChangeDoctor();
	});
	$('#clinics').select(function() {
		onServiceChangeClinic();
	});
	$('#bedids').select(function() {
		onServiceChangeBedId();
	});

});

function getPatientId(){
	
	$.ajax({
		url : 'http://localhost:8080/CS631/DropDownComplete?requestType=PatientId',
		type : 'get',
		success : function(d) {
			$('#idTextPatientid').val(d);
		},
		error : function() {
			alert("Could not get services. Please try again.");
		}
	});
}
function onServiceChangeDoctor() {

	$.ajax({
		url : 'http://localhost:8080/CS631/DropDownComplete?requestType=Doctor',
		type : 'get',
		success : function(d) {

			d = JSON.parse(d);
			var jTargetSelect = jQuery("#doctors");
			// Clear old states
			jTargetSelect.children().remove();
			// Add new states
			jQuery(d.doctors).each(
					function() {
						jTargetSelect.append('<option value="' + this.id + '">'
								+ this.name + '</option>');
					});
		},
		error : function() {
			alert("Could not get services. Please try again.");
		}
	});

}


function onServiceChangeClinic() {

	$.ajax({
		url : 'http://localhost:8080/CS631/DropDownComplete?requestType=Clinic',
		type : 'get',
		success : function(d) {

			d = JSON.parse(d);
			var jTargetSelect = jQuery("#clinics");
			// Clear old states
			jTargetSelect.children().remove();
			// Add new states
			jQuery(d.clinics).each(
					function() {
						jTargetSelect.append('<option value="' + this.id + '">'
								+ this.name + '</option>');
					});
		},
		error : function() {
			alert("Could not get services. Please try again.");
		}
	});

}

function onServiceChangeBedId() {

	
	var dateFrom=$("#datepickerFrom").val();
	var dateTo=$("#datepickerTo").val();
	
	$.ajax({
		url : 'http://localhost:8080/CS631/DropDownComplete?requestType=BedId&DateFrom='+dateFrom+'&DateTo='+dateTo,
		type : 'get',
		success : function(d) {

			d = JSON.parse(d);
			var jTargetSelect = jQuery("#bedids");
			// Clear old states
			jTargetSelect.children().remove();
			// Add new states
			jQuery(d.bedids).each(
					function() {
						jTargetSelect.append('<option value="' + this.id + '">'
								+ this.name + '</option>');
					});
		},
		error : function() {
			alert("Could not get services. Please try again.");
		}
	});

}


function updateNewPatient(){
	
	var patientName=$('#idTextPatientName').val();
	var patientSSN=$('#idTextPatientSSN').val();
	var doctorName=$('#doctors').val();
	var bloodType=$('#idTextBloodType').val();
	var gender=$('#genders').val();
	var patientId=$('#idTextPatientid').val();
	var dateFrom=$('#datepickerFrom').val();
	var dateTo=$('#datepickerTo').val();
	var clinicName=$('#clinics').val();
	var bedId=$('#bedids').val();
	

	$.ajax({
		url : 'http://localhost:8080/CS631/WebServiceCall?requestType=updateNewPatient'+
		'&patientName='+patientName+
		'&patientSSN='+patientSSN+
		'&doctorName='+doctorName+
		'&bloodType='+bloodType+
		'&gender='+gender+
		'&patientId='+patientId+
		'&dateFrom='+dateFrom+
		'&dateTo='+dateTo+
		'&clinicName='+clinicName+
		'&bedId='+bedId,
		type : 'get',
		success : function(d) {
			
			if(d=='Successful'){
				alert('Data Saved Successfully');
			}
		},
		error : function() {
			alert("Could not get services. Please try again.");
		}
	});
}
