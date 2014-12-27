<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="./Script/sortable.js"></script> 
<link href="http://www.joostdevalk.nl/" rev="made" />

<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">
<script type="text/javascript">
$(document).ready(function() 
	    { 
	        $("#myTable").tablesorter(); 
	    } 
	);
</script>
<style type="text/css">
/* Copyright 2006 Joost de Valk */
a img {
	border: 0;
}
table.sortable {
	border-spacing: 0;
	border: 1px solid #000;
	border-collapse: collapse;
}
table.sortable th, table.sortable td {
	text-align: left;
	padding: 2px 4px 2px 4px;
	width: 100px;
	border-style: solid;
	border-color: #444;
}
table.sortable th {
	border-width: 0px 1px 1px 1px;
	background-color: #ccc;
}
table.sortable td {
	border-width: 0px 1px 0px 1px;
}
table.sortable tr.odd td {
	background-color: #ddd;
}
table.sortable tr.even td {
	background-color: #fff;
}
table.sortable tr.sortbottom td {
	border-top: 1px solid #444;
	background-color: #ccc;
	font-weight: bold;
}
</style>
</head>
<body>
<table class="sortable" id="anyid" cellpadding="0" cellspacing="0">
<tr>
	<th>Numbers</th>
	<th>Alphabet</th>
	<th>Dates</th>
	<th>Currency</th>
	<th class="unsortable">Unsortable</th>
</tr>
<tr>
	<td>1</td>
	<td>Z</td>
	<td>01-01-2006</td>
	<td>&euro; 5.00</td>
	<td>Unsortable</td>
</tr>
<tr>
	<td>2</td>
	<td>y</td>
	<td>04-13-2005</td>
	<td>&euro; 6.70</td>
	<td>Unsortable</td>
</tr>
<tr>
	<td>3</td>
	<td>X</td>
	<td>08-17-2006</td>
	<td>&euro; 6.50</td>
	<td>Unsortable</td>
</tr>
<tr>
	<td>4</td>
	<td>w</td>
	<td>01-01-2005</td>
	<td>&euro; 4.20</td>
	<td>Unsortable</td>
</tr>
<tr>
	<td>5</td>
	<td>V</td>
	<td>05-12-2006</td>
	<td>&euro; 7.15</td>
	<td>Unsortable</td>
</tr>
<tr class="sortbottom">
	<td>15</td>
	<td></td>
	<td></td>
	<td>&euro; 29.55</td>
	<td></td>
</tr>
</table>
 
</body>
</html>