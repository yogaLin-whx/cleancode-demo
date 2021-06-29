package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author Thoughtworks
 * @version 1.0
 * @since 2018-1-1
 */
public class OrderReceipt {
    private Order order;
    private StringBuilder output;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        output = new StringBuilder();
        printHeader();

        getLineItemsDetail();

        printResult();
        return output.toString();
    }

    public void printResult() {
        this.output.append("Sales Tax").append('\t').append(order.totalSalesTax);
        this.output.append("Total Amount").append('\t').append(order.totalAmount);
    }

    public void printHeader() {
        output.append("======Printing orders======\n");
        output.append(order.printCustomerDetail());
    }

    public void getLineItemsDetail() {
        this.output.append(order.lineItemsDetail());
    }

}