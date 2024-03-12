package com.example.booksapi.dto;

import lombok.Value;

@Value
public class SuccessApiResponse<T> {

    String status = "Success";

    String message;

    T data;

    // region Constructors
    public SuccessApiResponse(T data) {
        this.message = "";
        this.data = data;
    }

    public SuccessApiResponse(String message) {
        this.message = message;
        this.data = null;
    }

    public SuccessApiResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
    // endregion
}
