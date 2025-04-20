package kadai;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import kadai.controller.CustomerController;
import kadai.model.Customer;
import kadai.model.Sushi;

public class Main {
    public static void main(String[] args) {
        List<Sushi> sushiList = new ArrayList<>();
        Customer yamada = new Customer("山田", 1000);
        CustomerController customerController = new CustomerController(yamada);

        sushiList.add(new Sushi("サーモン", 150, 10));
        sushiList.add(new Sushi("マグロ", 200, 10));
        sushiList.add(new Sushi("イカ", 100, 10));
        sushiList.add(new Sushi("タコ", 120, 10));
        sushiList.add(new Sushi("ウニ", 300, 10));

        displayMenu(sushiList);
        shopping(yamada, sushiList, customerController);
    }

    public static void displayMenu(List<Sushi> sushiList) {
        System.out.println("メニュー");
        for (Sushi sushi : sushiList) {
            System.out.println(sushi.getName() + " " + sushi.getPrice() + "円");
        }
    }

public static void shopping(Customer customer, List<Sushi> sushiList, CustomerController customerController) {
    Random random = new Random();
    int quantity = 1;

    while (true) {
        Sushi sushi = sushiList.get(random.nextInt(sushiList.size()));

        if (sushi.outOfStock()) {
            System.out.println(sushi.getName() + " は在庫切れです。別の商品を選びます。");
            continue;
        }

        if (customer.outOfBudget(sushi.getPrice())) {
            System.out.println("残高不足です。" + customer.getName() + " の残高は " + customer.getBudget() + " 円です");
            break;
        }

        sushi.reduceStock(quantity);
        customer.reduceBudget(sushi.getPrice());
        customerController.addpurchasedItem(sushi.getName(), sushi.getPrice());

        System.out.println(sushi.getName() + " を " + quantity + " 個購入しました");
        System.out.println("残りの在庫は " + sushi.getStock() + " 個です");
        System.out.println(customer.getName() + " の残高: " + customer.getBudget() + " 円");
        System.out.println("-----");
    }
}


}
