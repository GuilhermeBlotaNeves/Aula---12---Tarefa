<%-- 
    Document   : index.jsp
    Created on : 9 de mai. de 2022, 20:35:37
    Author     : Fatec
--%>

<%--
Document : index
Created on : 9 de mai. de 2022, 20:09:30
Author : Fatec
--%>
<%@page import="model.Funcionario"%>
<%@page import="java.util.ArrayList"%>



<%
    Exception requestEx = null;
    ArrayList<Funcionario> list = new ArrayList<>();
    try {
        list = Funcionario.getList();
    } catch (Exception ex) {
        requestEx = ex;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Índice - Funcionarios</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2>Funcionarios</h2>

        <% if (requestEx != null) {%>
        <h2 style="color:red"><%= requestEx.getMessage()%></h2>
        <%}%>

        <table border="1">
            <tr><th>Id</th><th>Nome</th></tr>
                    <% for (Funcionario a : Funcionario.getList()) {%>
            <tr>
                <td><%= a.getEmployeeId()%></td>
                <td><%= a.getFirstName()%></td>
                <td><%= a.getLastName()%></td>
                <td><%= a.getTitle()%></td>
                <td><%= a.getBirthDate()%></td>
                <td><%= a.getHireDate()%></td>                
                <td><%= a.getAddress()%></td>
                <td><%= a.getCity()%></td>
                <td><%= a.getState()%></td>
                <td><%= a.getCountry()%></td>
                <td><%= a.getPostalCode()%></td>
                <td><%= a.getPhone()%></td>
                <td><%= a.getFax()%></td>
                <td><%= a.getEmail()%></td>           
            </tr>
            <%}%>
        </table>
    </body>
</html>
