package com.luanreis.bookstore.repository;

import com.luanreis.bookstore.domain.Categorie;
import com.luanreis.bookstore.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
