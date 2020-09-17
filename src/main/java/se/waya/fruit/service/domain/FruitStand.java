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

        if (fruitDealCriteria.getChoiceFruits().size() > 0) {
            FruitBasket fruitChoice = null;
            Double minimumPrice = Double.MAX_VALUE;
            for (String fruit : fruitDealCriteria.getChoiceFruits()) {
                FruitBasket fruitBasket = fruitBasketMap.get(fruit);
                if (minimumPrice.compareTo(fruitBasket.getPrice()) > 0) {
                    fruitChoice = fruitBasket;
                    minimumPrice = fruitBasket.getPrice();
                }
            }

            if (fruitChoice == null) {
                return null;
            }
            fruitDeal.getFruitBaskets().add(fruitChoice);
        }


        return fruitDeal;
    }
}
