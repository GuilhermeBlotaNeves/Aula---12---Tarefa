/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Fatec
 */
public class Cliente {
    public int CustomerId;
    public String FirstName;
    public String LastName;
    public String Company;
    public String Address;
    public String City;
    public String State;
    public String Country;
    public String PostalCode;
    public String Phone;
    public String Fax;
    public String Email;

    public Cliente(int CustomerId, String FirstName, String LastName, String Company, String Address, String City, String State, String Country, String PostalCode, String Phone, String Fax, String Email) {
        this.CustomerId = CustomerId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Company = Company;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.PostalCode = PostalCode;
        this.Phone = Phone;
        this.Fax = Fax;
        this.Email = Email;
    }
    
    public static ArrayList<Cliente> getList() throws Exception {
        ArrayList<Cliente> list = new ArrayList<Cliente>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\bdsqlite\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from customers");
        while (rs.next()) {
            list.add(new Cliente(rs.getInt("CustomerId"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("Company"),
                            rs.getString("Address"),
                            rs.getString("City"),
                            rs.getString("State"),
                            rs.getString("Country"),
                            rs.getString("PostalCode"),
                            rs.getString("Phone"),
                            rs.getString("Fax"),
                            rs.getString("Email")));
        }

        rs.close();
        stmt.close();
        con.close();
        return list;
    }
    
    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int CustomerId) {
        this.CustomerId = CustomerId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String Company) {
        this.Company = Company;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String PostalCode) {
        this.PostalCode = PostalCode;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String Fax) {
        this.Fax = Fax;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }
}
