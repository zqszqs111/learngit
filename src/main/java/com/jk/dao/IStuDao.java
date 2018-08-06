package com.jk.dao;

import com.jk.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface IStuDao {

    @Select(" select * from student ")
    List<Student> querystu();

    @Delete(" delete from student where stuid in (${id})")
    void delete(@Param("id") String id);

    @Insert(" INSERT into student values(#{student.stuid},#{student.stuname},#{student.stuage})")
    void addstu(@Param("student") Student student);

    //回显
    @Select(" select * from student where stuid ")
    Student selectstu(@Param("id")Integer id);

    //修改
    @Update(" update student set stuname=#{student.stuname},stuage=#{student.student} ")
    void updatestu(@Param("student") Student student);





}
