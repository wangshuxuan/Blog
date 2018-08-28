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

    public void updateBlogger(Blogger blogger) {
        bloggerMapper.updateBlogger(blogger);
    }

    public Blogger login(Blogger blogger) {
        Blogger bUser = bloggerMapper.getBloggerByName(blogger.getUserName());
        if (bUser == null) {
            //用户名不存在
            throw new RuntimeException("用户名不存在!");
        }else if (!bUser.getPassword().equals(blogger.getPassword())) {
            //密码错误
            throw new RuntimeException("密码错误!");
        }
        return bUser;
    }
}
