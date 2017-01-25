package com.mikeio.repository.inter;

import com.mikeio.model.Heroe;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SISTEMAS03-PC on 06/01/2017.
 */
@Transactional(readOnly = true)
public interface HeroeDAO {

    @Transactional
    Integer create(Heroe item);

    List<Heroe> findAllByEstatus(boolean estatus);

    List<Heroe> findAllByName(String name);

    Heroe findById(int id);

    @Transactional
    int delete(int id);

    @Transactional
    int update(Heroe item);
}
