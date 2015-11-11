package repository;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кроха on 15.09.2015.
 */
public class FileSystemProductRepository implements IProductRepository {

    public static final String PRODUCT_FILE_PATH = "c:\\\\productList.txt";
    public static final String SEPARATOR = ",";

    @Override
    public void add(Product product) {
        List<Product> products = productList();
        products.add(product);
        write(products);
    }

    private void write(List<Product> products) {
        Writer writer = null;
        try {
            writer = new FileWriter(PRODUCT_FILE_PATH);
            for (Product product1 : products) {
                writer.write(product1.name + SEPARATOR + product1.brand + SEPARATOR + product1.amount + SEPARATOR + product1.price);

                writer.write(System.lineSeparator());
            }
            writer.flush();
        } catch (Exception e) {
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }
    }

    @Override
    public List<Product> productList() {
        List<Product> result = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(PRODUCT_FILE_PATH));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(SEPARATOR);
            }
        } catch (Exception e) {

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @Override
    public Product findMeal(String productName) {
        List<Product> list = productList();
        for (Product ss : list){
            if (ss.name.equals(productName)){
                System.out.println(ss.toString());
                return ss;
            }
        }
        return null;
    }

    @Override
    public void deleteMeal(String productName) {
        Product product = findMeal(productName);
        List<Product> list = productList();
        list.remove(product);
        write(list);
    }
}
