package se.waya.fruit.service.data;

import se.waya.fruit.service.Fruits;
import se.waya.fruit.service.domain.FruitBasket;
import se.waya.fruit.service.domain.FruitStand;

import java.util.ArrayList;
import java.util.List;


/**
 * This Class will provide test hard-coded assumed data
 */
public class FruitServiceDataProvider {

    public List<FruitStand> getFruitStandsList() {
        List<FruitStand> fruitStands = new ArrayList<FruitStand>();

        fruitStands.add(getFruitStand("1",
                new FruitBasket(Fruits.CHERRY, 20.0),
                new FruitBasket(Fruits.PEACH, 30.0)
        ));

        fruitStands.add(getFruitStand("2",
                new FruitBasket(Fruits.CHERRY, 25.0),
                new FruitBasket(Fruits.PEACH, 22.0)
        ));

        fruitStands.add(getFruitStand("1",
                new FruitBasket(Fruits.CHERRY, 27.0),
                new FruitBasket(Fruits.PEACH, 31.0)
        ));

        fruitStands.add(getFruitStand("1",
                new FruitBasket(Fruits.CHERRY, 26.0),
                new FruitBasket(Fruits.PEACH, 37.0)
        ));

        fruitStands.add(getFruitStand("1",
                new FruitBasket(Fruits.CHERRY, 24.0),
                new FruitBasket(Fruits.PEACH, 38.0)
        ));

        return fruitStands;
    }

    public FruitStand getFruitStand(String standNo, FruitBasket ... fruitBaskets) {
        FruitStand fruitStand = new FruitStand(standNo);
        for (FruitBasket fruitBasket : fruitBaskets) {
            fruitStand.getFruitBasketMap().put(fruitBasket.getFruitName(), fruitBasket);
        }

        return fruitStand;
    }

}
