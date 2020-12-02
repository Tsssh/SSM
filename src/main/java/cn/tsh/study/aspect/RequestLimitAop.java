package cn.tsh.study.aspect;

import cn.tsh.study.anntion.AccessLimit;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/1 11:21
 * @description：
 * @modified By：
 * @version: $
 */
@Component
@Aspect
@Slf4j
public class RequestLimitAop {

  //private Logger LOGGER = LoggerFactory.getLogger(getClass());
  @Autowired
  private RedisTemplate redisTemplate;

  @Before("within(@org.springframework.web.bind.annotation.RestController *) && @annotation(limit)")
  public void requestLimit(JoinPoint joinPoint, AccessLimit limit) throws Exception {
    Object[] args = joinPoint.getArgs();
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    String ip = request.getRemoteAddr();
    log.info("访问的ip地址为：{}", ip);
    String url = request.getRequestURL().toString();
    String key = "req_limit_".concat(url).concat("_").concat(ip);
    boolean checkResult = checkByRedis(limit, key);
    if (!checkResult) {
      log.info("requestLimited," + "[用户ip:{}],[访问地址:{}]超过了限定的次数[{}]次", ip, url, limit.count());
       throw new RuntimeException("请求超出限制");
    }
  }

  private boolean checkByRedis(AccessLimit limit, String key) {
    ValueOperations<String, Integer> operations = redisTemplate.opsForValue();
    //判断redis中是否有键为key的缓存
    boolean hasKey = redisTemplate.hasKey(key);
    //Integer incrByCount =
    if (hasKey) {
      int cnt = operations.get(key);
      //System.out.println("访问次数");
      cnt++;
      operations.set(key,cnt);
      if (cnt > limit.count()) {
        /**
         * 该次请求已经超过了规定时间范围内请求的最大次数
         */
        log.info("当前请求次数为：{}，该次请求已经超过了规定时间范围内请求的最大次数{}", cnt,limit.count());
        return false;
      } else {
        /**
         * 该次请求已经未超过了规定时间范围内请求的最大次数，可以继续请求
         */
        log.info("当前请求次数为：{}，该次请求未超过规定时间范围内请求的最大次数{}，可以继续请求", cnt,limit.count());
        return true;
      }

    }
    else {
      System.out.println("第一次访问"+key);
      operations.set(key, 0, 30, TimeUnit.SECONDS);
      return true;
    }

  }
}

