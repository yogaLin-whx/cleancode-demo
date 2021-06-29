package com.tw.academy.basic.$7_long_method;

/**
 * This class is a example for bad smell;
 *
 * @author  Thoughtworks
 * @version 1.0
 * @since   2018-1-1
 */
public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    //Deprecated
    public String printCustomerName() {
        return order.getCustomerName();
    }

    //todo: rename -- Tom
    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        double totalSalesTax = 0d;
        double totalAmount = 0d;
        printHeader(output);


        for (LineItem lineItem : order.getLineItems()) {
            getLineItemString(output, lineItem);

            // calculate sales tax @ rate of 10%
            double salesTax = lineItem.totalAmount() * .10;
            totalSalesTax += salesTax;

            // calculate total amount of lineItem = price * quantity + 10 % sales tax
            totalAmount += lineItem.totalAmount() + salesTax;
        }

        printResult(output, totalSalesTax, totalAmount);
        return output.toString();
    }

    public void printResult(StringBuilder output, double totalSalesTax, double totalAmount) {
        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    public void printHeader(StringBuilder output) {
        output.append("======Printing Orders======\n");
        output.append(order.printCustomerDetail());
    }

    public void getLineItemString(StringBuilder output, LineItem lineItem) {
        output.append(lineItem.toString());
    }
}