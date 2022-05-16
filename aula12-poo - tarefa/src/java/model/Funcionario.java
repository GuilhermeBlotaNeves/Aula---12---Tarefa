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
public class Funcionario {
    public int EmployeeId;
    public String FirstName;
    public String LastName;
    public String Title;
    public String BirthDate;
    public String HireDate;
    public String Address;
    public String City;
    public String State;
    public String Country;
    public String PostalCode;
    public String Phone;
    public String Fax;
    public String Email;

    public Funcionario(int EmployeeId, String FirstName, String LastName, String Title, String BirthDate, String HireDate, String Address, String City, String State, String Country, String PostalCode, String Phone, String Fax, String Email) {
        this.EmployeeId = EmployeeId;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Title = Title;
        this.BirthDate = BirthDate;
        this.HireDate = HireDate;
        this.Address = Address;
        this.City = City;
        this.State = State;
        this.Country = Country;
        this.PostalCode = PostalCode;
        this.Phone = Phone;
        this.Fax = Fax;
        this.Email = Email;
    }
    
    public static ArrayList<Funcionario> getList() throws Exception {
        ArrayList<Funcionario> list = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        String url = "jdbc:sqlite:C:\\Users\\bdsqlite\\chinook.db";
        Connection con = DriverManager.getConnection(url);
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employees");
        while (rs.next()) {
            list.add(new Funcionario(rs.getInt("EmployeeId"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getString("Title"),
                            rs.getString("BirthDate"),
                            rs.getString("HireDate"),
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

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int EmployeeId) {
        this.EmployeeId = EmployeeId;
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

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getHireDate() {
        return HireDate;
    }

    public void setHireDate(String HireDate) {
        this.HireDate = HireDate;
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
