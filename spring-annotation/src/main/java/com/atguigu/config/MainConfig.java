package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.atguigu.beans.Person;

/**
 * 
 * @author ArpGalaxy
 * 主配置类
 *
 */
@Configuration
public class MainConfig {
	@Bean(name="personName")
	public Person person() {
		return new Person("zhangsi",20);
	}
}
