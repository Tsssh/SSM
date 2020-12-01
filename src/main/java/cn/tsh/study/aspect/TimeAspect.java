package cn.tsh.study.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ：tsh
 * @date ：Created in 2020/11/30 15:28
 * @description：
 * @modified By：
 * @version: $
 */
@Aspect
@Component
public class TimeAspect {
  /**
   * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
   *通过@Pointcut注解声明频繁使用的切点表达式
   */
  @Pointcut("execution(public * cn.tsh.study.controller..* (..) )")
  public void GameDataAspect(){

  }

  /**
   * 切片方法
   * @param pjp 包含已拦截方法中的所用信息
   * @return
   */
  @Around("GameDataAspect()")
  public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
    System.out.println("time aspect start");
    long start = System.currentTimeMillis();
    Object[] args = pjp.getArgs();
    for(Object arg : args){
      System.out.println("arg is "+arg);
    }
    Object obj = pjp.proceed();
    System.out.println("time aspect 耗时："+(System.currentTimeMillis()-start));
    System.out.println("time aspect stop");
    return obj;
  }
}
