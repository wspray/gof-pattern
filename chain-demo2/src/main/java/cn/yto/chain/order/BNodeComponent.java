package cn.yto.chain.order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RuleB 
@Order(1)
public class BNodeComponent implements INodeComponent {
	log.info("RuleB流程执行处理业务节点B");  
	final List<String> executeRuleList = Optional.ofNullable(orderContext.getExecuteRuleList()).orElse(new ArrayList<>());
	executeRuleList.add("BNodeComponent");
	orderContext.setExecuteRuleList(executeRuleList);  
	orderContext.setOrderId("TOB11111");
}

@Slf4j  
@Component  
@RuleA  
@RuleB  
@Order(10)
public class CNodeComponent implements INodeComponent {
	// 省略具体的业务处理逻辑
}

@Slf4j  
@Component  
@RuleB  
@Order(20)
public class ENodeComponent implements INodeComponent {
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
