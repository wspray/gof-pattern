package cn.yto.chain.order;

import lombok.Data;

import java.util.List;

@Data
public class OrderContext {

    private String orderId;

    private List<String> executeRuleList;
}
