package cn.tsh.study.controller;

import cn.tsh.study.model.Role;
import cn.tsh.study.model.User;
import cn.tsh.study.service.LoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/9 10:59
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class LoginController {

  @Autowired
  private LoginService loginService;

  /**
   * POST登录
   * @param map
   * @return
   */
  @PostMapping(value = "/login")
  public String login(@RequestBody User user) {
    // 添加用户认证信息
    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getName(), user.getPassword());
    System.out.println("进入验证");
    // 进行验证，这里可以捕获异常，然后返回对应信息
    SecurityUtils.getSubject().login(usernamePasswordToken);
    return "login ok!";
  }

  /**
   * 添加用户
   * @param user
   * @return
   */
  @PostMapping(value = "/addUser")
  public String addUser(@RequestBody User user) {
    if(loginService.addUser(user)) {
      return "addUser is ok! \n" ;
    }
    else {

      return "addUser is not ok! \n" ;

    }
  }

  /**
   * 添加角色
   * @param role
   * @return
   */
  @PostMapping(value = "/addRole")
  public String addRole(@RequestBody Role role) {
    role = loginService.addRole(role);
    return "addRole is ok! \n" + role;
  }

  /**
   * 注解的使用
   * @return
   */

  @RequiresRoles("admin")
  @RequiresPermissions("create")
  @GetMapping(value = "/create")
  public String create() {
    return "Create success!";
  }

  @GetMapping(value = "/index")
  public String index() {
    return "index page!";
  }

  @GetMapping(value = "/error")
  public String error() {
    return "error page!";
  }

  /**
   * 退出的时候是get请求，主要是用于退出
   * @return
   */
  @GetMapping(value = "/login")
  public String login() {
    return "login111";
  }

  @GetMapping(value = "/logout")
  public String logout() {
    return "logout";
  }
}
