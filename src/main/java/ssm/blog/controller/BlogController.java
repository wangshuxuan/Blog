package ssm.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;

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
		request.setAttribute("blog", blog);
		return "foreground/blog/blogDetail";
	}	
}
