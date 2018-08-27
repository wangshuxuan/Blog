package ssm.blog.dao;

import ssm.blog.entity.BlogType;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/24 10:24
 * 博客类别持久层
 */
public interface BlogTypeMapper {

    //查询
    public List<BlogType> listBlogTypeByPage();

    public void saveBlogType(BlogType blogType);

    public void updateBlogType(BlogType blogType);

    public void deleteBlogByTypeById(int i);

    public List<BlogType> getBlogTypeData();
}
