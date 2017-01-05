package com.mikeio.repository;

import com.mikeio.model.Heroe;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.transaction.Transactional;

/**
 * Created by SISTEMAS03-PC on 04/01/2017.
 */
@Repository
@Transactional(readOnly = true)
public class HeroeDAO {


    @Inject
    private SessionFactory sessionFactory;

    @Transactional
    public Integer create(Heroe item) {
        Hibernate.initialize(item);
        return (Integer) sessionFactory.getCurrentSession().save(item);

    }
}
