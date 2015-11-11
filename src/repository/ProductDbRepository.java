package repository;

import model.Product;

import java.util.List;

/**
 * Created by Кроха on 10.11.2015.
 */
public class ProductDbRepository implements IProductRepository {
    @Override
    public void add(Product meal) {

    }

    @Override
    public List<Product> productList() {
        return null;
    }

    @Override
    public Product findMeal(String productName) {
        return null;
    }

    @Override
    public void deleteMeal(String productName) {

    }
}
