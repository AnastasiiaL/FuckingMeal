package model;

import java.util.List;

/**
 * Created by ����� on 13.09.2015.
 */
public class Product extends Identifier {
    private String brand;
    private String name;
    private double amount;
    private String amount_type;
    private List<ShopProduct> shops;

    public Product() {
    }

    public Product(int index, String brand, String name, double amount, String amount_type){
       this.id = index;
        this.name = name;
        this.brand = brand;
        this.amount = amount;
        this.amount_type = amount_type;
    }

    public Product(String brand, String name, double amount, String amount_type){
        this(-1, brand, name, amount, amount_type);
    }

    public List<ShopProduct> getShops() {
        return shops;
    }

    public void setShops(List<ShopProduct> shops) {
        this.shops = shops;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAmount_type() {
        return amount_type;
    }

    public void setAmount_type(String amount_type) {
        this.amount_type = amount_type;
    }

    @Override public String toString(){
        return (this.brand + ", " + this.name + ", " + this.amount + ", " + this.amount_type);
    }
}
