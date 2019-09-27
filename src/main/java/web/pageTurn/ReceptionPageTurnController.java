package web.pageTurn;

import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转控制类
 * 	控制前台页面的跳转
 * @author kai
 *
 */
@Controller
public class ReceptionPageTurnController {
	
	

	/**
	 * 跳转到/WEB-INF/reception/views/iplog_list.jsp的页面
	 * 		用户登录日志
	 * @return
	 */
	@GetMapping("/reception/views/iplog_list")
	public String trunReceptionViewsIPLog_list() {
		
		return "forward:/WEB-INF/reception/views/iplog_list.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/main.jsp的页面
	 * 		前端首页
	 * @return
	 */
	@GetMapping("/reception/views/main")
	public String trunReceptionViewsMain() {
		
		return "forward:/WEB-INF/reception/views/main.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/personal.jsp的页面
	 * 		用户个人中心
	 * @return
	 */
	@GetMapping("/reception/views/personal")
	public String trunReceptionViewsersonal(HttpSession session,Model model) {
		
		return "forward:/WEB-INF/reception/views/personal.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/realAuth_result.jsp的页面
	 * 		用户实名认证结果
	 * @return
	 */
	@GetMapping("/reception/views/realAuth_result")
	public String trunReceptionViewsealAuth_result() {
		
		return "forward:/WEB-INF/reception/views/realAuth_result.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/realAuth.jsp的页面
	 * 		用户实名认证
	 * @return
	 */
	@GetMapping("/reception/views/ealAuth")
	public String trunReceptionViewsRealAuth() {
		
		return "forward:/WEB-INF/reception/views/realAuth.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/realAuth/userFiles_commit.jsp的页面
	 * 		用户认证文件信息提交
	 * @return
	 */
	@GetMapping("/reception/views/userFiles_commit")
	public String trunReceptionViewsUserFiles_commit() {
		
		return "forward:/WEB-INF/reception/views/userFiles_commit.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/userFiles.jsp的页面
	 * 		用户认证文件信息
	 * @return
	 */
	@GetMapping("/reception/views/userFiles")
	public String trunReceptionViewsUserFiles() {
		
		return "forward:/WEB-INF/reception/views/userFiles.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/userInfo.jsp的页面
	 * 		用户个人资料
	 * @return
	 */
	@GetMapping("/reception/views/userInfo")
	public String trunReceptionViewsUserInfo() {
		
		return "forward:/WEB-INF/reception/views/userInfo.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/reception/views/userInfo.jsp的页面
	 * 		用户个人资料
	 * @return
	 */
	@GetMapping("/reception/views/common/logout")
	public String LogOut(HttpSession session) {
		session.invalidate();
		return "redirect:/reception/login.html";
	}
	
	
}
