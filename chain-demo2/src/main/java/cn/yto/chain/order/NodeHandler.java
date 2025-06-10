package cn.yto.chain.order;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
public abstract class NodeHandler {  
  
/**  
* 处理校验订单以及创建订单信息  
* @param requestVO 订单创建入参  
* @return 订单DO实体类  
*/  
public abstract OrderDO handleOrder(OrderCreateRequestVO requestVO);  
  
/**  
* 执行业务处理链路  
* @param requestVO 订单创建入参  
* @param nodeComponentList 业务处理节点  
* @return  
*/  
protected OrderDO executeChain(OrderCreateRequestVO requestVO, List<? extends INodeComponent> nodeComponentList){
	final OrderParam orderParam = this.buildOrderParam(requestVO);  
	final OrderContext orderContext = OrderContext.builder().build();  
	for (INodeComponent nodeComponent : nodeComponentList){  
		// 此处进行业务处理节点的调用
		nodeComponent.handleData(orderContext, orderParam);  
	}  
	  
	log.info("执行的链路：{}", String.join(",", Optional.ofNullable(orderContext.getExecuteRuleList()).orElse(new ArrayList<>())));
	return this.buildOrderDO(orderContext);
}
