package ssm.blog.dao;

import ssm.blog.entity.Blog;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/27 10:21
 * 博客mapper
 */
public interface BlogMapper {


    void saveBlog(Blog blog);


    List<Blog> listBlog(String title);
}
