package ssm.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/30 15:05
 * 首页
 */
@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/index")
    public String index ( @RequestParam(value = "page", defaultValue = "1") String page,
                                @RequestParam(value = "typeId", required = false) String typeId,
                                @RequestParam(value = "releaseDateStr", required = false) String releaseDateStr,
                                HttpServletRequest request) {

        //获取博客信息
        PageInfo<Blog> pageInfo = blogService.listBlogByPage(Integer.parseInt(page), 10, typeId, releaseDateStr);

        List<Blog> blogList = pageInfo.getList();
        for (Blog blog : blogList) {
            //图片
            List<String> imageList = blog.getImageList();
            //内容
            String blogInfo = blog.getContent();
            Document doc = Jsoup.parse(blogInfo);
            Elements jpgs = doc.select("img[src$=.jpg]");
            for(int i = 0; i < jpgs.size(); i++) {
                Element jpg = jpgs.get(i); //获取到单个元素
                imageList.add(jpg.toString()); //把图片信息存到imageList中
                if(i == 2)
                    break; //只存三张图片信息
            }
            Elements pngs = doc.select("img[src$=.png]");
            for(int i = 0; i < pngs.size(); i++) {
                Element png = pngs.get(i); //获取到单个元素
                imageList.add(png.toString()); //把图片信息存到imageList中
                if(i == 2)
                    break; //只存三张图片信息
            }
        }
        pageInfo.setList(blogList);

        request.setAttribute("pageInfo", pageInfo);
        request.setAttribute("title", "博客主页");
        request.setAttribute("commonPage", "/foreground/blog/blogList.jsp");

        return "mainTemp";
    }
}
