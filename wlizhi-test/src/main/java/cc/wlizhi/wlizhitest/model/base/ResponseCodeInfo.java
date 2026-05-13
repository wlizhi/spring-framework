package cc.wlizhi.wlizhitest.model.base;

/**
 * 响应码信息
 */
public interface ResponseCodeInfo {
    /**
     * 响应码
     *
     * @return 响应码
     */
    int getCode();

    /**
     * 响应信息，一般是给前端弹窗提示信息
     *
     * @return 响应信息
     */
    String getMessage();

}
