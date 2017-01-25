package com.mikeio.repository;

import com.mikeio.model.Heroe;
import com.mikeio.repository.inter.HeroeDAO;
import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by SISTEMAS03-PC on 04/01/2017.
 */
@SuppressWarnings("JpaQlInspection")
@Repository
public class HeroeImplDAO implements HeroeDAO {


    @Inject
    private SessionFactory sf;

    /**
     * add un nuevo heroe
     *
     * @param item
     * @return
     */
    @Override
    public Integer create(Heroe item) {
        Hibernate.initialize(item);
        return (Integer) sf.getCurrentSession().save(item);
    }

    /**
     * obtener toda la lista de heroes  por estatus
     *
     * @param estatus
     * @return
     */
    @Override
    public List<Heroe> findAllByEstatus(boolean estatus) {

        return sf.getCurrentSession()
                .createQuery("from Heroe where estatus = :estatus")
                .setParameter("estatus", estatus)
                .list();
    }

    /**
     * obtener toda la lista de heroes  por estatus
     *
     * @param name
     * @return
     */
    @Override
    public List<Heroe> findAllByName(String name) {

        return sf.getCurrentSession()
                .createQuery("from Heroe where name like (:name)")
                .setParameter("name", "%"+name+"%")
                .list();
    }


    @Override
    public Heroe findById(int id) {

        return (Heroe) sf.getCurrentSession()
                .createQuery("from Heroe where idHero = :id")
                .setParameter("id", id)
                .getSingleResult();
    }


    @Override
    public int delete(int id) {
        return sf.getCurrentSession()
                .createQuery("delete from Heroe where idHero = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public int update(Heroe item) {
        return sf.getCurrentSession()
                .createQuery("update from Heroe set name =:name where idHero = :id")
                .setParameter("id", item.getIdHero())
                .setParameter("name", item.getName())
                .executeUpdate();
    }


}
