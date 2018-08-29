package ssm.blog.service;

import ssm.blog.entity.Link;
import ssm.blog.utils.DatagridResult;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/24 16:53
 */
public interface LinkService {

    List<Link> getTotalData();

    void saveLink(Link link);

    DatagridResult listByPage(Integer page, Integer rows);

    void deleteLinkByIds(String ids);
}
