package com.luanreis.bookstore.dtos;

import com.luanreis.bookstore.domain.Categorie;

import java.io.Serializable;

public class CategorieDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;

    public CategorieDTO() {
    }

    public CategorieDTO(Categorie obj) {
        id = obj.getId();
        name = obj.getName();
        description = obj.getDescription();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
