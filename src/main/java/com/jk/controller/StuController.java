package com.jk.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.jk.model.Student;
import com.jk.service.IStuService;
import com.mongodb.WriteResult;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.util.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ 创建者：赵清顺.
 * @ 创建时间：2018/8/3 0003 16:41
 * @ Description：
 * @ Version:
 */
@Controller
@RequestMapping("stu")
public class StuController {

    @Autowired
    private IStuService stuService;

   @Resource
   private RedisTemplate<String,Object> redisTemplate;

   @Resource
   private JdbcTemplate jdbcTemplate;

   @Resource
   private MongoTemplate mongoTemplate;

    //查询
    @RequestMapping("querytstu")
    @ResponseBody
    public   List<Student> querystu(){
        List<Student> list=stuService.querystu();

        //redisTemplate.opsForValue().set("11","22");
        //redisTemplate.opsForValue().get("11");
       // System.out.println("112121");
        //redisTemplate.delete("11");


        System.out.println("查询信息："+list);
        return  list;
    }
    //删除
    @RequestMapping("deletestu")
    public void deletestu(String id){
        stuService.deletestu(id);
    }

    //新增
    @RequestMapping("addstu")
    public void addstu(Student student){
        stuService.addstu(student);
    }

    //回显
    @RequestMapping("selectstu")
    public String selectstu(Integer id,Model model){
        Student student = stuService.selectstu(id);
        model.addAttribute("student",student);
        return "ss";
    }

    //修改
    @RequestMapping("updatestu")
    public void updatestu(Student student){
        stuService.updatestu(student);

    }

    @RequestMapping("addjdbc")
    @ResponseBody
    public String addjdbc(Integer stuid,String stuage,String stuname){
        stuService.addjdbc(stuid,stuage,stuname);
            return "1";
    }



    @RequestMapping("jdbclist")
    @ResponseBody
    public List<Map<String, Object>> itemsList(){
        String sql = "select * from student ";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        return list;
    }
        @RequestMapping("addmongodb")
        @ResponseBody
        public String mongodblist(User user){
            user.setUserid(1);
            user.setUsername("sa");
            user.setUserage("32");
            mongoTemplate.save(user);
            System.out.println("新增成功");
            return "1";
        }


        @RequestMapping("querymongodb")
        @ResponseBody
        public String queryLogInfo(){
            List<User> findAll = mongoTemplate.findAll(User.class);
            System.out.println("查询数据："+findAll);

            return "查询成功";
        }

        @RequestMapping("deletemongodb")
        @ResponseBody
        public String deletemongodb(Integer id){
            mongoTemplate.remove(id);

            return "删除成功";
        }

    @RequestMapping("freemarker")
    public String freemarker(Map<String, Object> map){
        map.put("name", "Joe");
        map.put("sex", 1);    //sex:性别，1：男；0：女；

        // 模拟数据
        List<Map<String, Object>> friends = new ArrayList<Map<String, Object>>();
        Map<String, Object> friend = new HashMap<String, Object>();
        friend.put("name", "xbq");
        friend.put("age", 22);
        friends.add(friend);
        friend = new HashMap<String, Object>();
        friend.put("name", "July");
        friend.put("age", 18);
        friends.add(friend);
        map.put("friends", friends);
        return "freemarker";
    }

    }






