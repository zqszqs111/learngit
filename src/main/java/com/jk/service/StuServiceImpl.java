package com.jk.service;

import com.jk.dao.IStuDao;
import com.jk.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ 创建者：赵清顺.
 * @ 创建时间：2018/8/3 0003 16:52
 * @ Description：
 * @ Version:
 */
@Service
public class StuServiceImpl implements IStuService{

   @Autowired
   private IStuDao stuDao;

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Student> querystu() {
        return stuDao.querystu();
    }

    @Override
    public void deletestu(String id) {
        stuDao.delete(id);
    }

    @Override
    public void addstu(Student student) {
        student.setStuid(1);
        student.setStuname("小小");
        student.setStuage("32");
        stuDao.addstu(student);
    }

    @Override
    public Student selectstu(Integer id) {

        return stuDao.selectstu(id);
    }

    @Override
    public void updatestu(Student student) {

        stuDao.updatestu(student);
    }


        public void addjdbc(Integer stuid,String stuname,String stuage){
            String sql = "insert into student values(?,?,?)";
                Object zhi[] = {stuid,stuage,stuname};
                jdbcTemplate.update(sql,zhi);
            System.out.println("用户添加成功！！");
    }

}
