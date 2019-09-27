package result;

/**
 * 后台向前台返回的数据对象
 * @author Administrator
 *
 */
public class ResultForView <T> {
	
	/**
	 *  响应状态码 ，用于响应状态码
	 *  	
	 */
	private String state;
	
	/**
	 * 响应信息，主要用于当服务器报错是响应相关信息
	 */
	private String msg;
	
	/**
	 * 响应结果， 用于响应后台信息
	 */
	private T data ;
	
	public ResultForView()
	{
		
	}
	
	public ResultForView(T data)
	{
		this.setData(data);
	}
	
	public ResultForView(String state, String msg, T data)
	{
		this.state = state;
		this.msg = msg;
		this.data = data;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
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
