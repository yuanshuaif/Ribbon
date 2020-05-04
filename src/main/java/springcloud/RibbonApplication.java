package springcloud;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@SpringBootApplication
public class RibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonApplication.class, args);
	}

	 //具有负载均衡功能的RestTemplate实例
	//获取服务信息，并且根据IPing判断服务的可用性，根据IRule去路由
	//***给RestTemplate增加拦截器，调用接口之前根据负载均衡策略选择服务地址***
	 @Bean
   	 @LoadBalanced
	 RestTemplate restTemplate() {
       return new RestTemplate();
	 }

//    // 负载均衡策略
////	@Bean
////	public IRule ribbonRule() {
////		return new BestAvailableRule();
////	}

}
