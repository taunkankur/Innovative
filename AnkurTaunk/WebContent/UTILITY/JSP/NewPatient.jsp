<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="../../UTILITY/Script/json2.js"></script>
 <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="../../UTILITY/CSS/NewPatient.css">
<script type="text/javascript" src="../../UTILITY/Script/NewPatient.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.10.3/jquery-ui.min.js"></script>





</head>
<body style="color:#2e2e2e;	overflow-x:hidden;background: url('http://www.newsroompost.com/wp-content/uploads/2015/03/cream_pixels.png');">

<!-- Header -->
		
        <div  align="center"><h2>New Patient Information</h2></div>
        <hr width="100%" class="style-two">
<!-- Body -->        
 	<div class="divElement" >
		<table   class="block">
		
			<tr>
				<td align="center" class="inputInfo">Patient Name</td>
				<td><input type="text" width="30" id="idTextPatientName"></td>
				<td align="center" class="inputInfo">Patient SSN</td>
				<td><input type="text" width="30" id="idTextPatientSSN"></td>
			</tr>
			<tr>
				<td align="center" class="inputInfo">Patient Id</td>
				<td><input type="text" width="30" id="idTextPatientid"></td>
				<td align="center" class="inputInfo">Blood Type</td>
				<td><input type="text" width="30" id="idTextBloodType"></td>
			</tr>
			
			<tr>
				<td align="center" class="inputInfo">Gender</td>
				<td><select id="genders" style='max-width: 150px;min-width: 150px;    width: 150px' > <option value="Male">Male</option> <option value="Female">Female</option></select></td>
				<td align="center" class="inputInfo">DateFrom</td>
				<td><input type="text" width="30" id="datepickerFrom"></td>
			</tr>
			<tr>
				<td align="center" class="inputInfo">DateTo</td>
				<td><input type="text" width="30" id="datepickerTo"></td>
				<td align="center" class="inputInfo">ClinicName</td>
				<td><select id="clinics" style='max-width: 150px;min-width: 150px;    width: 150px' ondblclick="onServiceChangeClinic()"></select></td>
			</tr>
			<tr>
				<td align="center" class="inputInfo">BedId</td>
				<td><select id="bedids" style='max-width: 150px;min-width: 150px;    width: 150px' ondblclick="onServiceChangeBedId()"></select></td>
				<td align="center" class="inputInfo">Click</td>
				<td align="center"><input type="button" value="Update Record" id="idButtonUpdateRecord" class="btn"></td>
			</tr>
		</table>
	</div> 
	<br>
	<br>
	<br>
	<br>


</body>
</html>