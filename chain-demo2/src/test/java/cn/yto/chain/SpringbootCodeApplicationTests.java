package cn.yto.chain;

import cn.yto.chain.order.OrderFactory;
import cn.yto.chain.order.OrderHandlerEnum;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootTest
public class SpringbootCodeApplicationTests {  
  
	@Autowired
	private OrderFactory orderFactory;
	  
	@Test  
	void testOrderCreate() {  
		final OrderCreateRequestVO requestVO = new OrderCreateRequestVO();  
		requestVO.setOrderNo("11111");  
		requestVO.setOrderType(OrderHandlerEnum.TO_C.orderType);
		requestVO.setUserId("coderacademy");  
		requestVO.setUserName("码农Academy");  
		  
		final OrderDO orderDO = orderFactory.createOrder(requestVO);  
		System.out.println(orderDO.getOrderId());  
	  
	}  
}

