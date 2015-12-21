package service;

import model.Shop;
import model.ShopProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repository.IShopRepository;

import java.util.List;

/**
 * Created by Anastasia on 02.12.2015.
 */
@Service
@Transactional
public class ServiceShop {
    @Qualifier("shopDAOImpl")
    @Autowired
    private IShopRepository shopDAO;

    public void add(Shop shop)  {
      shopDAO.add(shop);
    }

    public List<Shop> list() {
        return shopDAO.list();
    }

    public void delete(int id){
        shopDAO.delete(id);
    }

    public Shop find(int id){
        Shop shop = shopDAO.find(id);
        fetchProducts(shop);
        return shop;
    }

    protected void fetchProducts(Shop shop) {
        for(ShopProduct sp : shop.getProducts()){
            sp.getProduct().getName();
        }
    }

    public void update(Shop entity){
        shopDAO.update(entity);
    }


}

