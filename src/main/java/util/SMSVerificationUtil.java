package util;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.client.ClientProtocolException;

/**
 *  	基于阿里云发送短信
 *  		鼎信科技_短信验证码_短信通知API
 * @author kai
 *
 */
public class SMSVerificationUtil {
	
	public static  String sendSMS(String appcode,String mobile,String code,String tpl_id) throws ClientProtocolException, URISyntaxException, IOException
	{
		 		 
		    //请求头
		    Map<String, String> headers = new HashMap<String, String>();	
		    headers.put("Authorization", "APPCODE " + appcode);
		    
		    //请求参数
		    Map<String, String> map = new HashMap<String, String>();
		    map.put("mobile", mobile);
		    map.put("param", "code:"+code);
		    map.put("tpl_id", tpl_id);
 		    
		    return HttpClientUtil.doPost("http", "dingxin.market.alicloudapi.com", 80, "/dx/sendSms", map,headers);
		    
		   
	}

}
