package com.luanreis.bookstore.services;

import com.luanreis.bookstore.domain.Book;
import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.repository.BookRepository;
import com.luanreis.bookstore.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private BookRepository bookRepository;

    public void instatiateDatabase() {

        Categorie cat1 = new Categorie(null, "Fantasia", "Livros de Fantasias / Magias / Sobrenatural");
        Categorie cat2 = new Categorie(null, "Terror", "Livros de Terror / Thriller / Sobrenatural");

        Book book1 = new Book(null, "O Senhor dos Anéis", "J. R. R. Tolkien", "A história narra o conflito contra o mal que se alastra pela Terra-média, através da luta de várias raças - Humanos, Anãos, Elfos, Ents e Hobbits - contra Orques, para evitar que o Anel do Poder volte às mãos de seu criador Sauron, o Senhor Sombrio.", cat1);
        Book book2 = new Book(null, "O Exorcista", "William Peter Blatty", "O livro conta a história de Regan MacNeil, uma garota de 12 anos que é possuída pelo demônio.", cat2);

        cat1.getBooks().addAll(Arrays.asList(book1));
        cat2.getBooks().addAll(Arrays.asList(book2));
        categorieRepository.saveAll(Arrays.asList(cat1, cat2));
        bookRepository.saveAll(Arrays.asList(book1, book2));
    }

}
