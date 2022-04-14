package com.luanreis.bookstore.services;

import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repo;


    public List<Categorie> findAll(){
        return repo.findAll();
    }



}
