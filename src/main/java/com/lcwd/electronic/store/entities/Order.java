package com.lcwd.electronic.store.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Order {
    @Id
    private  String orderId;

    //Pending , Delivered , Dispatched
    //ENUM
    private  String orderStatus;
    //Payment Status : Paid , Unpaid
    private  String paymentStatus;
    private  int oderAmount;
    @Column(length = 1000)
    private  String billingAddress;

    private String billingPhone;

    private  String billingName;

    private Date orderDate;

    private  Date deliveredDate;

    //user
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();






}
