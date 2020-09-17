package se.waya.fruit.service.search;

import se.waya.fruit.service.domain.FruitDeal;
import se.waya.fruit.service.domain.FruitStand;

public class SearchResult {

    private FruitStand fruitStand;
    private FruitDeal fruitDeal;

    public FruitStand getFruitStand() {
        return fruitStand;
    }

    public void setFruitStand(FruitStand fruitStand) {
        this.fruitStand = fruitStand;
    }

    public FruitDeal getFruitDeal() {
        return fruitDeal;
    }

    public void setFruitDeal(FruitDeal fruitDeal) {
        this.fruitDeal = fruitDeal;
    }
}
