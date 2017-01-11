package com.mikeio.controller;

import com.mikeio.model.Heroe;
import com.mikeio.repository.inter.HeroeDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by SISTEMAS03-PC on 06/01/2017.
 */
@RestController
@RequestMapping(path = "heroes/")
public class ControllerHeroes {

    @Inject
    private HeroeDAO heroeDAO;

    @GetMapping(path = "findAll")
    public ResponseEntity<List<Heroe>> findAll() {

        Heroe e = new Heroe();

        List<Heroe> items = heroeDAO.findAllByEstatus(true);
        return new ResponseEntity<List<Heroe>>(items, HttpStatus.OK);
    }


}
