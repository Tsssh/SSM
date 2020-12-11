package cn.tsh.study.service;

import cn.tsh.study.model.User;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/11 15:29
 * @description：
 * @modified By：
 * @version: $
 */
public interface UserService {
  User findById(int id);
}
