package com.jk.service;

import com.jk.model.Student;

import java.util.List;

public interface IStuService {

        List<Student> querystu();

        void deletestu(String id);

        void addstu(Student student);

       Student selectstu(Integer id);

        void updatestu(Student student);

        void addjdbc(Integer stuid,String stuage,String stuname);




}
