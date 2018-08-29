package ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.LinkMapper;
import ssm.blog.entity.Link;
import ssm.blog.service.LinkService;
import ssm.blog.utils.DatagridResult;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/27 9:40
 */
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    public List<Link> getTotalData() {
        List<Link> linkList = linkMapper.getTotalData();
        return linkList;
    }

    public void saveLink(Link link) {
        linkMapper.addLink(link);
    }

    public DatagridResult listByPage(Integer page, Integer rows) {
        //分页插件
        DatagridResult result = new DatagridResult();
        PageHelper.startPage(page, rows);
        List<Link> linkList = linkMapper.list();
        PageInfo<Link> info = new PageInfo<Link>(linkList);
        result.setTotal(info.getTotal());
        result.setRows(linkList);
        return result;
    }

    public void deleteLinkByIds(String ids) {

        String[] strings = ids.split(",");
        for (String id : strings) {
            linkMapper.deleteLink(Integer.parseInt(id));
        }
    }
}
