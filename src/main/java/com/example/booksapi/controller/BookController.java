package com.example.booksapi.controller;

import com.example.booksapi.dto.BookDto;
import com.example.booksapi.dto.SuccessApiResponse;
import com.example.booksapi.service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public SuccessApiResponse<List<BookDto>> getBooks() {
        return new SuccessApiResponse<>(service.getBooks());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessApiResponse<BookDto> getBook(@PathVariable Long id) {
        return new SuccessApiResponse<>(service.getBook(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SuccessApiResponse<String> addBook(@Valid @RequestBody BookDto book) {
        service.addBook(book);
        return new SuccessApiResponse<>("Book successfully added");
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessApiResponse<String> updateBook(@PathVariable Long id, @Valid @RequestBody BookDto book) {
        service.updateBook(id, book);
        return new SuccessApiResponse<>("Book with " + id + " successfully updated");
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SuccessApiResponse<String> deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
        return new SuccessApiResponse<>("Book with " + id + " successfully deleted");
    }
}
