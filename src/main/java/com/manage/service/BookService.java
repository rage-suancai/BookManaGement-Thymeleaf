package com.manage.service;

import com.manage.entity.Book;

import java.util.List;
import java.util.Map;

public interface BookService {

    Map<Book, Boolean> getBookList();

    List<Book> getActiveBookList();

    void returnBook(Integer bid);

    void addBook(String title, String desc, double price);

    void deleteBook(Integer bid);

}
