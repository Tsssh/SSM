package cn.tsh.study.serviceImpl;

import cn.tsh.study.mapper.StudentMapper;
import cn.tsh.study.model.Student;
import cn.tsh.study.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  private StudentMapper studentMapper;
  @Autowired
  private RedisTemplate redisTemplate;
  @Override
  public Student selectByPrimaryKey(int i) {

    String key = "user_" + i;

    ValueOperations<String, Student> operations = redisTemplate.opsForValue();

    //判断redis中是否有键为key的缓存
    boolean hasKey = redisTemplate.hasKey(key);

    if (hasKey) {
      Student student = operations.get(key);
      System.out.println("从缓存中获得数据："+student.getName());
      System.out.println("------------------------------------");
      return student;
    } else {
      Student student = studentMapper.selectByPrimaryKey(i);
      System.out.println("查询数据库获得数据：" + student.getName());
      System.out.println("------------------------------------");

      // 写入缓存
      operations.set(key, student, 5, TimeUnit.HOURS);
      return student;
    }
  }
}
