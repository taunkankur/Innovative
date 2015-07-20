<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.1/jquery-ui.js"></script>
<link rel="stylesheet" type="text/css"
	href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" />
<script type="text/javascript"
	src="../../UTILITY/Script/PatientInformation.js"></script>
<link rel="stylesheet" href="../../UTILITY/CSS/PatientInformation.css">
<script type="text/javascript"
	src="../../UTILITY/Script/PatientInformation.js"></script>
<link rel="stylesheet"
	href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
</head>
<body
	style="color: #2e2e2e; overflow-x: hidden; background: url('http://www.newsroompost.com/wp-content/uploads/2015/03/cream_pixels.png');">

	<!-- Header -->
	<div style='margin: 30px;' align="center">
		<h2>Patient Information</h2>
	</div>


	<!-- Body -->
	<hr width="99%" class="style-two">
	<table align="center">
		<tr>
			<td class="inputInfo">&nbspPatient's Name:&nbsp</td>
			<td><input type="text" id="IDPatientName" name="hint" size="30"
				height="15" class="userInput" /></td>
			<td class="inputInfo">&nbsp&nbspPatient's Id:&nbsp</td>
			<td><input type="text" id="IDPatientId" name="hint" size="30"
				height="15" class="userInput"/></td>
			<td>&nbsp&nbsp<input type="button" name="submit" value="View"
				id="IDButton" class="btn"></td>
		</tr>
	</table>
	<hr width="99%" class="style-two">

	<br>
	<br>
	<br>
	<br>
	<br>


	<table class="pure-table" id="idTable" align="center">
		<thead>
			<tr>
				<th>Name</th>
				<th>Gender</th>
				<th>BloodType</th>
				<th>SSN</th>
				<th>PatientID</th>
			</tr>
		</thead>

		<tbody>


		</tbody>
	</table>
</body>


</html>