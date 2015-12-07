package repository;

import model.Identifiable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

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

    public void add(T obj) {
        sessionFactory.getCurrentSession().save(obj);
    }

    public List<T> list() {
        return sessionFactory.getCurrentSession().createCriteria(getaClass()).list();
    }

    public void delete(int id) {
        T result = (T) sessionFactory.getCurrentSession().get(getaClass(), id);
        if (result != null) {
            sessionFactory.getCurrentSession().delete(result);
            sessionFactory.getCurrentSession().flush();
        }
    }

    public T find(int id) {
        return (T) sessionFactory.getCurrentSession().get(getaClass(), id);
    }

    public void update(T entity) {
        if (entity.getId() == 0) {
            add(entity);
        } else {
            sessionFactory.getCurrentSession().update(getEntityName(), entity);
        }
    }

    protected abstract String getEntityName();

    protected abstract Class<T> getaClass();

}
