package com.tw.academy.basic.$5_data_clumps;

public class User {
    private final String receiverName;
    private final String receiverPhoneNumber;
    private final String receiverAddress;

    public User(String receiverName, String receiverPhoneNumber, String receiverAddress) {
        this.receiverName = receiverName;
        this.receiverPhoneNumber = receiverPhoneNumber;
        this.receiverAddress = receiverAddress;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public String getReceiverPhoneNumber() {
        return receiverPhoneNumber;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }
}
