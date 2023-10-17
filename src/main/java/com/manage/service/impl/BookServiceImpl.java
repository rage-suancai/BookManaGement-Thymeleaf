package com.manage.service.impl;

import com.manage.entity.Book;
import com.manage.mapper.BookMapper;
import com.manage.service.BookService;
import com.manage.service.BorrowService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;
    @Resource
    private BorrowService borrowService;

    @Override
    public Map<Book, Boolean> getBookList() {

        Set<Integer> set = new HashSet<>(); Map<Book, Boolean> map = new LinkedHashMap<>();

        borrowService.getBorrowList().forEach(borrow -> set.add(borrow.getBid()));
        bookMapper.getBookList().forEach(book -> map.put(book, set.contains(book.getBid()))); return map;

    }

    @Override
    public List<Book> getActiveBookList() {

        Set<Integer> set = new HashSet<>();

        borrowService.getBorrowList().forEach(borrow -> set.add(borrow.getBid()));
        return bookMapper.getBookList()
                .stream()
                .filter(book -> !set.contains(book.getBid()))
                .toList();

    }

    @Override
    public void returnBook(Integer bid) {
        bookMapper.deleteBook(bid);
    }

    @Override
    public void addBook(String title, String desc, double price) {
        bookMapper.addBook(title, desc, price);
    }

    @Override
    public void deleteBook(Integer bid) {
        bookMapper.deleteBook(bid);
    }

}
