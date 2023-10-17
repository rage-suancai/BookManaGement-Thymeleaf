package com.manage.controller;

import com.manage.service.BookService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class BookController {

    @Resource
    private BookService bookService;

    @GetMapping("/books")
    public String book(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("book_list", bookService.getBookList().keySet());
        model.addAttribute("book_list_status", new ArrayList<>(bookService.getBookList().values()));
        return "book";

    }
    @GetMapping("/add-book")
    public String addBook() {
        return "add-book";
    }

    @PostMapping("/add-book")
    public String addBook(String title, String desc, double price) {
        bookService.addBook(title, desc, price); return "redirect:/books";
    }

    @GetMapping("/delete-book")
    public String deleteBook(Integer bid) {
        bookService.deleteBook(bid);return "redirect:/books";
    }

}
