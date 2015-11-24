package repository;


import model.Shop;

import java.util.List;

/**
 * Created by ����� on 17.09.2015.
 */
public interface IShopRepository {
    void add(Shop shop);

    List<Shop> shopList();

    Shop findShop(String shopName);

    Shop findShop(int index);

    void updateShop(Shop shop);

    void delete(int id);
}
