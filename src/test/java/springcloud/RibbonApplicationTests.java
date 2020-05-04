package springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springcloud.ceQualifier.User;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RibbonApplicationTests {

	/**
	 * @Qualifier的value不为空时,把类（value指定的值）注入进来;value为空时，把含有@Qualifier注解的注入进来
	 */
	@Autowired
	@Qualifier
	private List<User> users;
	@Test
	public void contextLoads() {
		System.out.println(users);
	}

}
