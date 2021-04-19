<%@page import="com.te.employeeinfospringmvc.bean.EmployeeBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg=(String)request.getAttribute("errmsg");
       EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("data");
    %>
    
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <% if(msg!=null && !msg.isEmpty()){%>
   <h1 style="color:red"><%=msg %></h1> 
   <% } %>
   
   
   <% if(employeeBean!=null){ %>
  <h4>Name : <%=employeeBean.getName() %></h4> 
  <h4>Id : <%=employeeBean.getId() %></h4> 
  <h4>Name : <%=employeeBean.getDob() %></h4> 
   <% } %>
<fieldset>
   <legend>Login</legend>

   <form action="./search1" method="">
   <table>
      <tr>
         <td>Enter Id</td>
         <td>:</td>
         <td><input type="text" name="id"></td>
      </tr>
 
     <tr>
         <td><input type="submit" name="search"></td>
      </tr>
   </table>
   </form>
  </fieldset>
  

</body>
</html>