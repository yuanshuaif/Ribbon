package springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by 10326 on 2019/4/26.
 */
@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    /*lsj-springboot:服务名称，需要开启负载均衡@LoadBalanced;IP:端口时,不需要添加@LoadBalanced*/
    public String getHelloContent() {
        Map param = new HashMap();
        param.put("str", 20200111);
        return restTemplate.postForObject("http://LSJ-SPRINGBOOT/ces/", param, String.class);
    }
}
