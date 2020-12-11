package cn.tsh.study.service;

import cn.tsh.study.model.Role;
import cn.tsh.study.model.User;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/9 10:57
 * @description：
 * @modified By：
 * @version: $
 */
public interface LoginService {

  boolean addUser(User user);

  Role addRole(Role role);

  User findByName(String name);

}
