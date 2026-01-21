package com.lcwd.electronic.store.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @Column(name = "id")
    private  String categoryId;
    @Column(name ="category_title",length = 100)
    private  String title;
    @Column(name="category_desc", length =50)
    private  String description;
    private  String coverImage;

    //mapping with product
    @OneToMany(mappedBy =  "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products = new ArrayList<>();



}
