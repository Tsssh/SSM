package cn.tsh.study.task;

/**
 * @author ：tsh
 * @date ：Created in 2020/12/11 15:20
 * @description：
 * @modified By：
 * @version: $
 */
/**
 * 点赞的定时任务
 */

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
public class LikeTask extends QuartzJobBean {



private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

@Override
protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {

  log.info("LikeTask-------- {}", sdf.format(new Date()));

  //将 Redis 里的点赞信息同步到数据库里
  //likedService.transLikedFromRedis2DB();
  //likedService.transLikedCountFromRedis2DB();
  }
  }
