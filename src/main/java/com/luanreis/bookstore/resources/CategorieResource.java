package com.luanreis.bookstore.resources;


import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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


}
