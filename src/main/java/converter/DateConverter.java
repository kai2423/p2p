package converter;

import java.util.Date;

import org.springframework.core.convert.converter.Converter;

import util.DateUtil;



/**
 * 自定义的日期转换器类
 * @author Administrator
 * 
 *   SpringMVC的转换器接口Converter<被转换的数据类型,转换成什么样的数据类型>
 *   
 *   Converter<String,Date>:  把String类型 转换为Date类型
 *
 */
public class DateConverter  implements Converter<String,Date>{

	
	/**
	 * 转换方法, 这个方法是SpringMVC 获取请求参数, 映射到处理器方法参数时,调用, 把String 转换Date
	 */
	@Override
	public Date convert(String src) {
		return DateUtil.parseDate(src);
	}

	

}
