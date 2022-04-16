package com.luanreis.bookstore.resources;


import com.luanreis.bookstore.domain.Book;
import com.luanreis.bookstore.dtos.BookDTO;
import com.luanreis.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "categorie" , defaultValue = "0")Integer categorie_id){
        List<Book> list = service.findAll(categorie_id);
        List<BookDTO> listDto = list.stream().map(BookDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> find(@PathVariable Integer id){
       Book obj = service.find(id);
       return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@Valid @RequestBody BookDTO objDto, @PathVariable Integer id ){
        Book obj = service.fromDTO(objDto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestParam(value = "categorie" , defaultValue = "0")Integer categorie_id,@Valid @RequestBody Book obj){
        service.create(categorie_id,obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Book> delete(@PathVariable Integer id){
       service.delete(id);
    return ResponseEntity.noContent().build();
    }

}
