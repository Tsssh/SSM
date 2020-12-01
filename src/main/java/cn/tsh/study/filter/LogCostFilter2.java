package cn.tsh.study.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author ：tsh
 * @date ：Created in 2020/11/30 15:17
 * @description：
 * @modified By：
 * @version: $
 *
 * @ClassName: LogCostFilter2
 * @Description:filter的三种典型应用： <br/>
 * 1、可以在filter中根据条件决定是否调用chain.doFilter(request, response)方法， 即是否让目标资源执行<br/>
 *  2、在让目标资源执行之前，可以对request\response作预处理，再让目标资源执行 <br/>
 * 3、在目标资源执行之后，可以捕获目标资源的执行结果，从而实现一些特殊的功能 <br/>
 * */
@WebFilter(urlPatterns = "/admin/*", filterName = "logFilter2")
public class LogCostFilter2 implements Filter {
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    long start = System.currentTimeMillis();
    servletRequest.setCharacterEncoding("UTF-8");
    servletResponse.setCharacterEncoding("UTF-8");
    servletResponse.setContentType("text/html;charset=UTF-8");
    filterChain.doFilter(servletRequest, servletResponse);
    System.out.println("LogFilter2 Execute cost=" + (System.currentTimeMillis() - start));
  }

  @Override
  public void destroy() {

  }
}
