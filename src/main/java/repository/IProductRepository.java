package repository;

import model.Product;

import java.util.List;

/**
 * Created by ����� on 14.09.2015.
 */
public interface IProductRepository extends IAbstractRepository<Product>{
    Product find(String productName);
}
