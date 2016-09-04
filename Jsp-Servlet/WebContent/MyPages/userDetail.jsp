<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/Tags/employeEntryTag.tld" prefix="ee" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div style="font-weight: bold; color: blue; font-size: large; border: thin;">
		<center>Employee Details</center><br/><br/><br/>
		<ee:EmpEntry captions="id;name;dob" type="text;text"/>
	</div>
</body>
</html>