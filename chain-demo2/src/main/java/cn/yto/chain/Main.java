package cn.yto.chain;
//@Qualifier
//@Target({ElementType.METHOD, ElementType.TYPE})
//@Retention(RetentionPolicy.RUNTIME)
//public @interface RuleA {
//}
//
//@Component
//@RuleA
//@Order(20)
//public class DNodeComponent implements INodeComponent {
//	// 省略具体的业务处理逻辑
//}
//
//@Slf4j
//@Component
//@RuleA
//@Order(30)
//public class FNodeComponent implements INodeComponent {
//	// 省略具体的业务处理逻辑
//}
//
//@RuleA
//@Autowired
//private List<? extends INodeComponent> nodeComponents;
//
//在Spring框架中，@Qualifier注解用于指定要注入的具体bean的名称。
//当一个接口或抽象类有多个实现类时，通过@Qualifier注解可以明确告诉Spring框架要注入哪一个实现类。
//
//自定义注解与@Qualifier结合使用的含义在于，你可以通过自定义注解为特定的实现类分组，
//并在使用@Qualifier时引用这个自定义注解。这样做的主要目的是提高代码的可读性和可维护性，使得注入的意图更加清晰。


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}