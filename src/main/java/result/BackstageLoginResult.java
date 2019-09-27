package result;

/**
 * 后天用户登录向结果
 * @author Kai
 *
 */
public class BackstageLoginResult {
	
	/**
	 * 是否登录成功
	 * 		true：登录成功
	 * 		false： 登录失败
	 */
	private Boolean isLogin; 
	
	

	/**
	 * 返回信息
	 */
	private String msg;

	public Boolean getIsLogin() {
		return isLogin;
	}

	public void setIsLogin(Boolean isLogin) {
		this.isLogin = isLogin;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "BackstageLoginResult [isLogin=" + isLogin + ", msg=" + msg + "]";
	}

}
