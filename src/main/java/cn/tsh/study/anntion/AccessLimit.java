package cn.tsh.study.anntion;

import java.lang.annotation.*;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/1 10:05
 * @description：
 * @modified By：
 * @version: $
 */
@Inherited
@Documented
@Target({ElementType.FIELD,ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccessLimit {

  /**
   * 允许访问的次数，默认值20
   */
  int count() default 20;

  /**
   * 时间段，单位为毫秒，默认值一分钟
   */
  long time() default 60000;
}

