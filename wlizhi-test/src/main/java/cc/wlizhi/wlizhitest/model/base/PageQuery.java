package cc.wlizhi.wlizhitest.model.base;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 分页查询参数
 */
@Getter
@Setter
@Schema
public class PageQuery implements Serializable {
    @NotNull
    @Min(1)
    @Schema(description = "页码，从1开始", example = "1")
    private Integer pageIndex;

    @NotNull
    @Min(1)
    @Max(1000)
    @Schema(description = "页面大小，取值范围[1,1000]", example = "10")
    private Integer pageSize;
}
