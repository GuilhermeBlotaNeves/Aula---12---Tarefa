<%-- 
    Document   : index
    Created on : 9 de mai. de 2022, 16:15:47
    Author     : Fatec
--%>

<%@page import="Model.Customers"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Exception requestEx = null;
    ArrayList<Customers> list = new ArrayList<>();
    int count = 0;
    try{
        count = Customers.getCount();
        list = Customers.getList();
    }catch(Exception e){
        requestEx = e;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> JDBC | Clientes</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2>Lista de Clientes</h2>
        <%if(requestEx!=null){%>
        <h3 style="color: red"><%= requestEx.getMessage() %></h3>
        <%}%>
        <table border="4">
            <tr><th>id</th><th>name</th><th>LastName</th><th>Company</th></tr>
            <%for(Customers b: list){%>
            <tr>
                <td><%= b.getId() %></td>
                <td><%= b.getName() %></td>
                <td><%= b.getLastName()%></td>
                <td><%= b.getCompany()%></td>
            </tr>
            <%}%>
        </table>
    </body>
</html>