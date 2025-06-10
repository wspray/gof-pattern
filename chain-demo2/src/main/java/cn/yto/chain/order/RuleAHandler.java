package cn.yto.chain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component("ruleA")
public class RuleAHandler extends NodeHandler {  
  
@RuleA  
@Autowired
private List<? extends INodeComponent> nodeComponents;
  
	/**  
	* 处理校验订单以及创建订单信息  
	*  
	* @param requestVO 订单创建入参  
	* @return 订单DO实体类  
	*/  
	@Override  
	public OrderDO handleOrder(OrderCreateRequestVO requestVO) {  
		return super.executeChain(requestVO, nodeComponents);  
	}  
}


@Slf4j  
@Component("ruleB")  
public class RuleBHandler extends NodeHandler {  
  
	@RuleB  
	@Autowired  
	private List<? extends INodeComponent> nodeComponents;  
	  
	/**  
	* 处理校验订单以及创建订单信息  
	*  
	* @param requestVO 订单创建入参  
	* @return 订单DO实体类  
	*/  
	@Override  
	public OrderDO handleOrder(OrderCreateRequestVO requestVO) {  
		return super.executeChain(requestVO, nodeComponents);  
	}  
}
