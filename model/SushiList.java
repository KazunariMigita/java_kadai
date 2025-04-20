package kadai.model;

import java.util.HashMap;
import java.util.Map;


public class SushiList {
    Sushi sushi;
    private Map<Sushi, Boolean> sushiList ;

    public SushiList() {
        this.sushiList = new HashMap<>();
    }

    public Map<Sushi, Boolean> getSushiList() {
        return sushiList;
    }

    public void addSushi(Sushi sushi) {
        if(sushi.outOfStock()) {
            System.out.println("在庫がありません");
            return;
        }
        sushiList.put(sushi, !sushi.outOfStock());
    }

    public void removeSushi(Sushi sushi) {
        if(sushiList.containsKey(sushi)) {
            sushiList.remove(sushi);
        } else {
            System.out.println("その寿司は存在しません");
        }
    }
    

}
