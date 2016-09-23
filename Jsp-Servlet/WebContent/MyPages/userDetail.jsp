<%@page import="ComponentsValueObjects.FormComponentVO"%>
<%@page import="ComponentsValueObjects.TableComponentVO"%>
<%@page import="beans.EmployeeBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/Tlds/employeEntryTag.tld" prefix="ee" %>
<%@ taglib uri="/WEB-INF/Tlds/myCaptions.tld" prefix="mc" %>
<%@ taglib uri="/WEB-INF/Tlds/myTable.tld" prefix="mt" %>
<%@ taglib uri="/WEB-INF/Tlds/formComponent.tld" prefix="fv" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script  type="text/javascript" src="jquery-1.12.4.min.js"></script>
<style type="text/css">
.highlite{
	background-color: lightblue;
}
</style>
</head>
<body>
<%
	//TableComponentVO tableAttributes =(TableComponentVO)session.getAttribute("tableAttributes ");
	ArrayList<FormComponentVO> formView=(ArrayList<FormComponentVO>)session.getAttribute("formView");
	System.out.print(formView.get(0).getComponentCaption());
	ArrayList<String> captionList=new ArrayList<String>();
	captionList.add("Id");
	captionList.add("Name");
	captionList.add("DOB");
	ArrayList<String> typeList=new ArrayList<String>();
	typeList.add("outputText");
	typeList.add("inputText");
	typeList.add("calenderCombo");
	ArrayList<EmployeeBean> valueList=new ArrayList<EmployeeBean>();
	EmployeeBean empBean=new EmployeeBean();
	empBean.setEmpId("Emp001");
	empBean.setEmpName("Viswa");
	empBean.setDOB("20-Jun-1988");
	valueList.add(empBean);
	empBean=new EmployeeBean();
	empBean.setEmpId("Emp002");
	empBean.setEmpName("Siva");
	empBean.setDOB("04-July-1988");
	valueList.add(empBean);
	
 %>
 <script>
	$(document).ready(function(){
 alert("ready");
 });
</script> 
 <script type="text/javascript">
 
 
 	function selectRow(comp){
 		//alert(comp.checked);
 		if(comp.checked){
 			comp.parentNode.parentNode.setAttribute('class','highlite');
 		}else{
 			comp.parentNode.parentNode.setAttribute('class','');
 		}
 	}
 	function radioclick(comp){
 		<%
 			//session.setAttribute("radioselect", "on");
 			request.setAttribute("radioselect", "on");
 		%>
 		window.location.reload(true);
 	}
 </script>
 
<!-- <table align="center" border="2" width="50%">
	<tr bgcolor="#E1D4D4"><th>id</th><th>name</th></tr>
	<tr><td>1</td><td>viswa</td></tr>
</table> -->
	<%-- <div style="font-weight: bold; color: blue; font-size: large; border: thin;">
		<center>Employee Details</center><br/><br/><br/>
		<ee:EmpEntry captions="id;name;dob" type="text;text"/>
	</div> --%>
	<mc:caption value="Employee Details" style="font-weight: bold; color: blue; font-size: large; border: thin;"/>
	<br/><br/><br/><br/><br/><br/>
	<%-- <ee:EmpEntry captions="<%=captionList%>" type="<%=typeList%>" value="<%=valueList %>"/> --%>
	
	<%-- <mt:Table binding="<%=tableAttributes %>"/> --%>
	<fv:FormView binding="<%=formView %>"></fv:FormView>
	
</body>
</html>