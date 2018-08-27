package ssm.blog.utils;

/**
 * @author wangshuxuan
 * @date 2018/8/27 19:33
 *
 */
public class PathUtils {

    /**
     * 获取根项目路径
     * @return
     */
    public static String getRootPath(){
        String path=PathUtils.class.getResource("/").toString();
        for (int i = 0; i < 5; i++) {
            int end = path.lastIndexOf("/");
            path = path.substring(0, end);
        }
        int index = path.indexOf(":");
        return path.substring(index+1);
    }
}
