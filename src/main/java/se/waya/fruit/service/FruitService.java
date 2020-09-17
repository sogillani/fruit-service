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

        System.out.println("*** Base Scenario ***");
        FruitDealCriteria fruitDealCriteria = new FruitDealCriteria();

        fruitDealCriteria.getDesiredFruits().add(Fruits.CHERRY);
        fruitDealCriteria.getDesiredFruits().add(Fruits.PEACH);

        SearchResult searchResult = fruitService.searchFruitDeal(fruitDealCriteria);
        System.out.println("Stand No: " + searchResult.getFruitStand().getStandNo());

        System.out.println("*** Extension 1 ***");
        FruitDealCriteria fruitDealCriteria2 = new FruitDealCriteria();

        fruitDealCriteria2.getDesiredFruits().add(Fruits.PEAR);

        fruitDealCriteria2.getChoiceFruits().add(Fruits.CHERRY);
        fruitDealCriteria2.getChoiceFruits().add(Fruits.PEACH);
        SearchResult searchResult2 = fruitService.searchFruitDeal(fruitDealCriteria2);
        System.out.println("Stand No: " + searchResult2.getFruitStand().getStandNo());
        System.out.println("Deal Price: " + searchResult2.getFruitDeal().getDealPrice());

        System.out.println("*** Extension 2 ***");
        System.out.println("Stand No: " + searchResult2.getFruitStand().getStandNo());
        System.out.println("Deal Price: " + searchResult2.getFruitDeal().getDealPrice());
        searchResult2.getFruitDeal().getFruitBaskets().forEach(
                fruitBasket -> System.out.println("Fruit Name: " + fruitBasket.getFruitName())
        );
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
        FruitDeal bestFruitDeal = null;

        for (FruitStand fruitStand : fruitStands) {
            FruitDeal fruitDeal = fruitStand.matchCriteria(fruitDealCriteria);
            Double dealPrice = fruitDeal.getDealPrice();

            if (minimumTotalPrice.compareTo(dealPrice) > 0) {
                 minimumTotalPrice = dealPrice;
                 bestDealStand = fruitStand;
                 bestFruitDeal = fruitDeal;
            }
        }

        SearchResult searchResult = new SearchResult();
        searchResult.setFruitStand(bestDealStand);
        searchResult.setFruitDeal(bestFruitDeal);

        return searchResult;
    }

}
