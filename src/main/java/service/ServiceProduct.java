package service;

import model.Product;
import model.ShopProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.IProductRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Anastasia on 02.12.2015.
 */
@Service
@Transactional
public class ServiceProduct {
    @Resource(name="productDAOImpl")
    private IProductRepository productDAO;

    public void add(Product product)  {
        productDAO.add(product);
    }

    public List<Product> list() {
        return productDAO.list();
    }

    public void delete(int id){
        productDAO.delete(id);
    }

    public Product find(int id){
        Product product = productDAO.find(id);
        fetchShops(product);
        return product;
    }

    private void fetchShops(Product product) {
        for(ShopProduct sp : product.getShops()){
            sp.getProduct().getName();
        }
    }

    public void update(Product entity){
        productDAO.update(entity);
    }

}
