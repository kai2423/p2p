package web.pageTurn;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 页面跳转控制类
 * 	控制后台页面的跳转
 * @author kai
 *
 */
@Controller
public class BackstagePageTurnController {
	
	/**
	 * 跳转到/WEB-INF/backstage/views/realAuth/list.jsp的页面
	 * 		该页面是实名审核管理的数据列表展示
	 * @return
	 */
	@GetMapping("/backstage/views/realAuth/list")
	public String trunBackstageViewsRealAuthList() {
		
		return "forward:/WEB-INF/backstage/views/realAuth/list.jsp";
	}
	

	/**
	 * 跳转到/WEB-INF/backstage/views/ipLog/list.jsp的页面
	 * 		该页面是登录日志查询
	 * @return
	 */
	@GetMapping("/backstage/views/ipLog/list")
	public String trunBackstageViewsIPLogList()
	{
		return "forward:/WEB-INF/backstage/views/ipLog/list.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/backstage/views/systemdic/systemDictionary_list.jsp的页面
	 * 		数据字典管理
	 * @return
	 */
	@GetMapping("/backstage/views/systemdic/systemDictionary_list")
	public String trunBackstageViewsSystemdicSystemDictionary_list()
	{
		return "forward:/WEB-INF/backstage/views/systemdic/systemDictionary_list.jsp";
	}
	
	
	/**
	 * 跳转到/WEB-INF/backstage/views/systemdic/systemDictionary_list.jsp的页面
	 * 		数据字典明细管理
	 * @return
	 */
	@GetMapping("/backstage/views/systemdic/systemDictionaryItem_list")
	public String trunBackstageViewsSystemdicSystemDictionaryItem_list()
	{
		return "forward:/WEB-INF/backstage/views/systemdic/systemDictionaryItem_list.jsp";
	}
	
	
	
	/**
	 * 跳转到/WEB-INF/backstage/views/userFileAuth/list.jsp的页面
	 * 		用户征信文件审核管理
	 * @return
	 */
	@GetMapping("/backstage/views/userFileAuth/list")
	public String trunBackstageViewsUserFileAuthList()
	{
		return "forward:/WEB-INF/backstage/views/userFileAuth/list.jsp";
	}
	
	//SSM/WebContent/WEB-INF/backstage/views/main.jsp
	/**
	 * 跳转到/WEB-INF/backstage/views/main.jsp的页面
	 * 		后台管理首页
	 * @return
	 */
	@GetMapping("/backstage/views/main")
	public String trunBackstageViewsMain()
	{
		return "forward:/WEB-INF/backstage/views/main.jsp";
	}
	
	

}
