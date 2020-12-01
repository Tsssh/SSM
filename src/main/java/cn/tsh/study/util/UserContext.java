package cn.tsh.study.util;

import cn.tsh.study.model.User;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/1 10:04
 * @description：
 * @modified By：
 * @version: $
 */
//将数据存在当前线程中，当前线程安全
public class UserContext {

  private static ThreadLocal<User> userHolder = new ThreadLocal<User>();

  public static void setUser(User user) {
    userHolder.set(user);
  }

  public static User getUser() {
    return userHolder.get();
  }

}

