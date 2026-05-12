package cc.wlizhi.springbootdemo.model.base;

import lombok.ToString;

/**
 * 通用状态码：三位数字构成
 * <p>
 * 业务状态码：一般状态码由5位数字构成。
 * 业务（3位）+ 状态码（2位）
 * <p>
 */
@ToString
public enum ResponseCode implements ResponseCodeInfo {
	/**
	 * 通用
	 */
	SUCCESS(200, "成功"),
	SERVER_ERROR(500, "服务器内部错误"),
	;

	final int code;
	final String message;

	ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	@Override
	public int getCode() {
		return this.code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}
}
