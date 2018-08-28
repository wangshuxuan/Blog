package ssm.blog.dao;

import ssm.blog.entity.Blogger;

/**
 * @author wangshuxuan
 * @date 2018/8/22 15:47
 * 博主mapper
 */
public interface BloggerMapper {

    //查询信息
    Blogger getBloggerData();

    void updateBlogger(Blogger blogger);

    Blogger getBloggerByName(String userName);
}
