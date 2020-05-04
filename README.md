1.导包
2.创建主类RibbonApplication
    @EnableDiscoveryClient向服务中心注册，并且注册了一个叫restTemplate的bean。
    (如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient)
    @LoadBalanced注册表明，这个restRemplate是需要做负载均衡的。
    (@LoadBalanced开启负载均衡 就看这个注解)
    这里关键代码就是, restTemplate.getForObject方法会通过ribbon负载均衡机制， 自动选择一个Hello word服务
3.配置文件
    配置Eureka客户端
4.restTemplate.getForObject("http://LSJ-SPRINGBOOT/",String.class);
    这里的URL是“http://SERVICE-HELLOWORLD/"，其中的SERVICE-HELLOWORLD是Hello world服务的名字，
    而注册到服务中心的有两个SERVICE-HELLOWORLD。 所以，
    这个调用本质是ribbon-service作为客户端根据负载均衡算法自主选择了一个作为服务端的SERVICE-HELLOWORLD服务。
    然后再访问选中的SERVICE-HELLOWORLD来执行真正的Hello world调用。
5.@LoadBalance:
    LoadBalancerAutoConfiguration:给有@LoadBalance的restRemplate添加拦截器   (@Qualifier:维护restRemplate列表)（@Qualifier的value不为空时,把类（value指定的值）注入进来;value为空时，把含有@Qualifier注解的注入进来）
    LoadBalancerInterceptor:发送之前，根据服务名称获取服务列表，根据负载均衡算法和负载策略获取具体的服务
    https://blog.csdn.net/xiao_jun_0820/article/details/78917215
Ribbon的负载均衡算法：轮询

该工程用作Sleuth链路中的一环使用：
