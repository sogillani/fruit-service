package se.waya.fruit.service.domain;

import java.util.ArrayList;
import java.util.List;

public class FruitDeal {

    List<FruitBasket> fruitBaskets;

    public FruitDeal() {
        fruitBaskets = new ArrayList<>();
    }

    public List<FruitBasket> getFruitBaskets() {
        return fruitBaskets;
    }

    /**
     * Calculate the total price for the deal
     * @return total price
     */
    public Double getDealPrice() {
        Double totalPrice = 0.0;
        for(FruitBasket fruitBasket : fruitBaskets) {
            totalPrice += fruitBasket.getPrice();
        }

        return totalPrice;
    }
}
