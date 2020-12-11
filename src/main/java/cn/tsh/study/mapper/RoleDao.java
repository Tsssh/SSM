package cn.tsh.study.mapper;

import cn.tsh.study.model.Role;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/9 10:56
 * @description：
 * @modified By：
 * @version: $
 */
@Mapper
public interface RoleDao  {

  int save(Role role);
}
