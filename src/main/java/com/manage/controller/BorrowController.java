package com.manage.controller;

import com.manage.service.BookService;
import com.manage.service.BorrowService;
import com.manage.service.StudentService;
import jakarta.annotation.Resource;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BorrowController {

    @Resource
    private BookService bookService;
    @Resource
    private BorrowService borrowService;
    @Resource
    private StudentService studentService;

    @GetMapping({ "/borrow", "/"})
    public String borrow(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("borrow_list", borrowService.getBorrowList());
        model.addAttribute("book_count", bookService.getBookList().size());
        model.addAttribute("student_count", studentService.getStudentList().size());
        return "borrow";
        
    }
    @GetMapping("/add-borrow")
    public String addBorrow(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("nickname", user.getUsername());
        model.addAttribute("book_list", bookService.getBookList());
        model.addAttribute("student_list", studentService.getStudentList());
        return "add-borrow";

    }
    @PostMapping("/add-borrow")
    public String addBorrow(Integer sid, Integer bid) {

        System.out.println("sid: " + sid); System.out.println("bid: " + bid);
        borrowService.addBorrow(sid, bid); return "redirect:/borrow";

    }

    @GetMapping("/return-book")
    public String returnBook(Integer bid) {
        bookService.returnBook(bid); return "redirect:/borrow";
    }

}
