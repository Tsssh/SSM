package cn.tsh.study;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
@Slf4j
@SpringBootApplication
@MapperScan("cn.tsh.study.mapper")
@ServletComponentScan("cn.tsh.study.filter")
public class DemoApplication {

    public static void main(String[] args) {
      log.info("com.tsh.DemoApplication is success!");
      SpringApplication.run(DemoApplication.class, args);
    }

}
