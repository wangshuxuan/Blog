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
import ssm.blog.utils.DateUtils;
import ssm.blog.utils.PathUtils;
import ssm.blog.utils.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

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
    @ResponseBody
    public Result saveBlogger(@RequestParam(value = "imageFile",required = false)MultipartFile imageFile, Blogger blogger, HttpServletRequest request) throws IOException {
        if (!imageFile.isEmpty()) {
            String rootPath = request.getSession().getServletContext().getRealPath("/");
            String fileName = imageFile.getOriginalFilename();
            String imageName = DateUtils.getCurrentDateStr() + "." + fileName.split("\\.")[1];
            String path =rootPath +"static\\userImages\\"+ imageName;
            imageFile.transferTo(new File(path));
            blogger.setImageName(imageName);
        }
        bloggerService.updateBlogger(blogger);

        return new Result(true);
    }

    @RequestMapping(value = "/modtifyPassword.do")
    @ResponseBody
    public Result modtifyPassword(Blogger blogger) {
        bloggerService.updateBlogger(blogger);
        return new Result(true);
    }

}
