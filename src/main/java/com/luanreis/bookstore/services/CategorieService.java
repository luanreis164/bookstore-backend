package com.luanreis.bookstore.services;

import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.dtos.CategorieDTO;
import com.luanreis.bookstore.repository.CategorieRepository;
import com.luanreis.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository repo;


    public List<Categorie> findAll(){
        return repo.findAll();
    }

    public Categorie find(Integer id){
        Optional<Categorie> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!" + id + ",Tipo: " + Categorie.class.getName()));
    }

    public Categorie create(Categorie obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Categorie update(Categorie obj){
        Categorie newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }


    public Categorie fromDTO(CategorieDTO objDto) {
        return new Categorie(objDto.getId(), objDto.getName(), objDto.getDescription());
    }

    private void updateData(Categorie newObj, Categorie obj){
        newObj.setName(obj.getName());
    }

}
