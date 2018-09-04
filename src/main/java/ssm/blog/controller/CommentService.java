package ssm.blog.controller;

import java.util.List;

import ssm.blog.entity.Comment;
import ssm.blog.utils.DatagridResult;

/**
 * 
 * <p>Title: CommentService</p>
 * <p>Description: </p>
 * <p>Company: wsx</p> 
 * @version 1.0
 */

public interface CommentService {

	void saveComment(String content, Integer blogId, String userIp);

	List<Comment> getCommentByBlogId(Integer id);

    DatagridResult listByPage(Integer page, Integer rows, Integer state);

    void reviewComment(String ids, Integer state);

    void deleteComment(String ids);
}
