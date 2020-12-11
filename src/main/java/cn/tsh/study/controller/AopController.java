package cn.tsh.study.controller;

/**
 * @author ：tsh
 * @date ：Created in 2020/11/30 15:43
 * @description：
 * @modified By：
 * @version: $
 */


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 核心业务模块
 * @author: CSH
 **/
@Slf4j
@RestController
@RequestMapping("/aopController")
public class AopController {

  @RequestMapping(value = "/Curry")
  public void Curry(){
    System.out.println("库里上场打球了！！");
  }

  @RequestMapping(value = "/Harden")
  public void Harden(){
    System.out.println("哈登上场打球了！！");

  }

  @RequestMapping(value = "/Antetokounmpo")
  public void Antetokounmpo(){
    System.out.println("字母哥上场打球了！！");
  }

  @RequestMapping(value = "/Jokic")
  public void Jokic(){
    System.out.println("约基奇上场打球了！！");
  }

  @RequestMapping(value = "/Durant/{point}")
  public void Durant(@PathVariable("point")  int point){
    System.out.println("杜兰特上场打球了！！");
  }

  @Async
  @RequestMapping(value = "/asyncTask1/")
  public void asyncTask1 (int i){
    log.info( "asyncTask1  异步执行  === > 第 {} 次 ",i );
  }

  @Async
  @RequestMapping(value = "/asyncTask2/")
  public void asyncTask2 (int i){
    log.info( "asyncTask2  异步执行  === > 第 {} 次",i );
  }

}
