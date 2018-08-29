package ssm.blog.dao;

import ssm.blog.entity.Link;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/29 9:08
 * 友情链接
 */
public interface LinkMapper {


    void addLink(Link link);

    List<Link> getTotalData();

    List<Link> list();

    void deleteLink(int id);
}
