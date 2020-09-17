package se.waya.fruit.service.search;

import java.util.ArrayList;
import java.util.List;

public class FruitDealCriteria {

    private List<String> desiredFruits;
    private List<String> choiceFruits;

    public FruitDealCriteria() {
        desiredFruits = new ArrayList<>();
        choiceFruits = new ArrayList<>();
    }

    public List<String> getDesiredFruits() {
        return desiredFruits;
    }

    public List<String> getChoiceFruits() {
        return choiceFruits;
    }
}
