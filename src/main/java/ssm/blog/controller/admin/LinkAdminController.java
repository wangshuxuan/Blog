package ssm.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.blog.entity.Link;
import ssm.blog.service.LinkService;
import ssm.blog.utils.DatagridResult;
import ssm.blog.utils.Result;

/**
 * @author wangshuxuan
 * @date 2018/8/29 9:02
 * 友情链接
 */

@Controller
@RequestMapping(value = "/admin/link")
public class LinkAdminController {

    @Autowired
    private LinkService linkService;

    @RequestMapping(value = "/save.do")
    @ResponseBody
    public Result saveLink(Link link) {
        linkService.saveLink(link);
        return new Result(true);
    }

    @RequestMapping(value = "/list.do")
    @ResponseBody
    public DatagridResult listAll(@RequestParam(defaultValue = "1") Integer page, Integer rows) {
        DatagridResult result = linkService.listByPage(page, rows);
        return result;
    }

    @RequestMapping(value = "/delete.do")
    @ResponseBody
    public Result deleteLinkByIds(String ids) {
        linkService.deleteLinkByIds(ids);
        return new Result(true);
    }

}
