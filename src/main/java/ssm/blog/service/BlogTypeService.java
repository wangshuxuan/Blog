package ssm.blog.service;

import ssm.blog.entity.BlogType;
import ssm.blog.utils.DatagridResult;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/24 10:03
 */
public interface BlogTypeService {

    //分页查询博客类别
    public DatagridResult listBlogTypeByPage(Integer page, Integer rows);

    public void saveBlogType(BlogType blogType);

    public void updateBlogType(BlogType blogType);

    public void deleteBlogByTypeById(String ids);

    public List<BlogType> getBlogTypeData();
}
