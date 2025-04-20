package kadai.model;

import java.util.HashMap;
import java.util.Map;

public class Customer {
    private final String name;
    private int budget;

    Map<String, Integer> purchasedList = new HashMap<>();

    public Customer(String name, int budget) {
        this.name = name;
        this.budget = budget;
    }

    public String getName() {
        return name;
    }
    
    public int getBudget() {
        return budget;
    }

    public Map<String, Integer> getPurchasedList() {
        return purchasedList;
    }

    public boolean outOfBudget(int price) {
        if (budget <= price) {
            return true;
        } 
        return false;
    }

    public void reduceBudget(int price) {
        budget -= price;
    }


}
