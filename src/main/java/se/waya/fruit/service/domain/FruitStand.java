package se.waya.fruit.service.domain;

import se.waya.fruit.service.search.FruitDealCriteria;

import java.util.HashMap;
import java.util.Map;

public class FruitStand {
    private String standNo;
    private Map<String, FruitBasket> fruitBasketMap;

    public FruitStand(String standNo) {
        this.standNo = standNo;
        fruitBasketMap = new HashMap<String, FruitBasket>();
    }

    public String getStandNo() {
        return standNo;
    }

    public Map<String, FruitBasket> getFruitBasketMap() {
        return fruitBasketMap;
    }

    public FruitDeal matchCriteria(FruitDealCriteria fruitDealCriteria) {
        FruitDeal fruitDeal = new FruitDeal();
        for (String fruit : fruitDealCriteria.getDesiredFruits()) {

            FruitBasket fruitBasket = fruitBasketMap.get(fruit);

            if (fruitBasket != null) {
                fruitDeal.getFruitBaskets().add(fruitBasket);
            } else {
                return null;
            }
        }

        return fruitDeal;
    }
}
