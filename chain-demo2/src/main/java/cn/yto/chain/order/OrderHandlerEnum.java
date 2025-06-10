package cn.yto.chain.order;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Objects;

@AllArgsConstructor
public enum OrderHandlerEnum {  
  
	TO_C(1,"ruleA"),  
	TO_B(2, "ruleB");  
	  
	public final Integer orderType;  
	  
	public final String ruleHandler;  
	  
	public static String getRuleHandler(Integer orderType){  
		return Arrays.stream(OrderHandlerEnum.values()).filter(e -> Objects.equals(e.orderType, orderType)).findFirst()
		.orElse(OrderHandlerEnum.TO_C).ruleHandler;  
	}  `
}
