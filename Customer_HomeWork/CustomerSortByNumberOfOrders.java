package com.company;

import java.util.Comparator;

public class CustomerSortByNumberOfOrders implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return Integer.compare(o1.getNumberOfOrders(), o2.getNumberOfOrders());
    }
}
