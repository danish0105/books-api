package com.example.booksapi.dto;

import lombok.Value;

@Value
public class ErrorApiResponse {

    String status = "Error";

    String message;

    int errorCode;
}

