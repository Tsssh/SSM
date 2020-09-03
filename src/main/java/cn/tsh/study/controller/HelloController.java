package cn.tsh.study.controller;

import cn.tsh.study.mapper.StudentMapper;
import cn.tsh.study.model.ParkInfo;
import cn.tsh.study.model.Student;
import cn.tsh.study.util.JsonResult;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 惠普
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/admin")
public class HelloController {
    @Resource
    private StudentMapper studentMapper;

    @ResponseBody
    @RequestMapping(value = "/select")
    public JsonResult<List> select() {
        Student student1 = (Student) studentMapper.selectByPrimaryKey(3);
        Student student2 = (Student) studentMapper.selectByPrimaryKey(2);
        List<Student> list = new ArrayList<>();
        list.add(student1);
        list.add(student2);
        return new JsonResult<>(list);
    }
    @ResponseBody
    @RequestMapping(value = "/index")
    public  JsonResult<List> sayHello() {
        List<ParkInfo> list = new ArrayList<ParkInfo>();
        ParkInfo p1=new ParkInfo();
        ParkInfo p2=new ParkInfo();
        p1.setAddress("广州省广州市天河区天府路11-1");
        p1.setBranch_code("441000000");
        p1.setCity("广州");
        p1.setLAT("23.127210");
        p1.setLNG("113.361450");
        p1.setLot_Tp("01");
        p1.setName("方圆小院");
        p1.setProvince("广东");
        p1.setStatus("1");

        p2.setAddress("方圆E时光-车库停车场");
        p2.setBranch_code("441000000");
        p2.setCity("广州");
        p2.setLAT("23.126565");
        p2.setLNG("113.372833");
        p2.setLot_Tp("01");
        p2.setName("方圆E时光-车库停车场");
        p2.setProvince("广东");
        p2.setStatus("1");
        System.out.println(p1.toString());
        list.add(p1);
        list.add(p2);
        return new JsonResult<>(list);

    }

    @RequestMapping("/hello")
    public String hello(Model model) {
        String name = "xiaosha";
        model.addAttribute("name", name);
        return "login";

    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        //User user = userService.checkUser(username, password);
        String a="b";
        if (a.equals("a")) {
            //user.setPassword(null);
            session.setAttribute("user",a);
            return "admin/test";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:hello";
        }
    }

}
