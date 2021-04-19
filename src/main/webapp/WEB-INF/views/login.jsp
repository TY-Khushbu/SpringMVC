<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String msg=(String)request.getAttribute("errmsg"); %>
    
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

   <fieldset>
   <h1>Hello Khushbu</h1>
   <legend>Login</legend>
  <form action="./login" method="post"> 
   <table>
      <tr>
         <td>Employee Id</td>
         <td>:</td>
         <td><input type="text" name="id"></td>
      </tr>
      <tr>
         <td>Enter Password</td>
         <td>:</td>
         <td><input type="password" name="password"></td>
      </tr>
     <tr>
         <td><input type="submit" value="submit"></td>
      </tr>
   </table>
   </form>
  </fieldset>
</body>
</html>