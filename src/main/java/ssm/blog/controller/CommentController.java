package ssm.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ssm.blog.utils.Result;

/**
 * 
 * <p>Title: CommentController</p>
 * <p>Description: 评论</p>
 * <p>Company: wsx</p> 
 * @version 1.0
 */

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@RequestMapping("/save.do")
	@ResponseBody
	public Result saveComment(String content,HttpServletRequest request,
			@RequestParam(name="blog.id") Integer blogId, String imageCode) {
		//session取出验证码
		String validator = (String) request.getSession().getAttribute("sRand");
		if (!validator.equals(imageCode)) {
			return new Result(false, "验证码错误");
		}
		//ip
		String userIp = getIpAddress(request);
		commentService.saveComment(content, blogId, userIp);
		return new Result(true);
	}
	
	public String getIpAddress(HttpServletRequest request) {

	    String ip = request.getHeader("x-forwarded-for");

	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getHeader("HTTP_CLIENT_IP");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	      ip = request.getRemoteAddr();
	    }
	    return ip;
	  }
}
