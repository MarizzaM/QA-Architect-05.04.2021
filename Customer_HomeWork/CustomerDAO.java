package com.company;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAO {

    private String m_conn;

    public CustomerDAO(String m_conn) {
        this.m_conn = m_conn;
    }

    public void selectQuery(String query){
        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = query;

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    System.out.println(rs.getInt("Id") + "\t" +
                            rs.getString("FirstName") + "\t" +
                            rs.getString("LastName") + "\t" +
                            rs.getInt("NumberOfOrders") + "\t" +
                            rs.getFloat("Height")
                    );
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateQuery(String query){

        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query
                String sql = query;

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                int result = stmt.executeUpdate(sql); // not expect result
                System.out.println(result + " record updated.");
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public ArrayList<Customer> getAllCustomers(){

        ArrayList<Customer> customers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = "SELECT * FROM Customer";

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    Customer e = new Customer(
                            rs.getInt("Id"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getInt("NumberOfOrders"),
                            rs.getFloat("Height"));
                    customers.add(e);
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  customers;
    }

    public Customer getCustomerById(int id){
        // try to connect to db
        try (Connection conn = DriverManager.getConnection(m_conn)) {
            // check if connection succeed
            if (conn != null) {

                // prepare query string
                String sql = String.format("Select * from Customer where id = %d", id );

                // prepare statement
                Statement stmt = conn.createStatement();

                // fire query
                ResultSet rs = stmt.executeQuery(sql);

                // read results
                while (rs.next()) {
                    Customer e = new Customer(
                            rs.getInt("Id"),
                            rs.getString("FirstName"),
                            rs.getString("LastName"),
                            rs.getInt("NumberOfOrders"),
                            rs.getFloat("Height"));
                    return e;
                }
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;

    }
}
