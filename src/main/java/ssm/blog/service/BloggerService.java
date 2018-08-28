package ssm.blog.service;

import ssm.blog.entity.Blogger;

/**
 * @author wangshuxuan
 * @date 2018/8/24 16:52
 * 博主service
 */
public interface BloggerService {
    Blogger getBloggerData();

    void updateBlogger(Blogger blogger);

    Blogger login(Blogger blogger);
}
