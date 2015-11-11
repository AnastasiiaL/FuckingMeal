package repository;

import model.Product;
import model.Shop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кроха on 17.09.2015.
 */
public class FileSystemShopRepository implements IShopRepository{

    public static final String PRODUCT_FILE_PATH = "c:\\\\shopList.txt";

    @Override
    public void add(Shop shop) {
        List<Shop> shops = shopList();
        shops.add(shop);
        write(shops);
    }
    private void write(List<Shop> shops) {
        Writer writer = null;
        try {
            writer = new FileWriter(PRODUCT_FILE_PATH);
            for (Shop shop : shops) {
                writer.write(shop.name + ", " + shop.location);

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
    public List<Shop> shopList() {
        List<Shop> result = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(PRODUCT_FILE_PATH));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(", ");
                Shop shop = new Shop(fields[0], fields[1]);
                result.add(shop);
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
    public Shop findShop(String shopName) {
        List<Shop> list = shopList();
        for (Shop ss : list){
            if (ss.name.equals(shopName)){
                System.out.println(ss.toString());
                return ss;
            }
        }
        return null;
    }

    @Override
    public void deleteShop(String shopName) {
        Shop shop = findShop(shopName);
        List<Shop> list = shopList();
        list.remove(shop);
        write(list);
    }
}
