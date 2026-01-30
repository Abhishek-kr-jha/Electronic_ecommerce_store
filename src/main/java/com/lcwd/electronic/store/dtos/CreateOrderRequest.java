package com.lcwd.electronic.store.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CreateOrderRequest {
    @NotBlank(message = "Cartid id is required !!")
    private  String cartId;
    @NotBlank(message = "userId id is required !!")
    private  String userId;


    private  String orderStatus="Pending";

    private  String paymentStatus="NotPaid";

    @NotBlank(message = "Address is required !!")
    private  String billingAddress;

    @NotBlank(message = "Phone number is required !!")
    private String billingPhone;

    @NotBlank(message = "Billing name  is required !!")
    private  String billingName;



}
