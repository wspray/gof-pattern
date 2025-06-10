package cn.yto.chain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
public class OrderFactory {  
  
	@Autowired  
	private Map<String, NodeHandler> nodeHandlerMap;
	  
	/**  
	* 创建订单  
	* @param requestVO 订单参数  
	* @return 订单实体DO  
	*/  
	public OrderDO createOrder(OrderCreateRequestVO requestVO){  
		final Integer orderType = requestVO.getOrderType();  
		// 获取node规则执行器名称  
		final String ruleHandler = OrderHandlerEnum.getRuleHandler(orderType);  
		// 获取node规则执行器  
		final NodeHandler nodeHandler = nodeHandlerMap.get(ruleHandler);  
		if (nodeHandler == null){  
			// 异常  
			throw new RuntimeException();  
		}  
		return nodeHandler.handleOrder(requestVO);  
	}  
}
