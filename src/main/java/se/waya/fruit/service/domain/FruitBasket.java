package se.waya.fruit.service.domain;

public class FruitBasket {

    private String fruitName;
    private Double price;

    public FruitBasket(String fruitName, Double price) {
        this.fruitName = fruitName;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFruitName() {
        return fruitName;
    }
}
