package vo;

/**
 * 后台用户登录的vo
 * @author Administrator
 *
 */
public class BackstageLoginVo {
	
	/**
	 * 用户登录账号
	 */
	private String username;
	
	/**
	 * 用户登录密码
	 */
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "BackstageLoginVo [username=" + username + ", password=" + password + "]";
	}
	
	

}
