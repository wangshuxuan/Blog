package ssm.blog.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangshuxuan
 * @date 2018/8/24 10:14
 * 分页返回结果
 */
public class DatagridResult implements Serializable {
    private long total;// 记录总数
    private List rows; // 记录集合


    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
