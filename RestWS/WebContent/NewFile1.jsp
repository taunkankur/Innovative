<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE"> 
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>
    $('textInputId').click(function(){
    
    alert('hey');
    
    });
</script>
<% response.addHeader("X-Frame-Options", "SAMEORIGIN"); %> 
</head>
<body>
<table border="0" align="center">
<tr>
<td><h4>URL : </h4></td><td> <input type="text" size="100"> </td><td><input type="button" value="Click Me"> </td>
</tr>
</table>

<iframe width="100%" height="100%" id="iFrameID" src="http://www.google.com"></iframe>



</body>
</html>