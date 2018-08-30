package ssm.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssm.blog.dao.BlogMapper;
import ssm.blog.entity.Blog;
import ssm.blog.service.BlogService;
import ssm.blog.utils.DatagridResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangshuxuan
 * @date 2018/8/27 9:46
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    public void addBlog(Blog blog) {
        blogMapper.saveBlog(blog);
    }

    public DatagridResult listBlogByPage(Integer page, Integer rows, String title) {
        PageHelper.startPage(page, rows);

        //执行查询
        List<Blog> list = blogMapper.listBlog(title);

        PageInfo<Blog> PageInfo = new PageInfo(list);
        DatagridResult result = new DatagridResult();
        result.setTotal(PageInfo.getTotal());
        result.setRows(list);
        return result;
    }

    public PageInfo<Blog> listBlogByPage(Integer page, Integer rows, String typeId, String releaseDateStr) {
        Map<String,String> map = new HashMap<String, String>();
        map.put("typeId", typeId);
        map.put("releaseDateStr", releaseDateStr);
        PageHelper.startPage(page, rows);
        List<Blog> list = blogMapper.listBlogByParam(map);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list,3);
        return pageInfo;
    }


    public void deleteBlogByIds(String ids) {
        String[] idStr = ids.split(",");
        for (String id : idStr) {
            blogMapper.deleteById(Integer.parseInt(id));
        }
    }

    public Blog getBlogToShowById(Integer id) {
        Blog blog = blogMapper.getById(id);
        return blog;
    }

    public void updateBlog(Blog blog) {
        blogMapper.updateBlog(blog);
    }
}
