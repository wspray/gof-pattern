package cn.yto.chain.order;

public interface INodeComponent{
  
/**  
* 定义所有数据处理节点的接口  
* @param orderContext 数据上下文  
* @param orderParam 数据处理入参参数  
*/  
  
void handleData(OrderContext orderContext, OrderParam orderParam);  
}
