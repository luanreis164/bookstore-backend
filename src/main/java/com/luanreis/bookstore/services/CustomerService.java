package com.luanreis.bookstore.services;

import com.luanreis.bookstore.domain.Customer;
import com.luanreis.bookstore.dtos.CustomerDTO;
import com.luanreis.bookstore.repository.CustomerRepository;
import com.luanreis.bookstore.services.exceptions.DataIntegrityViolationException;
import com.luanreis.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repo;


    public List<Customer> findAll(){
        return repo.findAll();
    }

    public Customer find(Integer id){
        Optional<Customer> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado!" + id + ",Tipo: " + Customer.class.getName()));
    }

    public Customer create(Customer obj){
        obj.setId(null);
        return repo.save(obj);
    }

    public Customer update(Customer obj){
        Customer newObj = find(obj.getId());
        updateData(newObj,obj);
        return repo.save(newObj);
    }

    public void delete(Integer id){
        find(id);
        try{repo.deleteById(id);
            }
            catch (DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Usuario não pode ser deletado!");
        }
    }


    public Customer fromDTO(CustomerDTO objDto) {
        return new Customer(objDto.getId(), objDto.getName(), objDto.getEmail(),objDto.getPassword());
    }

    private void updateData(Customer newObj, Customer obj){
        newObj.setName(obj.getName());
    }



}
