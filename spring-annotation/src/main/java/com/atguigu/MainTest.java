package com.atguigu;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.beans.Person;
import com.atguigu.config.MainConfig;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		ApplicationContext applicationContext =  new ClassPathXmlApplicationContext("bean.xml");
//		Person bean = (Person) applicationContext.getBean("person");
//		System.out.println(bean);
		ApplicationContext applicationContext= new AnnotationConfigApplicationContext(MainConfig.class);
		Person bean = applicationContext.getBean(Person.class);
		System.out.println(bean);
		String[] nameType = applicationContext.getBeanNamesForType(Person.class);
		System.out.println(nameType[0]);
		System.out.println("完成");
		for(String name:nameType) {
			System.out.println(name);
		}
	}

}
