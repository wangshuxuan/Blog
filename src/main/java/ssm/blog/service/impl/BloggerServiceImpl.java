package ssm.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BloggerMapper;
import ssm.blog.entity.Blogger;
import ssm.blog.service.BloggerService;

/**
 * @author wangshuxuan
 * @date 2018/8/27 9:39
 */
@Service
public class BloggerServiceImpl implements BloggerService {

    @Autowired
    private BloggerMapper bloggerMapper;

    public Blogger getBloggerData() {
        return bloggerMapper.getBloggerData();
    }
}
