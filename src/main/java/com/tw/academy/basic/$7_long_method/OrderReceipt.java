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
    double totalSalesTax;
    double totalAmount;
    private StringBuilder output;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    //todo: rename -- Tom
    public String printReceipt() {
        output = new StringBuilder();
        totalSalesTax = 0d;
        totalAmount = 0d;
        output.append("======Printing Orders======\n");
        output.append(order.printCustomerDetail());

        getLineItemsDetail();

        printResult(totalSalesTax, totalAmount);
        return output.toString();
    }

    public void getLineItemsDetail() {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.toString());

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }
    }

    public void printResult(double totalSalesTax, double totalAmount) {
        this.output.append("Sales Tax").append('\t').append(totalSalesTax);
        this.output.append("Total Amount").append('\t').append(totalAmount);
    }

}