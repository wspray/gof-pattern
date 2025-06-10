package cn.yto.chain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RuleA
@Order(1)
public class ANodeComponent implements INodeComponent {
	@Override  
public void handleData(OrderContext orderContext, OrderParam orderParam) {  
	log.info("RuleA流程执行处理业务节点A");  
	final List<String> executeRuleList = Optional.ofNullable(orderContext.getExecuteRuleList()).orElse(new ArrayList<>());
	executeRuleList.add("ANodeComponent");  
	orderContext.setExecuteRuleList(executeRuleList);  
	// 不同类型订单，订单号不同，可在节点中个处理
	orderContext.setOrderId("TOC11111");
	}
}

@Slf4j  
@Component  
@RuleA  
@RuleB  
@Order(10)
public class CNodeComponent implements INodeComponent {
    @Override
    public void handleData(OrderContext orderContext, OrderParam orderParam) {

    }
    // 省略具体的业务处理逻辑
}

@Slf4j
@Component  
@RuleA  
@Order(20)
public class DNodeComponent implements INodeComponent {
	// 省略具体的业务处理逻辑
}	

@Slf4j  
@Component  
@RuleA  
@Order(30)
public class FNodeComponent implements INodeComponent {
	// 省略具体的业务处理逻辑
}

@Slf4j  
@Component  
@RuleA  
@RuleB 
@Order(40)
public class HNodeComponent implements INodeComponent {
	// 省略具体的业务处理逻辑
}
