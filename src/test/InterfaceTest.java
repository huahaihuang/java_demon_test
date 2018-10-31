package test;

import java.util.HashMap;
import java.util.Map;

import business.IBusiness;
import entity.Order;
import factory.BusinessFactory;

public class InterfaceTest {

	/**
	 * 模仿用户调用接口
	 * @param args
	 */
	public static void main(String[] args) {
		//每次请求接口时都将数据库里面的供应商id和类名
		Map<String, String> data = new HashMap<String, String>();
		data.put("1", "business.impl.AgentA");
		data.put("2", "business.impl.AgentB");
		
		//清除数据
		BusinessFactory.clear();
		
		for (String key : data.keySet()) {
			BusinessFactory.registerBusiness(key, data.get(key));
		}
		
		//获取订单信息及产品所属的供应商,这里假设查到的供应商编号为1
		Order order = new Order();
		String agentId = "3";
		//工厂生成业务对象
		IBusiness business = null;
		try {
			business = BusinessFactory.instance(agentId);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//调用业务方法
		Object result = business.execute(order);
		System.out.println(result);
	}

}
