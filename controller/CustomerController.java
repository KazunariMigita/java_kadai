package kadai.controller;

import kadai.model.Customer;

public class CustomerController {
    Customer customer;

    public CustomerController(Customer customer) {
        this.customer = customer;
    }


    public void addpurchasedItem(String sushiName, int price) {
        customer.getPurchasedList().put(sushiName, price);
    }




}
