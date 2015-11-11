package repository;

import model.Shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кроха on 30.10.2015.
 */
public class ShopDbRepository extends AbstractDbRepository implements IShopRepository {
    private AbstractDbRepository db = new AbstractDbRepository();
    private static int index = 1;

    @Override
    public void add(Shop shop) {
        Connection connection = db.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO shop (id,name,location) values (?,?,?)");
            ps.setInt(1, index++);
            ps.setString(2, shop.name);
            ps.setString(3, shop.location);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps!=null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            }
        }

    @Override
    public List<Shop> shopList() {
        List<Shop> result = new ArrayList<>();
        Connection connection = db.getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        int index = 1;
        try {
            ps = connection.prepareStatement("SELECT * FROM shop ORDER BY name");
            rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                String location = rs.getString("location");
                result.add(new Shop(name, location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps!=null) ps.close();
                if (rs!=null) rs.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    @Override
    public Shop findShop(String shopName) {
        List<Shop> list = shopList();
        for (Shop shop : list){
            if (shop.name.equals(shopName)){
                System.out.println(shop.toString());
                return shop;
            }
        }
        return null;
    }

    @Override
    public void deleteShop(String shopName) {
        Connection connection = db.getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("DELETE FROM shop WHERE name = ?");
            ps.setString(1, shopName);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps!=null) ps.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
