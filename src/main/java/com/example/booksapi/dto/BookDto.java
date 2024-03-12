package com.example.booksapi.dto;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookDto {

    private Long id;

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Author cannot be blank")
    private String author;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be greater than 0")
    @Digits(integer = 4, fraction = 2, message = "Price must be: xxxx.xx (leading and trailing 0s can be omit)")
    private Double price;
}
