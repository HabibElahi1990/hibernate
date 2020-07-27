package config;

import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.SQLException;

public class HabibEntityMapping {

    SessionFactory sessionFactory = getSessionFactory();

    public SessionFactory getSessionFactory() {
        Configuration config = new Configuration().configure("hibernate.cfg.xml");
//        config.addAnnotatedClass(HabibCache.class);
        config.addAnnotatedClass(HabibTest.class);
//        config.addAnnotatedClass(HabibEmbeddableTest.class);
//        config.addAnnotatedClass(HabibColl.class);
//        config.addAnnotatedClass(HabibPerson.class);
//        config.addAnnotatedClass(HabibStudent.class);
//        config.addAnnotatedClass(HabibCourse.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
                .build();
        return config.buildSessionFactory(serviceRegistry);
    }

    public Object saveObject(Object obj)  {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.getTransaction();
        tx.begin();
        session.save(obj);
        tx.commit();
        return obj;
    }
}
