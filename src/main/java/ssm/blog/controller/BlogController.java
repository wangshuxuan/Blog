package ssm.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;

import java.util.Arrays;
import java.util.List;

/**
 * 
 * <p>Title: BlogController</p>
 * <p>Description:博客 </p>
 * <p>wsx</p> 
 */

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/articles/{id}")
	public String showBlogInfo(@PathVariable("id") Integer id, HttpServletRequest request) {
		Blog blog = blogService.getBlogToShowById(id);

		//获取关键字
        String keyWord = blog.getKeyWord();
        if (StringUtils.isNotBlank(keyWord)) {
            String[] split = keyWord.split(",");
            List<String> keyWordsList = Arrays.asList(split);
            request.setAttribute("keyWords", keyWordsList);
        }else {
            request.setAttribute("keyWords", null);
        }
        request.setAttribute("blog", blog);
        request.setAttribute("commonPage", "/foreground/blog/blogDetail.jsp");
		return "mainTemp";
	}	
}
