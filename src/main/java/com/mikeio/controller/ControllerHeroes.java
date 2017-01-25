package com.mikeio.controller;

import com.mikeio.model.Heroe;
import com.mikeio.repository.inter.HeroeDAO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Miguel Solis on 06/01/2017.
 */
@RestController
@RequestMapping(path = "heroes")
public class ControllerHeroes {

    @Inject
    private HeroeDAO heroeDAO;

    //    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(path = {"/"})
    public ResponseEntity<?> findAll() {
        List<Heroe> items = heroeDAO.findAllByEstatus(true);
        return mappingToResp(items);
    }

    @GetMapping(path = {"/"}, params = {"name"})
    public ResponseEntity<?> search(@RequestParam(value = "name") String name) {

        List<Heroe> items = heroeDAO.findAllByName(name);
        return mappingToResp(items);
    }

    @PostMapping(path = "/" )
    public ResponseEntity<?> createHero(@RequestBody Heroe item) {
        item.setEstatus(true);
        item.setSuperPower("");
        heroeDAO.create(item);
        return mappingToResp(item);
    }

    @GetMapping(path = "/{idHero}")
    public ResponseEntity<?> getHero(@PathVariable(name = "idHero") Integer id) {
        Heroe heroe = heroeDAO.findById(id);
        return mappingToResp(heroe);
    }

    @DeleteMapping(path = "/{idHero}")
    public ResponseEntity<?> deleteHero(@PathVariable(name = "idHero") Integer id) {
        int rows = heroeDAO.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping(path = "/{idHero}")
    public ResponseEntity<Void> updateHero(@RequestBody Heroe item) {
        int rows = heroeDAO.update(item);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    private ResponseEntity<?> mappingToResp (Object val){
        Map map = new HashMap<String, Object>();
        map.put("data", val);
        return new ResponseEntity<Object>(map, HttpStatus.OK);
    }



}
