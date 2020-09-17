package se.waya.fruit.service.search;

import java.util.ArrayList;
import java.util.List;

public class FruitDealCriteria {

    private List<String> desiredFruits;

    public FruitDealCriteria() {
        desiredFruits = new ArrayList<String>();
    }

    public List<String> getDesiredFruits() {
        return desiredFruits;
    }
}
