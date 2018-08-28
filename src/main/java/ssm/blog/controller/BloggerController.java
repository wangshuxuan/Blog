package ssm.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wangshuxuan
 * @date 2018/8/27 17:52
 * 博主
 */

@Controller
@RequestMapping("/blogger")
public class BloggerController {

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping("/login.do")
    public String login(HttpServletRequest request, HttpServletResponse response, Blogger blogger) {

        try {
            Blogger bUser = bloggerService.login(blogger);
            request.getSession().setAttribute("currentUser", bUser);
            return "redirect:/admin/menu.do";
        } catch (Exception e) {
            request.setAttribute("blogger", blogger);
            request.setAttribute("errorInfo", e.getMessage());
        }
        return "login";
    }

    @RequestMapping("/logout.do")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Blogger currentUser = (Blogger) request.getSession().getAttribute("currentUser");
        request.getSession().removeAttribute("currentUser");
        request.setAttribute("blogger", currentUser);
        return "login";
    }
}
