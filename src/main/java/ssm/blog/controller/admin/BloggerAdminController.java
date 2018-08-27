package ssm.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;
import ssm.blog.utils.Result;

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


    @RequestMapping(value = "/save.do", method = RequestMethod.POST)
    public Result saveBlogger(@RequestParam(value = "imageFile",required = false)MultipartFile imageFile, Blogger blogger) {


        return null;
    }
}
