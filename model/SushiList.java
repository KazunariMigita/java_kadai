package kadai.model;

import java.util.HashMap;
import java.util.Map;


public class SushiList {
    Sushi sushi;
    private Map<Sushi, Boolean> sushiList ;

    public SushiList() {
        this.sushiList = new HashMap<>();
    }

    public void addSushi(Sushi sushi) {
        if(sushi.outOfStock()) {
            System.out.println("在庫がありません");
            return;
        }
        sushiList.put(sushi, !sushi.outOfStock());
    }


}
