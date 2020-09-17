package se.waya.fruit.service;

import se.waya.fruit.service.data.FruitServiceDataProvider;
import se.waya.fruit.service.domain.FruitDeal;
import se.waya.fruit.service.domain.FruitStand;
import se.waya.fruit.service.search.FruitDealCriteria;
import se.waya.fruit.service.search.SearchResult;

import java.util.List;

/**
 * This class includes main method
 *
 * Fruit service helps to find best fruit deal available on different fruit stands
 */
public class FruitService {

    public static void main(String[] args) {

        FruitService fruitService = new FruitService();
        FruitDealCriteria fruitDealCriteria = new FruitDealCriteria();

        fruitDealCriteria.getDesiredFruits().add(Fruits.CHERRY);
        fruitDealCriteria.getDesiredFruits().add(Fruits.PEACH);

        SearchResult searchResult = fruitService.searchFruitDeal(fruitDealCriteria);
        System.out.println("*** Base Scenario ***");
        System.out.println("Stand No: " + searchResult.getFruitStand().getStandNo());
    }

    /**
     * Search for the best fruit deal
     *
     * @param fruitDealCriteria Desired criteria to search best deal available
     * @return Search result with best available deal
     */
    public SearchResult searchFruitDeal(FruitDealCriteria fruitDealCriteria) {

        FruitServiceDataProvider dataProvider = new FruitServiceDataProvider();
        List<FruitStand> fruitStands = dataProvider.getFruitStandsList();

        Double minimumTotalPrice = Double.MAX_VALUE;
        FruitStand bestDealStand = null;

        for (FruitStand fruitStand : fruitStands) {
            FruitDeal fruitDeal = fruitStand.matchCriteria(fruitDealCriteria);
            Double dealPrice = fruitDeal.getDealPrice();

            if (minimumTotalPrice.compareTo(dealPrice) > 0) {
                 minimumTotalPrice = dealPrice;
                 bestDealStand = fruitStand;
            }
        }

        SearchResult searchResult = new SearchResult();
        searchResult.setFruitStand(bestDealStand);

        return searchResult;
    }

}
