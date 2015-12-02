package repository;

import model.Identifiable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Anastasia on 01.12.2015.
 */
public abstract class AbstractDAO<T extends Identifiable> {
    @Autowired
    protected SessionFactory sessionFactory;

    public void add(T obj)  {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public List<T> list()  {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return session.createCriteria(getaClass()).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return Collections.EMPTY_LIST;
    }

    public void delete(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            T result = (T) session.get(getaClass(), id);
            if (result!=null){
                session.delete(result);
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

    public T find(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return (T) session.get(getaClass(), id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    public void update(T entity) {
        if (entity.getId()==0){
            add(entity);
        }
        Session session = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.update(getEntityName(), entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    protected abstract String getEntityName();

    protected abstract Class<T> getaClass();

}
