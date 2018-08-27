package ssm.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wangshuxuan
 * @date 2018/8/22 18:06
 *  跳转
 */
@Controller
@RequestMapping(value = "/admin")
public class MainAdminController {

    @RequestMapping(value = "/menu.do")
    public String toMenuPage() {
        return  "admin/main";
    }
}
