package ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogTypeMapper;
import ssm.blog.entity.BlogType;
import ssm.blog.service.BlogTypeService;
import ssm.blog.utils.DatagridResult;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/24 10:04
 */

@Service
public class BlogTypeServiceImpl implements BlogTypeService {

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    public DatagridResult listBlogTypeByPage(Integer page, Integer rows) {

        PageHelper.startPage(page, rows);

        //执行查询
        List<BlogType> list = blogTypeMapper.listBlogTypeByPage();

        PageInfo<BlogType> PageInfo = new PageInfo(list);
        DatagridResult result = new DatagridResult();
        result.setTotal(PageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    public void saveBlogType(BlogType blogType) {
        blogTypeMapper.saveBlogType(blogType);
    }

    public void updateBlogType(BlogType blogType) {
        blogTypeMapper.updateBlogType(blogType);
    }

    public void deleteBlogByTypeById(String ids) {
        String[] split = ids.split(",");
        for (String id : split) {
            blogTypeMapper.deleteBlogByTypeById(Integer.parseInt(id));
        }
    }

    public List<BlogType> getBlogTypeData() {
        List<BlogType> list = blogTypeMapper.getBlogTypeData();
        return list;
    }
}
