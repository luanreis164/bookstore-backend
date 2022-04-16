package com.luanreis.bookstore.services;

import com.luanreis.bookstore.domain.Book;
import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.dtos.BookDTO;
import com.luanreis.bookstore.dtos.CategorieDTO;
import com.luanreis.bookstore.repository.BookRepository;
import com.luanreis.bookstore.services.exceptions.DataIntegrityViolationException;
import com.luanreis.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    @Autowired
    private CategorieService categorieService;

    public List<Book> findAll(Integer categorie_id){
        categorieService.find(categorie_id);
        return repo.findByCategorie(categorie_id);
    }

    public Book find(Integer id){
        Optional<Book> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Livro não encontrado!" + id + ",Tipo: " + Book.class.getName()));
    }

    public Book create(Integer categorieId,Book obj){
        obj.setId(null);
        Categorie cat = categorieService.find(categorieId);
        obj.setCategorie(cat);
        return repo.save(obj);
    }
    public Book update(Book obj){
        Book newObj = find(obj.getId());
        updateData(obj,newObj);
        return repo.save(newObj);
    }
    public void delete(Integer id){
        find(id);
        try{repo.deleteById(id);
            }
            catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Categoria não pode ser deletada! Possui livros associados!");
        }
    }

    private void updateData(Book obj, Book newObj){
        newObj.setTitle(obj.getTitle());
        newObj.setDescription(obj.getDescription());

    }

    public Book fromDTO(BookDTO objDto){
        return new Book(objDto.getId(), objDto.getTitle(),null,objDto.getDescription(),null);
    }



}
