package ssm.blog.service.impl;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssm.blog.controller.CommentService;
import ssm.blog.dao.BlogMapper;
import ssm.blog.dao.CommentMapper;
import ssm.blog.entity.Blog;
import ssm.blog.entity.Comment;
import ssm.blog.utils.DatagridResult;

/**
 * 
 * <p>Title: CommentServiceImpl</p>
 * <p>Description: </p>
 * <p>Company: wsx</p> 
 * @version 1.0
 */

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private BlogMapper blogMapper;

	public void saveComment(String content, Integer blogId, String userIp) {
		
		Comment comment = new Comment();
		Blog blog = new Blog();
		blog.setId(blogId);
		comment.setBlog(blog);
		comment.setUserIp(userIp);
		comment.setState(0);
		comment.setCommentDate(new Date());
		comment.setContent(content);
		commentMapper.saveComment(comment);
		//评论数
		Blog blog2 = blogMapper.getById(blogId);
		blog2.setReplyHit(blog2.getReplyHit()+1);
		blogMapper.updateBlog(blog2);
	}

	public List<Comment> getCommentByBlogId(Integer id) {
		List<Comment> list = commentMapper.queryByBlogId(id);
		return list;
	}

	public DatagridResult listByPage(Integer page, Integer rows, Integer state) {

		DatagridResult result = new DatagridResult();

		PageHelper.startPage(page, rows);
		//查询
		List<Comment> list = commentMapper.listByPage(state);

		PageInfo<Comment> pageInfo = new PageInfo<Comment>(list);

		result.setRows(list);
		result.setTotal(pageInfo.getTotal());

		return result;
	}

    public void reviewComment(String ids, Integer state) {

        String[] split = ids.split(",");
        for (String s : split) {
            Comment comment = new Comment();
            comment.setId(Integer.parseInt(s));
            comment.setState(state);
            commentMapper.updateComment(comment);
        }
    }

    public void deleteComment(String ids) {
        String[] split = ids.split(",");
        for (String s : split) {
            commentMapper.deleteComment(Integer.parseInt(s));
        }
    }

}
