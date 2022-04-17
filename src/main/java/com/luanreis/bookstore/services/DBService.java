package com.luanreis.bookstore.services;

import com.luanreis.bookstore.domain.*;
import com.luanreis.bookstore.domain.enums.Profile;
import com.luanreis.bookstore.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategorieRepository categorieRepository;

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BCryptPasswordEncoder pe;

    public void instatiateDatabase() {

        Categorie cat1 = new Categorie(null, "Fantasia", "Livros de Fantasias / Magias / Sobrenatural");
        Categorie cat2 = new Categorie(null, "Terror", "Livros de Terror / Thriller / Sobrenatural");

        Book book1 = new Book(null, "O Senhor dos Anéis", "J. R. R. Tolkien", "A história narra o conflito contra o mal que se alastra pela Terra-média, através da luta de várias raças - Humanos, Anãos, Elfos, Ents e Hobbits - contra Orques, para evitar que o Anel do Poder volte às mãos de seu criador Sauron, o Senhor Sombrio.", cat1);
        Book book2 = new Book(null, "O Exorcista", "William Peter Blatty", "O livro conta a história de Regan MacNeil, uma garota de 12 anos que é possuída pelo demônio.", cat2);

        cat1.getBooks().addAll(Arrays.asList(book1));
        cat2.getBooks().addAll(Arrays.asList(book2));
        categorieRepository.saveAll(Arrays.asList(cat1, cat2));
        bookRepository.saveAll(Arrays.asList(book1, book2));

        State acre = new State(null,"Acre");
        State alagoas = new State(null,"Alagoas");
        State amapa = new State(null,"Amapá");
        State amazonas = new State(null,"Amazonas");
        State bahia = new State(null,"Bahia");
        State saoPaulo = new State(null,"São Paulo");
        State rioDeJaneiro = new State(null,"Rio de Janeiro");
        stateRepository.saveAll(Arrays.asList(acre,alagoas,amapa,amazonas,bahia,saoPaulo,rioDeJaneiro));

        Customer c1 = new Customer(null,"Luan Reis","luanreis2202@gmail.com",pe.encode("123"));
        c1.getTelephones().addAll(Arrays.asList("13 996735588","13997564216"));
        c1.addProfile(Profile.ADMIN);

        Customer c2 = new Customer(null,"Thalita","thalita@gmail.com",pe.encode("123"));
        c2.getTelephones().addAll(Arrays.asList("13 996332588","13932364216"));
        c2.addProfile(Profile.CUSTOMER);

        Address address1 = new Address(null,"Rua Josefina Bakhita","527","Casa1","Vila Sonia","11722330","Praia Grande",c1);
        c1.getAddresses().add(address1);
        Address address2 = new Address(null,"Rua Israel Rodrigues Cardoso","134","Casa1","Tude Bastos","11722330","Praia Grande",c2);
        c2.getAddresses().add(address2);

        customerRepository.saveAll(Arrays.asList(c1,c2));
        addressRepository.saveAll(Arrays.asList(address1,address2));

    }

}
