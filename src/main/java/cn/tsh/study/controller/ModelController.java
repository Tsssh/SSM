package cn.tsh.study.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ：tsh
 * @date ：Created in 2020/11/30 17:39
 * @description：
 * @modified By：
 * @version: $
 */
@Controller
@EnableAutoConfiguration
@RequestMapping("/model")

public class ModelController {
  @RequestMapping("/tiao")
  public String s(Model model, String name){
    model.addAttribute("name",name);
    System.out.println("**********************8跳转");
    return "JS/showinfo";
  }
}
