/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fatec
 */
public class Customers {

    private int id;
    private String name;
    private String lastName;
    private String company;

    public static int getCount() throws Exception {
        ArrayList<Customers> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        //O caminho do arquivo deve ser diferente se executado do seu PC
        //https://www.sqlitetutorial.net/sqlite-sample-database/
        String url = "jdbc:sqlite:C:\\Users\\Fatec\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select count(*) as count from Cliente");
        int count = 0;
        while (rs.next()) {
            int id = rs.getInt("customersId");
            String name = rs.getString("name");
            String lastName = rs.getString("lastName");
            String company = rs.getString("company");
            Customers b = new Customers(id, name, lastName, company );
            list.add(b);
            count = rs.getInt("count");
        }
        rs.close();
        stmt.close();
        con.close();
        return count;
    }
     public static ArrayList<Customers> getList() throws Exception{
        ArrayList<Customers> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        //O caminho do arquivo deve ser diferente se executado do seu PC
        //https://www.sqlitetutorial.net/sqlite-sample-database/
        String url = "jdbc:sqlite:C:\\Users\\rlarg\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from artists order by name");
        while(rs.next()){
           int id = rs.getInt("customersId");
            String name = rs.getString("name");
            String lastName = rs.getString("lastName");
            String company = rs.getString("company");
            Customers b = new Customers(id, name, lastName, company );
            list.add(b);
        }
        rs.close();
        stmt.close();
        con.close();
        return list;
    }

    public Customers(int id, String name, String lastName, String company1) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
