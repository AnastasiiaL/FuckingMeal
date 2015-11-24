package repository;

import model.Product;

import java.util.List;

/**
 * Created by ����� on 14.09.2015.
 */
public interface IProductRepository {
    void add(Product meal);

    List<Product> productList();

    Product findProduct(String productName);

    Product findProduct(int index);

    void delete(int id);
}
