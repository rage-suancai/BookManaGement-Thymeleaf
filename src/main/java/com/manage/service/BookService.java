package com.manage.service;

import com.manage.entity.Book;
import com.manage.entity.Borrow;

import java.util.List;

public interface BookService {

    List<Book> getBookList();

    void returnBook(Integer bid);

}
