package ssm.blog.service;

import ssm.blog.entity.Blog;
import ssm.blog.utils.DatagridResult;

/**
 * @author wangshuxuan
 * @date 2018/8/24 16:53
 */
public interface BlogService {

    void addBlog(Blog blog);

    DatagridResult listBlogByPage(Integer page, Integer rows, String title);
}
