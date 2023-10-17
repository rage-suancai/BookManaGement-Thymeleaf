package com.manage.mapper;

import com.manage.entity.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("select bid,title,`desc`,price from db_book")
    List<Book> getBookList();

    @Insert("insert into db_book(title,`desc`,price) values(#{title},#{desc},#{price})")
    void addBook(@Param("title") String title, @Param("desc") String desc, @Param("price") double price);

    @Delete("delete from db_book where bid = #{bid}")
    void deleteBook(Integer bid);

}
