package ssm.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;

/**
 * @author wangshuxuan
 * @date 2018/8/27 17:52
 * 博主
 */

@Controller
@RequestMapping("/admin/blogger")
public class BloggerAdminController {

    @Autowired
    private BloggerService bloggerService;

    @RequestMapping(value = "/getBloggerInfo.do")
    @ResponseBody
    public Blogger getBloggerInfo() {
        Blogger bloggerData = bloggerService.getBloggerData();
        return bloggerData;
    }

}
