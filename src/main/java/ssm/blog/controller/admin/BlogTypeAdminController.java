package ssm.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogTypeService;
import ssm.blog.utils.DatagridResult;
import ssm.blog.utils.Result;

/**
 * @author wangshuxuan
 * @date 2018/8/24 9:44
 * 博客类别
 */
@Controller
@RequestMapping(value = "/admin/blogType")
public class BlogTypeAdminController {

    @Autowired
    private BlogTypeService blogTypeService;

    @RequestMapping(value = "/listBlogType.do")
    @ResponseBody
    public DatagridResult listBlogType( @RequestParam(defaultValue = "1") Integer page, Integer rows) {
        DatagridResult result = blogTypeService.listBlogTypeByPage(page,rows);
        return result;
    }

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public Result saveBlogType(BlogType blogType) {
        if (blogType.getId() == null) {
            blogTypeService.saveBlogType(blogType);
        }else blogTypeService.updateBlogType(blogType);
        return new Result(true);
    }

    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public Result deleteBlogTypeById(String ids) {
        blogTypeService.deleteBlogByTypeById(ids);
        return new Result(true);
    }
}
