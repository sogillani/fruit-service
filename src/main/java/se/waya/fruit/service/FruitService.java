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

    FruitServiceDataProvider dataProvider = new FruitServiceDataProvider();

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

        System.out.println("*** Extension 3 ***");
        System.out.println("Stand No: " + searchResult2.getFruitStand().getStandNo());
        System.out.println("Deal Price: " + searchResult2.getFruitDeal().getDealPrice());
        searchResult2.getFruitDeal().getFruitBaskets().forEach(
                fruitBasket -> System.out.println("Fruit Name: " + fruitBasket.getFruitName())
        );
        System.out.println("Selections: " + searchResult2.getSelections());

        System.out.println("*** Extension 4 ***");
        SearchResult searchResult3 = fruitService.searchFruitDeal(fruitDealCriteria2);
        System.out.println("Stand No: " + searchResult3.getFruitStand().getStandNo());
        System.out.println("Deal Price: " + searchResult3.getFruitDeal().getDealPrice());
        searchResult3.getFruitDeal().getFruitBaskets().forEach(
                fruitBasket -> System.out.println("Fruit Name: " + fruitBasket.getFruitName())
        );
        System.out.println("Selections: " + searchResult3.getSelections());
    }

    /**
     * Search for the best fruit deal
     *
     * @param fruitDealCriteria Desired criteria to search best deal available
     * @return Search result with best available deal
     */
    public SearchResult searchFruitDeal(FruitDealCriteria fruitDealCriteria) {

        List<FruitStand> fruitStands = dataProvider.getFruitStandsList();

        Double minimumTotalPrice = Double.MAX_VALUE;
        FruitStand bestDealStand = null;
        FruitDeal bestFruitDeal = null;

        int selections = 0;
        for (FruitStand fruitStand : fruitStands) {
            FruitDeal fruitDeal = fruitStand.matchCriteria(fruitDealCriteria);
            // Consider only fruit stand who have required fruits
            if(fruitDeal == null) {
                continue;
            }

            selections++;

            Double dealPrice = fruitDeal.getDealPrice();

            if (minimumTotalPrice.compareTo(dealPrice) > 0) {
                 minimumTotalPrice = dealPrice;
                 bestDealStand = fruitStand;
                 bestFruitDeal = fruitDeal;
            }
        }
        bestDealStand.setSold(true);
        SearchResult searchResult = new SearchResult();
        searchResult.setFruitStand(bestDealStand);
        searchResult.setFruitDeal(bestFruitDeal);
        searchResult.setSelections(selections);
        return searchResult;
    }

}
