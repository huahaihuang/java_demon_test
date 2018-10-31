package factory;

import java.util.HashMap;
import java.util.Map;

import business.IBusiness;

public class BusinessFactory {
	
	private static IBusiness iBusiness;

	private static Map<String, String> businessMap = new HashMap<String, String>();
	
	/**
	 * 将供应商编号和供应商类名称放入map中
	 * @param agentId	代理商编号
	 * @param className	类名(包含包路径)
	 */
	public static void registerBusiness(String agentId, String className){
		businessMap.put(agentId, className);
	}
	
	/**
	 * 清理map中的数据
	 */
	public static void clear(){
		businessMap.clear();
	}
	
	/**
	 * 获取对象
	 * @param agentId
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static IBusiness instance(String agentId) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		iBusiness = (IBusiness) Class.forName((String)businessMap.get(agentId)).newInstance();
		return iBusiness;
	}
}
