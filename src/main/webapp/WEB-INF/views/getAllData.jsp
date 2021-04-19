<%@page import="com.te.employeeinfospringmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.*" %>   
<%@page import="com.te.employeeinfospringmvc.bean.EmployeeBean" %>        
    
    <%
    List<EmployeeBean> employeebean= (List<EmployeeBean>)request.getAttribute("msg");
    String err=(String) request.getAttribute("errmsg");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<% if(err!=null && !err.isEmpty()){%>
   <h1 style="color:red"><%=err %></h1> 
 <% } %>

</body>
</html>