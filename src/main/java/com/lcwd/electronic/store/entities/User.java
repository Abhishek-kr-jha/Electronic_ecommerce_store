package com.lcwd.electronic.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="users")
public class User  {
    @Id
    private  String userId;

    @Column(name = "users_name")
    private  String name;

    @Column(name = "users_email", unique = true)
    private  String email;

    @Column(name = "users_password", length = 500)
    private  String password;
    private  String gender;

    @Column(length = 1000)
    private String about;

    @Column(name = "users_image_name")
    private String imageName;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();



}
