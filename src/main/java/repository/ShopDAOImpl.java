package repository;

import model.Shop;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Кроха on 27.11.2015.
 */
@Repository
public class ShopDAOImpl extends AbstractDAO<Shop> implements IShopRepository {

    @Override
    protected String getEntityName() {
        return "Shop";
    }

    @Override
    protected Class<Shop> getaClass() {
        return Shop.class;
    }
}
