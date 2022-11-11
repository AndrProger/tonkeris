package com.java.tonkeris.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class TypeTransportDir {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private String name;

    public TypeTransportDir(String name) {
        this.name = name;
    }

    public TypeTransportDir() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
