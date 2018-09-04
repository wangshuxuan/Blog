package ssm.blog.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ssm.blog.controller.CommentService;
import ssm.blog.utils.DatagridResult;
import ssm.blog.utils.Result;

/**
 * @author wangshuxuan
 * @date 2018/9/4 9:51
 * 评论
 */

@Controller
@RequestMapping(value = "/admin/comment")
public class CommentAdminController {

    @Autowired
    private CommentService commentService;

    @RequestMapping("/list.do")
    @ResponseBody
    public DatagridResult listComment(@RequestParam(defaultValue = "1") Integer page, Integer rows, Integer state) {
        DatagridResult result = commentService.listByPage(page, rows, state);
        return result;
    }

    @RequestMapping("/review.do")
    @ResponseBody
    public Result reviewComment(String ids, Integer state) {
        commentService.reviewComment(ids, state);
        return new Result(true);
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public Result deleteComment(String ids) {
        commentService.deleteComment(ids);
        return new Result(true);
    }

}
