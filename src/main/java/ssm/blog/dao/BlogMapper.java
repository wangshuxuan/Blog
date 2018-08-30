package ssm.blog.dao;

import ssm.blog.entity.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author wangshuxuan
 * @date 2018/8/27 10:21
 * 博客mapper
 */
public interface BlogMapper {


    void saveBlog(Blog blog);


    List<Blog> listBlog(String title);

    void deleteById(int i);

    Blog getById(Integer id);

    void updateBlog(Blog blog);

    List<Blog> listBlogByParam(Map<String,String> map);
}
