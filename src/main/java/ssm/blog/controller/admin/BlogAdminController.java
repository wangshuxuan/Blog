package ssm.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;
import ssm.blog.utils.DatagridResult;
import ssm.blog.utils.Result;

/**
 * @author wangshuxuan
 * @date 2018/8/27 10:10
 * 博客controller
 */
@Controller
@RequestMapping(value = "/admin/blog")
public class BlogAdminController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "save.do")
    @ResponseBody
    public Result addBlog(Blog blog) {
        blogService.addBlog(blog);
        return new Result(true);
    }

    @RequestMapping(value = "listBlog.do")
    @ResponseBody
    public DatagridResult listBolg(@RequestParam(defaultValue = "1") Integer page, Integer rows, String title) {
        DatagridResult result = blogService.listBlogByPage(page, rows, title);
        return result;
    }
}
