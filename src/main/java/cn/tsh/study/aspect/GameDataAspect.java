package cn.tsh.study.aspect;

/**
 * @author ：tsh
 * @date ：Created in 2020/11/30 15:59
 * @description：
 * @modified By：
 * @version: $
 */


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @desc:技术统计
 * @author: CSH
 **/
@Aspect
@Component
public class GameDataAspect {
  /**
   * 定义切入点，切入点为com.example.demo.aop.AopController中的所有函数
   *通过@Pointcut注解声明频繁使用的切点表达式
   */
  @Pointcut("execution(public * cn.tsh.study.controller.AopController.Durant(int)) && args(point))")
  public void GameDataAspect(int point){

  }

  /**
   * @description  使用环绕通知
   */
  @Around("GameDataAspect(point)")
  public void doAroundGameData(ProceedingJoinPoint pjp,int point) throws Throwable {
    try{
      System.out.println("球星上场前热身！");
      pjp.proceed();
      System.out.println("球星本场得到" + point + "分" );
    }
    catch(Throwable e){
      System.out.println("异常通知：球迷要求退票！");
    }
  }
}
