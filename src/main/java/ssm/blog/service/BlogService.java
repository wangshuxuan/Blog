package ssm.blog.service;

import com.github.pagehelper.PageInfo;
import ssm.blog.entity.Blog;
import ssm.blog.utils.DatagridResult;

import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/24 16:53
 */
public interface BlogService {

    void addBlog(Blog blog);

    DatagridResult listBlogByPage(Integer page, Integer rows, String title);

    PageInfo<Blog> listBlogByPage(Integer page, Integer rows, String typeId, String releaseDateStr);

    void deleteBlogByIds(String ids);

    Blog getBlogToShowById(Integer id);

    void updateBlog(Blog blog);
}
