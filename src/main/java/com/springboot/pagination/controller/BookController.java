package com.springboot.pagination.controller;

import com.springboot.pagination.model.Book;
import com.springboot.pagination.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookRepository bookRepository;
    @GetMapping
    public Page<Book> pagination(@RequestParam Integer pageSize
                                , @RequestParam Integer currentPage) {
        Pageable pageable = PageRequest.of(currentPage,pageSize);
        return bookRepository.findAll(pageable);
    }
}
