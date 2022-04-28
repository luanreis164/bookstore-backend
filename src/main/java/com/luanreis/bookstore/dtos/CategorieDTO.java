package com.luanreis.bookstore.dtos;

import com.luanreis.bookstore.domain.Categorie;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class CategorieDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private String name;

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(min = 3,max = 333,message = "Tamanho entre 3 e 333 caracteres!")
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
