package com.company;


//POJO
public class Customer implements Comparable<Customer>{

    public int Id;
    public String FirstName;
    public String LastName;
    public int NumberOfOrders;
    public float Height;

    public int getNumberOfOrders(){
        return NumberOfOrders;
    }

    public Customer() {
    }

    public Customer(int id, String firstname, String lastname, int numberOfOrders, float height) {
        Id = id;
        FirstName = firstname;
        LastName = lastname;
        NumberOfOrders = numberOfOrders;
        Height = height;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", NumberOfOrders=" + NumberOfOrders +
                ", Height=" + Height +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        return this.LastName.compareTo(o.LastName);
    }
}
