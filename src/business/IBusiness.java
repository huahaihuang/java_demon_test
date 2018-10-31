package business;

import entity.Order;

public interface IBusiness {

	/**
	 * 调用供应商接口,返回的内容将提供给下游用户
	 * @param order
	 * @return
	 */
	public Object execute(Order order);
}
