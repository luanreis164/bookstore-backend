package com.luanreis.bookstore.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.luanreis.bookstore.domain.Customer;

import javax.validation.constraints.NotEmpty;

public class CustomerDTO {

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private String email;

    @JsonIgnore
    private String password;

    public CustomerDTO() {
    }
    public CustomerDTO(Customer obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
        password = obj.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
