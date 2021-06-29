package com.tw.academy.basic.$7_long_method;

import java.util.List;

public class Order {
    static double totalSalesTax;
    static double totalAmount;
    String customerName;
    String address;
    List<LineItem> lineItems;

    public Order(String customerName, String address, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.address = address;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String printCustomerDetail() {
        return this.customerName + this.address;
    }

    public String lineItemsDetail() {
        StringBuilder output = new StringBuilder();
        for (LineItem lineItem : getLineItems()) {
            output.append(lineItem.toString());

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        return output.toString();
    }
}
