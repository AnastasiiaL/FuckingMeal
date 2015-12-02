package repository;

import model.Product;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anastasia on 10.11.2015.
 */
@Repository
public class ProductDbRepository extends AbstractDbRepository implements IProductRepository {
    @Override
    public void add(Product product) {
        Connection connection = getConnection();
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("INSERT INTO product (id, brand, product_name, amount, amount_type) values (?,?,?,?,?)");
            ps.setInt(1, getMaxID()+1);
            ps.setString(2, product.getBrand());
            ps.setString(3, product.getName());
            ps.setDouble(4, product.getAmount());
            ps.setString(5, product.getAmount_type());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, ps);
        }
    }

    @Override
    public List<Product> list() {
        List<Product> result = new ArrayList<>();
        Connection connection = getConnection();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM product ORDER BY name");
            rs = ps.executeQuery();
            while (rs.next()) {
                String brand = rs.getString("brand");
                String name = rs.getString("product_name");
                Double amount = rs.getDouble("amount");
                String amount_type = rs.getString("amount_type");
                result.add(new Product(brand, name, amount, amount_type));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection(connection, ps, rs);
        }
        return result;
    }

    public Product find(String productName) {
        List<Product> list = list();
        for (Product product : list) {
            if (product.getName().equals(productName)) {
                System.out.println(product.toString());
                return product;
            }
        }
        return null;
    }

    @Override
    public Product find(int index) {
        List<Product> list = list();
        for (Product product : list) {
            if (product.getId()==index) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    protected String getTableName() {
        return "product";
    }
}
