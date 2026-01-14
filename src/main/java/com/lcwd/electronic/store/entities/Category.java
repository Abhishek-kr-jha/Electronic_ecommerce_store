package com.lcwd.electronic.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

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


}
