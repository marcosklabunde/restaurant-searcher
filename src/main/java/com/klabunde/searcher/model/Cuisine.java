package com.klabunde.searcher.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Cuisine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public Cuisine() {
    }

    public Cuisine(Long id) {
        this.id = id;
    }

    public Cuisine(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}