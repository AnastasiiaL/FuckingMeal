package repository;

import model.Product;

import java.util.List;

/**
 * Created by Кроха on 14.09.2015.
 */
public interface IProductRepository {
    void add(Product meal);

    List<Product> productList();

    Product findMeal(String productName);

    void deleteMeal(String productName);
}
