package junit.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.atcrowdfunding.bean.TUser;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.MD5Util;

public class Test04 {
 	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("spring/spring*.xml");
		UserService userService = ioc.getBean(UserService.class);
		
		for (int i = 1; i <= 100; i++) {
			TUser tUser = new TUser();
			tUser.setLoginacct("test"+i);
			tUser.setUserpswd(MD5Util.digest("123"));
			tUser.setUsername("test"+i);
			tUser.setEmail("test"+i+"@163.com");
			tUser.setCreatetime("2018-12-11 22:00:00");
			userService.saveUser(tUser);
		}
	}
}
