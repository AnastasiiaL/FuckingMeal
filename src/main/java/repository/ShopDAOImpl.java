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
public class ShopDAOImpl implements IShopRepository {
    @Autowired
        private SessionFactory sessionFactory;
    @Override
    public void add(Shop shop)  {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(shop);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public List<Shop> shopList()  {
        Session session = null;
        List<Shop> shops = new ArrayList<Shop>();
        try {
            session = sessionFactory.openSession();
            shops = session.createCriteria(Shop.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return shops;
    }

    @Override
    public Shop findShop(int id) {
        Session session = null;
        Shop shop = null;
        try {
            session = sessionFactory.openSession();
            shop = (Shop) session.get(Shop.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return shop;
    }

    @Override
    public void updateShop(Shop shop) {
        if (shop.getId()==0){
            add(shop);
        }
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update("Shop", shop);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Shop shop = null;
        try {
            session = sessionFactory.openSession();
            shop = (Shop) session.get(Shop.class, id);
            if (shop!=null){
                session.delete(shop);
                session.flush();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
