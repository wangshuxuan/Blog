package ssm.blog.filter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import ssm.blog.entity.BlogType;
import ssm.blog.entity.Blogger;
import ssm.blog.entity.Link;
import ssm.blog.service.BlogService;
import ssm.blog.service.BlogTypeService;
import ssm.blog.service.BloggerService;
import ssm.blog.service.LinkService;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/29 15:32
 * 自定义过滤器
 */
public class PushDataFilter implements Filter {

    private static WebApplicationContext applicationContext;

    private static ServletContext application;

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //同上，获取博客类别信息service
        BlogTypeService blogTypeService = applicationContext.getBean(BlogTypeService.class);
        //获取博主信息service
        BloggerService bloggerService = applicationContext.getBean(BloggerService.class);
        //获取友情链接service
        LinkService linkService = applicationContext.getBean(LinkService.class);
        //获取博客service
        BlogService blogService = applicationContext.getBean(BlogService.class);
        //获取博客信息
        List<BlogType> blogTypeList = blogTypeService.getBlogTypeData();
        application.setAttribute("blogTypeList", blogTypeList);
        //获取博主信息
        Blogger blogger = bloggerService.getBloggerData();
        //隐藏密码
        blogger.setPassword(null);
        application.setAttribute("blogger",blogger);
        //获取友情链接信息
        List<Link> linkList = linkService.getTotalData();
        application.setAttribute("linkList",linkList);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        application = filterConfig.getServletContext();
        applicationContext = WebApplicationContextUtils.getWebApplicationContext(application);
    }

    public void destroy() {

    }
}
