<%-- 
    Document   : Funcionarios
    Created on : 9 de mai. de 2022, 16:20:29
    Author     : Fatec
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Employees"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
   Exception requestEx = null;
    ArrayList<Employees> list = new ArrayList<>();
    int count = 0;
    try{
        count = Employees.getCount();
        list = Employees.getList();
    }catch(Exception e){
        requestEx = e;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JDBC | Funcionarios</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2>Lista de Funcionarios</h2>
        <%if(requestEx!=null){%>
        <h3 style="color: red"><%= requestEx.getMessage() %></h3>
        <%}%>
        <table border="4">
            <tr><th>id</th><th>name</th><th>LastName</th></tr>
            <%for(Employees a: list){%>
            <tr>
                <td><%= a.getId() %></td>
                <td><%= a.getName() %></td>
                <td><%= a.getLastName()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>