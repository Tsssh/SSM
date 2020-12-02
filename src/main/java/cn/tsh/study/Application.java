package cn.tsh.study;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/2 9:44
 * @description：
 * @modified By：
 * @version: $
 */
@Slf4j
@SpringBootApplication
@MapperScan("cn.tsh.study.mapper")
@ServletComponentScan("cn.tsh.study.filter")
public class Application extends SpringBootServletInitializer {

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    return builder.sources(Application.class);
  }
  public static void main(String[] args){
    SpringApplication.run(Application.class, args);
    log.info("com.cehh.Application is success!");
  }
}
