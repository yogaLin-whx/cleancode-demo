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
        order.totalSalesTax = 0d;
        order.totalAmount = 0d;
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
        lineItemsDetail();
    }

    public void lineItemsDetail() {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.toString());

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            order.totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            order.totalAmount += lineItem.totalAmount() + salesTax;
        }
    }

}