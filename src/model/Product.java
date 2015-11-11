package model;

/**
 * Created by Кроха on 13.09.2015.
 */
public class Product {
    public String brand;
    public String name;
    public float amount;
    public String amount_type;
    public float price;
    public Shop shop;

    public Product(String brand, String name, float amount, String amount_type, float price, Shop shop){
        this.name = name;
        this.brand = brand;
        this.amount = amount;
        this.amount_type = amount_type;
        this.price = price;
        this.shop = shop;
    }
    @Override public String toString(){
        return (this.name + ", " + this.brand + ", " + this.amount + ", " + this.price);
    }
}
