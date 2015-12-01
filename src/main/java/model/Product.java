package model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Anastasia on 13.09.2015.
 */
@Entity
@Table(name ="product")
public class Product {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name="brand")
    private String brand;
    @Column(name="product_name")
    private String name;
    @Column(name="amount")
    private double amount;
    @Column(name="amount_type")
    private String amount_type;
    @OneToMany(mappedBy="product", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ShopProduct> shops;

    public Product() {
    }

    public Product(int index, String brand, String name, double amount, String amount_type) {
        this.id = index;
        this.name = name;
        this.brand = brand;
        this.amount = amount;
        this.amount_type = amount_type;
    }

    public Product(String brand, String name, double amount, String amount_type) {
        this(-1, brand, name, amount, amount_type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return (this.brand + ", " + this.name + ", " + this.amount + ", " + this.amount_type);
    }
}
