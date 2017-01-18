package com.mikeio.controller;

import com.mikeio.model.Heroe;
import com.mikeio.repository.inter.HeroeDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SISTEMAS03-PC on 06/01/2017.
 */
@RestController
@RequestMapping(path = "heroes/")
public class ControllerHeroes {

    @Inject
    private HeroeDAO heroeDAO;

//    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = "findAll")
    public ResponseEntity<?> findAll() {

        Map map = new HashMap<String , Object>();


        List<Heroe> items = heroeDAO.findAllByEstatus(true);

        map.put("data", items);

        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }


}
