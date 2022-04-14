package com.luanreis.bookstore.resources;


import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategorieResource {

    @Autowired
    private CategorieService service;

    @GetMapping
    public ResponseEntity<List<Categorie>> findAll(){
        List<Categorie> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<Categorie> find(@PathVariable Integer id){
       Categorie obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
