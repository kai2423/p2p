package result;

/**
 * 状态码
 * 响应给前端的java对象
 * @author Administrator
 *
 */
public class ResponseResult<T> {
	private Boolean success;
	private String msg;
	private T data;



	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
