package ssm.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogMapper;
import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;

/**
 * @author wangshuxuan
 * @date 2018/8/27 9:46
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public void addBlog(Blog blog) {
        blogMapper.saveBlog(blog);
    }
}
