package se.waya.fruit.service.search;

import se.waya.fruit.service.domain.FruitDeal;
import se.waya.fruit.service.domain.FruitStand;

public class SearchResult {

    private FruitStand fruitStand;
    private FruitDeal fruitDeal;
    private Integer selections;

    public SearchResult() {
        selections = 0;
    }

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

    public Integer getSelections() {
        return selections;
    }

    public void setSelections(Integer selections) {
        this.selections = selections;
    }
}
