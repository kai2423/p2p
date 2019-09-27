package util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


/**
 * HTTPClient工具类
 * @author kai
 *
 */
public class HttpClientUtil {
	
	/**
	 *	  发送get请求
	 *	如果无响应的参数则为 null
	 * @param scheme    ：请求协议
	 * @param host 	       ： IP
	 * @param port      ： 端口号
	 * @param path      ：请求路径
	 * @param map		：请求参数
	 * @param headers   ：请求头
	 * @return			：字符串（JSON）
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String doGet(String scheme, String host, int port, String path, Map<String,String> map, Map<String, String> headers) throws URISyntaxException, ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		URI uri = null;
		if(map == null)
		{
			uri = new URIBuilder().setScheme(scheme).setHost(host).setPort(port).setPath(path).build();
		}
		else
		{
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for(String key : map.keySet())
			{
				nvps.add(new BasicNameValuePair(key, map.get(key)));
			}
			
		    uri = new URIBuilder().setScheme(scheme).setHost(host).setPort(port).setPath(path).setParameters(nvps).build();
		}
		
	    
	    HttpGet httpGet = new HttpGet(uri);
	    
	    if(headers != null)
	    {
	    	for (Map.Entry<String, String> e : headers.entrySet()) {
	    		httpGet.addHeader(e.getKey(), e.getValue());
	        }
	    }
	     
	    CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
	    String result = EntityUtils.toString(httpResponse.getEntity());
	    if(httpResponse != null)
	    {
	    	httpResponse.close();
	    }
	    if(httpClient != null)
	    {
	    	httpClient.close();
	    }
	    return result;
	    
	}
	
	
	
	/**
	 * 发送post请求（有请求头）
	* @param scheme    ：请求协议
	 * @param host 	       ： IP
	 * @param port      ： 端口号
	 * @param path      ：请求路径
	 * @param map		：请求参数
	 * @param headers   ：请求头
	 * @return			：字符串（JSON）
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String doPost(String scheme, String host, int port, String path, Map<String,String> map, Map<String, String> headers) throws URISyntaxException, ClientProtocolException, IOException
	{
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		URI uri = null;
		if(map == null)
		{
			uri = new URIBuilder().setScheme(scheme).setHost(host).setPort(port).setPath(path).build();
		}
		else
		{
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for(String key : map.keySet())
			{
				nvps.add(new BasicNameValuePair(key, map.get(key)));
			}
			
		    uri = new URIBuilder().setScheme(scheme).setHost(host).setPort(port).setPath(path).setParameters(nvps).build();
		}
		
	    
	    HttpPost httpPost = new HttpPost(uri);
	    
	    if(headers != null)
	    {
	    	for (Map.Entry<String, String> e : headers.entrySet()) {
		    	httpPost.addHeader(e.getKey(), e.getValue());
	        }
	    }
	    	     
	    CloseableHttpResponse httpResponse = httpClient.execute(httpPost);
	    String result = EntityUtils.toString(httpResponse.getEntity());
	    if(httpResponse != null)
	    {
	    	httpResponse.close();
	    }
	    if(httpClient != null)
	    {
	    	httpClient.close();
	    }
	    return result;
	    
	}

}
