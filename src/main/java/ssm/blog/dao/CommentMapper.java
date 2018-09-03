package ssm.blog.dao;

import java.util.List;

import ssm.blog.entity.Comment;

/**
 * 
 * <p>Title: CommentMapper</p>
 * <p>Description:评论 </p>
 * <p>wsx</p> 
 * @version 1.0
 */

public interface CommentMapper {

	void saveComment(Comment comment);

	List<Comment> queryByBlogId(Integer id);
	
	
}
