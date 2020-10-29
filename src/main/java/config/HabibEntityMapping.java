package config;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;

public class HabibEntityMapping {

    private SessionFactory sessionFactory = getSessionFactory();

    private SessionFactory getSessionFactory() {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
        config.addAnnotatedClass(HabibCache.class);
        config.addAnnotatedClass(HabibTest.class);
        config.addAnnotatedClass(HabibEmbeddableTest.class);
        config.addAnnotatedClass(HabibColl.class);
        config.addAnnotatedClass(HabibPerson.class);
        config.addAnnotatedClass(HabibStudent.class);
        config.addAnnotatedClass(HabibCourse.class);
        config.addAnnotatedClass(Employee.class);
        config.addAnnotatedClass(Executive.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
                .build();
        return config.buildSessionFactory(serviceRegistry);
    }

    public void saveObject(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        session.save(obj);
        tx.commit();
    }

    public Object getObjectWithId(Object entity, Object id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Object obj = session.get(entity.getClass().getName(), (Serializable) id);
        session.close();
        return obj;
    }

    public List getObjectList(Object entity) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List list = session.createQuery("from " + entity.getClass().getName()).setFirstResult(0)
                .setMaxResults(10).list();
        session.close();
        return list;
    }

    public CriteriaQuery getCriteria(Object obj) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        return builder.createQuery(obj.getClass());

    }
}
