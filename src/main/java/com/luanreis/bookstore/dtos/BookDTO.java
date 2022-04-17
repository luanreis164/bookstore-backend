package com.luanreis.bookstore.dtos;

import com.luanreis.bookstore.domain.Book;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private String title;

    @NotEmpty(message = "Preenchimento obrigatório!")
    private String description;

    public BookDTO() {
    }

    public BookDTO(Book obj) {
        id = obj.getId();
        title = obj.getTitle();
        description = obj.getDescription();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
