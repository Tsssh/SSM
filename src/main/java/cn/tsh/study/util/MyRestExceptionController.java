package cn.tsh.study.util;

/**
 * @author ：tsh
 * @date ：Created in 2020/11/30 14:46
 * @description：
 * @modified By：
 * @version: $
 */

import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 基于@ControllerAdvice注解的全局异常统一处理只能针对于Controller层的异常
 * 为了和Controller 区分 ，我们可以指定 annotations = RestController.class，那么在Controller中抛出的异常 这里就不会被捕捉
 * */
@RestControllerAdvice(annotations = RestController.class)
public class MyRestExceptionController {
  private static final Logger logger= LoggerFactory.getLogger(MyRestExceptionController.class);

  /**
   * 处理所有的Controller层面的异常
   * */
  @ExceptionHandler(Exception.class)
  @ResponseBody
  public final Map handleAllExceptions(Exception ex, WebRequest request){
    //logger.error(ex.getMessage());
    Map<String,String> map=new HashMap<>();
    map.put("status","-1");
    //map.put("status",request.);
    System.out.println(ex.getLocalizedMessage());
    map.put("msg",ex.getMessage());

    return map;
  }
}
