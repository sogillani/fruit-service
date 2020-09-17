package se.waya.fruit.service.domain;

import org.junit.Test;
import se.waya.fruit.service.Fruits;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FruitDealTest {

    @Test
    public void testGetDealPrice() {
        FruitDeal fruitDeal = getFruitDeal();
        Double dealPrice = fruitDeal.getDealPrice();

        assertEquals(dealPrice.compareTo(58.0), 0);
        assertNotEquals(dealPrice.compareTo(59.0), 0);
    }

    public static FruitDeal getFruitDeal() {
        FruitDeal fruitDeal = new FruitDeal();

        fruitDeal.getFruitBaskets().add(new FruitBasket(Fruits.CHERRY, 27.0));
        fruitDeal.getFruitBaskets().add(new FruitBasket(Fruits.PEACH, 31.0));

        return fruitDeal;
    }
}
