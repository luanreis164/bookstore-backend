package com.luanreis.bookstore.resources;


import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.dtos.CategorieDTO;
import com.luanreis.bookstore.services.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/categories")
public class CategorieResource {

    @Autowired
    private CategorieService service;

    @GetMapping
    public ResponseEntity<List<CategorieDTO>> findAll(){
        List<Categorie> list = service.findAll();
        List<CategorieDTO> listDto = list.stream().map(CategorieDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

   @GetMapping(value = "/{id}")
    public ResponseEntity<Categorie> find(@PathVariable Integer id){
       Categorie obj = service.find(id);
       return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<CategorieDTO> create(@Valid @RequestBody CategorieDTO objDto){
        Categorie obj = service.fromDTO(objDto);
        obj = service.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody CategorieDTO objDto){
        Categorie obj = service.fromDTO(objDto);
        obj.setId(id);
        obj = service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
       service.delete(id);
    return ResponseEntity.noContent().build();
    }

}
