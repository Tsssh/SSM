package cn.tsh.study.mapper;

import cn.tsh.study.model.User;
import org.springframework.stereotype.Repository;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/9 10:56
 * @description：
 * @modified By：
 * @version: $
 */
@Repository
public interface UserMapper {

  int addUser(User user);

  //Role addRole(Role role);

  User findByName(String name);

}
