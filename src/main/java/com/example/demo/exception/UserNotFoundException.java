package com.example.demo.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(int id){
        super(String.format("User with id :"+id+"Not Found!"));
    }

}
