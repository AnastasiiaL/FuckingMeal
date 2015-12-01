package repository;


import model.Shop;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by ����� on 17.09.2015.
 */
public interface IShopRepository {
    void add(Shop shop);

    List<Shop> shopList();

    Shop findShop(int index);

    void updateShop(Shop shop);

    void delete(int id);
}
