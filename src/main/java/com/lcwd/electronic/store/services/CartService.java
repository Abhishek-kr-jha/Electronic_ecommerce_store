package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.AddItemToCartRequest;
import com.lcwd.electronic.store.dtos.CartDto;

public interface CartService {
    // add items to cart
    // for the user is not available : we will create the cart and add items to cart
    //case2: cart available for the user : add items to cart

    CartDto addItemToCart(String userId, AddItemToCartRequest request);

    //remove item from cart
    void removeItemFromCart(String userId, int cartItem);


    //clear cart
    void clearCart(String userId);

    CartDto getCartByUser(String userId);



}
