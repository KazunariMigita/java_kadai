package kadai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import kadai.controller.CustomerController;
import kadai.controller.SushiController;
import kadai.model.Customer;
import kadai.model.Sushi;
import kadai.model.SushiList;

public class Main {
    public static void main(String[] args) {
        SushiList sushiMap = new SushiList();
        List<Sushi> sushiList = new ArrayList<>();
        Customer yamada = new Customer("山田", 10000);
        CustomerController customerController = new CustomerController(yamada);

        sushiMap.addSushi(new Sushi("サーモン", 150, 10));
        sushiMap.addSushi(new Sushi("マグロ", 200, 10));
        sushiMap.addSushi(new Sushi("イカ", 100, 10));
        sushiMap.addSushi(new Sushi("タコ", 120, 10));
        sushiMap.addSushi(new Sushi("ウニ", 300, 10));

        mapToList(sushiList, sushiMap.getSushiList());
        displayMenu(sushiMap);
        shopping(yamada, sushiList, customerController, sushiMap);
        yamada.getPurchasedList();
    }

    public static void displayMenu(SushiList sushiMap) {
        System.out.println("メニュー");
        for (Map.Entry<Sushi,Boolean> entry : sushiMap.getSushiList().entrySet()) {
            Sushi sushi = entry.getKey();
            System.out.println(sushi.getName() + " " + sushi.getPrice() + "円");
        }
    }
    public static void mapToList(List<Sushi> sushiList, Map<Sushi, Boolean> sushiMap) {
        for (Map.Entry<Sushi, Boolean> entry : sushiMap.entrySet()) {
            Sushi sushi = entry.getKey();
            sushiList.add(sushi);
        }
    }

public static void shopping(Customer customer, List<Sushi> sushiLists, CustomerController customerController, SushiList sushiMap) {
    Random random = new Random();
    int quantity = 1;

    while (true) {
        Sushi sushi = sushiLists.get(random.nextInt(sushiLists.size()));

        if(sushiMap.getSushiList().isEmpty()) {
            System.out.println("寿司がありません");
            break;
        }
        if (sushi.outOfStock()) {
            System.out.println(sushi.getName() + " は在庫切れです。別の商品を選びます。");
            break;
        }

        if (customer.outOfBudget(sushi.getPrice())) {
            System.out.println("残高不足です。" + customer.getName() + " の残高は " + customer.getBudget() + " 円です");
            break;
        }
        

        sushi.reduceStock(quantity);
        customer.reduceBudget(sushi.getPrice());
        customerController.addpurchasedItem(sushi.getName(), sushi.getPrice());
        System.out.println();

        System.out.println(sushi.getName() + " を " + quantity + " 個購入しました");
        System.out.println("残りの在庫は " + sushi.getStock() + " 個です");
        System.out.println(customer.getName() + " の残高: " + customer.getBudget() + " 円");
        System.out.println("-----");
    }
}


}
