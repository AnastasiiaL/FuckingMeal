package repository;

import model.Shop;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ����� on 30.10.2015.
 */
@Repository
public class ShopDbRepository extends AbstractDbRepository implements IShopRepository {

    @Override
    public void add(Shop shop) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO shop (id,name,location) values (?,?,?)");
            ps.setInt(1, getMaxID()+1);
            ps.setString(2, shop.getName());
            ps.setString(3, shop.getLocation());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, ps);
        }
    }

    @Override
    public List<Shop> shopList() {
        List<Shop> result = new ArrayList<>();
        Connection connection = getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM shop ORDER BY name");
            rs = ps.executeQuery();
            while (rs.next()) {
                int index = rs.getInt("id");
                String name = rs.getString("name");
                String location = rs.getString("location");
                result.add(new Shop(index, name, location));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           closeConnection(connection, ps, rs);

        }
        return result;
    }


    public Shop findShop(String shopName) {
        List<Shop> list = shopList();
        for (Shop shop : list) {
            if (shop.getName().equals(shopName)) {
                System.out.println(shop.toString());
                return shop;
            }
        }
        return null;
    }

    @Override
    public Shop findShop(int index) {
        List<Shop> list = shopList();
        for (Shop shop : list) {
            if (shop.getId()==index) {
                return shop;
            }
        }
        return null;
    }

    @Override
    public void updateShop(Shop shop) {
        if (shop.getId()==0){
            add(shop);
        }
        else {
            Connection connection = getConnection();
            PreparedStatement ps = null;
            try {
                ps = connection.prepareStatement("UPDATE shop SET name = ?, location = ? WHERE id = ?");
                ps.setString(1, shop.getName());
                ps.setString(2, shop.getLocation());
                ps.setInt(3, shop.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                closeConnection(connection, ps);
            }
        }
    }


    @Override
    protected String getTableName() {
        return "shop";
    }
}
