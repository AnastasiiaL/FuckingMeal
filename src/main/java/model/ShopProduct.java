package model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Кроха on 20.11.2015.
 */
@Entity
@Table(name ="shop_product")
public class ShopProduct implements Serializable{
    @Id
    @ManyToOne
    @JoinColumn(name="id_product")
    private Product product;
    @Id
    @ManyToOne
    @JoinColumn(name="id_shop")
    private Shop shop;

    @Column(name="price")
    private double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }
}
