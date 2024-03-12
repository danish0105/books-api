package com.example.booksapi.service;

import com.example.booksapi.dto.BookDto;
import com.example.booksapi.exception.NoDataFoundException;
import com.example.booksapi.model.Book;
import com.example.booksapi.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository repository;

    private final ModelMapper mapper;

    public List<BookDto> getBooks() {
        return repository.findAll().stream()
                .map(book -> mapper.map(book, BookDto.class))
                .toList();
    }

    public BookDto getBook(Long id) {
        Book book = repository.findById(id).orElseThrow(() -> new NoDataFoundException("No book found with ID " + id));
        return mapper.map(book, BookDto.class);
    }

    public void addBook(BookDto bookDto) {
        repository.save(mapper.map(bookDto, Book.class));
    }

    public void updateBook(Long id, BookDto bookDto) {
        if (!repository.existsById(id)) throw new NoDataFoundException("No book found with ID " + id);

        Book book = mapper.map(bookDto, Book.class);
        book.setId(id);

        repository.save(book);
    }

    public void deleteBook(Long id) {
        if (!repository.existsById(id)) throw new NoDataFoundException("No book found with ID " + id);
        repository.deleteById(id);
    }
}
