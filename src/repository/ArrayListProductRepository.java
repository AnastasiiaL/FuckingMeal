package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кроха on 14.09.2015.
 */
public class ArrayListProductRepository implements IProductRepository {
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public List<Product> productList() {
        return products;
    }

    @Override
    public Product findMeal(String productName) {
        for (Product ss : products){
            if (ss.name.equals(productName)){
                System.out.println(ss.name.toString());
                return ss;
            }
        }
        return null;
    }

    @Override
    public void deleteMeal(String productName) {
        Product product = findMeal(productName);
        products.remove(product);
    }
}
