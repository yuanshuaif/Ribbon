package springcloud.ceQualifier;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 10326 on 2020/1/11.
 */
@Configuration
public class configuration {

    @Bean
    @Qualifier
    User getUser1(){
        return new User("lsj");
    }

    @Bean
    @Qualifier
    User getUser2(){
        return new User("lt");
    }

}
