package com.example.tutrest;

public class OrderNotFoundException extends RuntimeException {

    OrderNotFoundException(Long id) {
        super("Could not find Order " + id);
    }
}
