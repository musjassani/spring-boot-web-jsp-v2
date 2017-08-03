package com.proto.dao.impl;

import com.proto.dao.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDaoImpl<E> implements AbstractDao<E> {

    private final Logger logger = LoggerFactory.getLogger(AbstractDaoImpl.class);


    private Class<E> persistentClass;

    //@Autowired
    //public SessionFactory sessionFactory;

    @Autowired
    EntityManager entityManager;

    public AbstractDaoImpl() {
        this.persistentClass = (Class<E>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public void save(E e) {
        //@Transactional de spring gère l'ouverture de la session: ne pas utilisé sessionFactory.openSession() car c'est dejà fait par spring
        // mais plutot sessionFactory.getCurrentSession(). Ne pas fermer la session non plus: spring s'en charge grace à @Transactional
        //https://stackoverflow.com/questions/15300483/some-clarification-about-spring-transactional-annotation-on-a-method
        //Session session = sessionFactory.getCurrentSession();
        Session session = entityManager.unwrap(Session.class);
        session.save(e);
    }

    @Override
    public void update(E e) {
        //@Transactional de spring gère l'ouverture de la session: ne pas utilisé sessionFactory.openSession() car c'est dejà fait par spring
        // mais plutot sessionFactory.getCurrentSession(). Ne pas fermer la session non plus: spring s'en charge grace à @Transactional
        //https://stackoverflow.com/questions/15300483/some-clarification-about-spring-transactional-annotation-on-a-method
        //Session session = sessionFactory.getCurrentSession();
        Session session = entityManager.unwrap(Session.class);
        session.update(e);
    }

    @Override
    public void delete(E e) {
        //@Transactional de spring gère l'ouverture de la session: ne pas utilisé sessionFactory.openSession() car c'est dejà fait par spring
        // mais plutot sessionFactory.getCurrentSession(). Ne pas fermer la session non plus: spring s'en charge grace à @Transactional
        //https://stackoverflow.com/questions/15300483/some-clarification-about-spring-transactional-annotation-on-a-method
        //Session session = sessionFactory.getCurrentSession();
        Session session = entityManager.unwrap(Session.class);
        session.delete(e);
    }

    @Override
    public List<E> list() {
        //@Transactional de spring gère l'ouverture de la session: ne pas utilisé sessionFactory.openSession() car c'est dejà fait par spring
        // mais plutot sessionFactory.getCurrentSession(). Ne pas fermer la session non plus: spring s'en charge grace à @Transactional
        //https://stackoverflow.com/questions/15300483/some-clarification-about-spring-transactional-annotation-on-a-method
        /*Session session = sessionFactory.getCurrentSession();*/
        Session session = entityManager.unwrap(Session.class);
        Criteria criteria = session.createCriteria(persistentClass);
        List<E> list = criteria.list();
        return list;
    }

    @Override
    public E getById(Serializable id) {
        //@Transactional de spring gère l'ouverture de la session: ne pas utilisé sessionFactory.openSession() car c'est dejà fait par spring
        // mais plutot sessionFactory.getCurrentSession(). Ne pas fermer la session non plus: spring s'en charge grace à @Transactional
        //https://stackoverflow.com/questions/15300483/some-clarification-about-spring-transactional-annotation-on-a-method
        /*Session session = sessionFactory.getCurrentSession();*/
        Session session = entityManager.unwrap(Session.class);
        E e = session.get(persistentClass, id);
        return e;
    }
}
