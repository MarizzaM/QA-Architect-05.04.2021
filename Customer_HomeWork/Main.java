package com.company;

import java.sql.*;
import java.util.Scanner;
import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Customer> customers = new ArrayList<>();


    public static void main(String[] args) {

        CustomerDAO customerDAO = new CustomerDAO("jdbc:sqlite:C:/SQLite/Customers.db");

        customerDAO.selectQuery("Select * from Customer");

        System.out.println("\n=====================");

        customerDAO.updateQuery("Update Customer set NumberOfOrders = 1 where FirstName like '%Sub'");

        System.out.println("\n=====================");

        customers = customerDAO.getAllCustomers();
        printCustomers(customers);

        System.out.println("\n=====================");

        System.out.println("Please enter id of the customer: ");
        int id = scanner.nextInt();
        System.out.println(customerDAO.getCustomerById(id));

        System.out.println("\n======== after sort By LastName ==========");

        Collections.sort(customers);
        printCustomers(customers);

        System.out.println("\n======== after sort By number of orders ==========");

        Collections.sort(customers, new CustomerSortByNumberOfOrders());
        printCustomers(customers);
    }

    static void printCustomers (ArrayList<Customer> customers){
        Iterator<Customer> i = customers.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

}
