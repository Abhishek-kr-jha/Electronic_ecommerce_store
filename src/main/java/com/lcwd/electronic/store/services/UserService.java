package com.lcwd.electronic.store.services;

import com.lcwd.electronic.store.dtos.UserDto;
import com.lcwd.electronic.store.entities.User;

import java.util.List;

public interface UserService {

    //create

    UserDto createUser(UserDto  userDto);

    //update

    UserDto updateUser(UserDto userDto , String userId);

    // Delete users
    void deleteUser(String userId);

    //get all users
    List<UserDto> getAllUsers(int pageNumber, int PageSize, String sortBy, String sortDir);

    //get single users by id
    UserDto getUserById(String userId);

    //get single users by email
    UserDto getUserByEmail(String email);

    //search users
    List<UserDto> searchUser(String keyword);

}
