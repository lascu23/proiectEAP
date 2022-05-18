package proiect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Order implements Comparable<Order>{
    private String orderDate;
    private int orderID;
    private List<Product> products = new ArrayList<>();

    public Order() {
        this.orderDate = " ";
        this.orderID = 0;
        this.products = null;
    }

    public Order(String orderDate, int orderID, List products) {
        this.orderDate = orderDate;
        this.orderID = orderID;
        this.products = products;
        Collections.sort(products);//este sortata lexicografic
    }

    public String getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public List getProducts() {return products;}
    public void setProducts(List products) {this.products = products;}

    public String toString(){return "Comanda din data de " + orderDate + " are codul " +
                                     orderID+ " si contine "+ products;}
    public int compareTo(Order j){
        Integer _orderID = new Integer(this.orderID);
        return _orderID.compareTo(j.orderID);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;
        Order order = (Order) o;
        return orderID == order.orderID && orderDate.equals(order.orderDate);
    }
}
