package model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;
import java.util.Set;

/**
 * Created by Anastasia on 17.09.2015.
 */
@Entity
@Table(name ="shop")
public class Shop  {
    @Id
    @GeneratedValue(generator="increment")
    @GenericGenerator(name="increment", strategy = "increment")
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="location")
    private String location;

    @OneToMany(mappedBy="shop", cascade=CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private Set<ShopProduct> products;

    public Shop() {}

    public Shop(int index, String name, String location){
        this.id = index;
        this.name = name;
        this.location = location;
    }
    public Shop(String name, String location) {
       this(-1, name, location);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<ShopProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<ShopProduct> products) {
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
