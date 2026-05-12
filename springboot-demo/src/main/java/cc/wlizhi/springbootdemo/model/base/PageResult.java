package cc.wlizhi.springbootdemo.model.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 分页结果集。
 *
 * @param <T> 分页参数数据类型。
 */
@Getter
@Setter
@Schema
public class PageResult<T> {
    @Schema(description = "当前页码，从1开始")
    private Integer pageIndex;
    @Schema(description = "页面大小")
    private Integer pageSize;
    @Schema(description = "数据总量")
    private Long total;
    @Schema(description = "总页数")
    private Integer totalPages;
    @Schema(description = "数据列表")
    private List<T> list;

//    public static <T> PageResult<T> of(IPage<?> page, List<T> list) {
//        return of((int) page.getCurrent(), (int) page.getSize(), page.getTotal(), (int) page.getPages(), list);
//    }

    public static <T> PageResult<T> of(int pageIndex, int pageSize, long total, int totalPages, List<T> list) {
        PageResult<T> page = new PageResult<>();
        page.setPageIndex(pageIndex);
        page.setPageSize(pageSize);
        page.setTotal(total);
        page.setTotalPages(totalPages);
        page.setList(list);
        return page;
    }
}


