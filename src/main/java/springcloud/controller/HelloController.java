package springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springcloud.service.HelloService;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 10326 on 2019/4/26.
 */
@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;
    @RequestMapping("/hello")
    public String home() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("hello");
//        return null; 测试重试机制专用
        return helloService.getHelloContent();
    }

}
