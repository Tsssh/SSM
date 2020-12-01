package cn.tsh.study.controller;

import cn.tsh.study.model.Student;
import cn.tsh.study.service.StudentService;
import cn.tsh.study.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 惠普
 */
@RestController
@EnableAutoConfiguration
@RequestMapping("/admin")
public class HelloController {
    @Autowired
    private StudentService
            studentService;
    @Value("${server.port}")
    private String serverPort;
    @RequestMapping(value = "/select")
    public JsonResult<List> select() {

        Student student1 = (Student) studentService.selectByPrimaryKey(2);

        List<Student> list = new ArrayList<>();
        list.add(student1);



        return new JsonResult<>(list,"select i am port"+serverPort);
    }
  @RequestMapping(value = "/select1")
  public JsonResult<List> select1() {

    Student student1 = (Student) studentService.selectByPrimaryKey(2);
    Student student2 = (Student) studentService.selectByPrimaryKey(2);
    List<Student> list = new ArrayList<>();
    list.add(student1);
    list.add(student2);


    return new JsonResult<>(list,"select1 i am port"+serverPort);
  }
  @RequestMapping(value = "/select2/{i}",method = RequestMethod.GET)
  public JsonResult<List> select2(@PathVariable int i) {

    Student student1 = (Student) studentService.selectByPrimaryKey(i);

    List<Student> list = new ArrayList<>();
    list.add(student1);



    return new JsonResult<>(list,"select1 i am port"+serverPort);
  }
  @RequestMapping(value = "/select3",method = RequestMethod.GET)
  public JsonResult<List> select3(@RequestParam("uid") int uid, @RequestParam("uname") String uname) {

    Student student1 = (Student) studentService.selectByPrimaryKey(uid);

    List<Student> list = new ArrayList<>();
    list.add(student1);



    return new JsonResult<>(list,"select1 i am port"+serverPort);
  }
  @RequestMapping(value = "/select4",method = RequestMethod.GET)
  public JsonResult<List> select4(@Validated Student student) {

    System.out.println(student.getAge());
    List<Student> list = new ArrayList<>();
    list.add(student);
    return new JsonResult<>(list,"select1 i am port"+serverPort);
  }

}
