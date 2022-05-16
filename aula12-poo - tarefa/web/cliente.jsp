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
<%@page import="model.Cliente"%>
<%@page import="java.util.ArrayList"%>



<%
    Exception requestEx = null;
    ArrayList<Cliente> list = new ArrayList<>();
    try {
        list = Cliente.getList();
    } catch (Exception ex) {
        requestEx = ex;
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Índice - Cliente</title>
    </head>
    <body>
        <h1>JDBC</h1>
        <h2>Clientes</h2>

        <% if (requestEx != null) {%>
        <h2 style="color:red"><%= requestEx.getMessage()%></h2>
        <%}%>

        <table border="1">
            <tr><th>Id</th><th>Nome</th></tr>
                    <% for (Cliente a : Cliente.getList()) {%>
            <tr>
                <td><%= a.getCustomerId()%></td>
                <td><%= a.getFirstName()%></td>
                <td><%= a.getLastName()%></td>
                <td><%= a.getCompany()%></td>
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
