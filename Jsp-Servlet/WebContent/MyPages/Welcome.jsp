<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/Tags/helloTag.tld" prefix="hl" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
	function gotoHome(){
		//alert('hi');
		document.getElementById("hiddeninput").value="abcd";
		document.location='welcome.lt?spclChar=à';
	}
</script>
</head>
<body>
	<hl:hello/> <br/><br/>
	<input type="hidden" id="hiddeninput" value="">
	<input type="button" value="Continue >>>" onclick="gotoHome();"/>
</body>
</html>