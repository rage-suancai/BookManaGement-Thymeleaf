package com.manage.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {

    Integer id;
    Integer sid;
    Integer bid;
    Date time;

    String bookName;
    String studentName;

}
