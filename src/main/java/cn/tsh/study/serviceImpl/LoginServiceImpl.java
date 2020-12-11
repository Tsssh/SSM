package cn.tsh.study.serviceImpl;

import cn.tsh.study.mapper.RoleDao;
import cn.tsh.study.mapper.UserMapper;
import cn.tsh.study.model.Permission;
import cn.tsh.study.model.Role;
import cn.tsh.study.model.User;
import cn.tsh.study.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/9 10:57
 * @description：
 * @modified By：
 * @version: $
 */

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

  @Autowired
  private UserMapper userMapper;
  @Autowired
  private RoleDao roleDao;

  //添加用户
  @Override
  public boolean addUser(User user) {
    int i=userMapper.addUser(user);
    System.out.println("****************************"+i);
    return i>0?true:false;
  }

  //添加角色
  @Override
  public Role addRole(Role role) {
    User user = userMapper.findByName(role.getUser().getName());
    role.setUser(user);
    Permission permission1 = new Permission();
    permission1.setPermission("create");
    permission1.setRole(role);
    Permission permission2 = new Permission();
    permission2.setPermission("update");
    permission2.setRole(role);
    List<Permission> permissions = new ArrayList<Permission>();
    permissions.add(permission1);
    permissions.add(permission2);
    role.setPermissions(permissions);
    //roleDao.save(role);
    return role;
  }

  //查询用户通过用户名
  @Override
  public User findByName(String name) {
    return userMapper.findByName(name);
  }
}
