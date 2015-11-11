package repository;


import model.Shop;

import java.util.List;

/**
 * Created by Кроха on 17.09.2015.
 */
public interface IShopRepository {
    void add(Shop shop);

    List<Shop> shopList();

    Shop findShop(String shopName);

    void deleteShop(String productName);
}
