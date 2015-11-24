package model;

import java.util.List;

/**
 * Created by ����� on 17.09.2015.
 */
public class Shop extends Identifier {
    public String name;
    public String location;
    private List<ShopProduct> products;

    public Shop() {}

    public Shop(int index, String name, String location){
        this.id = index;
        this.name = name;
        this.location = location;
    }

    public Shop(String name, String location) {
       this(-1, name, location);
    }

    public List<ShopProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ShopProduct> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override public String toString(){

        return (this.name + " " + this.location);
    }
}
