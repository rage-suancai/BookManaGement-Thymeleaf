package com.manage.mapper;

import com.manage.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "sid", property = "sid"),
            @Result(column = "bid", property = "bid"),
            @Result(column = "time", property = "time"),
            @Result(column = "name", property = "studentName"),
            @Result(column = "title", property = "bookName"),
    })
    @Select("""
            select * from db_borrow
            left join db_student on db_borrow.sid = db_student.sid
            left join db_book on db_book.bid = db_borrow.bid
            """)
    List<Borrow> getBorrowList();

    @Insert("insert into db_borrow(sid,bid,time) values(#{sid},#{bid},NOW())")
    void addBorrow(@Param("sid") Integer sid, @Param("bid") Integer bid);

    @Delete("delete from db_borrow where id = #{id}")
    void deleteBorrow(Integer id);

}
