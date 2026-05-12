package cc.wlizhi.springbootdemo.model.base;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema
public class Result<T> {
    @Schema(description = "响应码")
    private int code;
    @Schema(description = "响应信息")
    private String message;
    @Schema(description = "响应数据")
    private T data;

    public Result() {
    }

    public Result(int code, String message, T data) {
        this(code, message, null, data);
    }

    public Result(int code, String message, Object[] messageArgs, T data) {
        this.code = code;
        // 不需要国际化
//        this.message = MessageSourceSupport.getMessage(message, messageArgs);
        this.message = message;
        this.data = data;
    }

    public static <T> Result<T> ok() {
        return ok(null);
    }

    public static <T> Result<T> ok(T data) {
        return new Result<>(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(), data);
    }

    public static <T> Result<T> error(ResponseCodeInfo responseCodeInfo) {
        return error(responseCodeInfo, null);
    }

    public static <T> Result<T> error(ResponseCodeInfo responseCodeInfo, T data) {
        return error(responseCodeInfo, null, data);
    }

    public static <T> Result<T> error(ResponseCodeInfo responseCodeInfo, Object[] messageArgs, T data) {
        return new Result<>(responseCodeInfo.getCode(), responseCodeInfo.getMessage(), messageArgs, data);
    }
}
