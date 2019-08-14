package com.atguigu.atcrowdfunding.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.TUser;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.AjaxResult;
import com.atguigu.atcrowdfunding.util.Const;
import com.atguigu.atcrowdfunding.util.MD5Util;

@Controller
public class DispatcherController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(Map<String,String> map) {
		map.put("hello", "hello index");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		return "login";
	}
	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		session.invalidate();

		return "redirect:/index.htm";
	}
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@RequestMapping("/doLogin")
	@ResponseBody
//	异步登录 根据ajax的data属性去参数，元素name属性可以不写
//	同步@RequestParam(value="loginacct")当参数名不同于表单name时可用这个设置参数value值要同于表单值。如果不设置只需参数名与表单name相同即可自动识别
	public Object doLogin(String loginacct, String userpswd, String type,HttpSession session) {
		AjaxResult result = new AjaxResult();
		
		try {
			Map<String,Object> paramMap = new HashMap<String,Object>();
			paramMap.put("loginacct",loginacct);
			paramMap.put("userpswd", MD5Util.digest(userpswd));
			paramMap.put("type", type);
			
			TUser tUser = userService.queryUserLogin(paramMap);
			session.setAttribute(Const.LOGIN_USER, tUser);
			result.setSuccess(true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setMessage("登录异常");
			e.printStackTrace();
			result.setSuccess(false);
		}
		return result;
	}
	
//	@RequestMapping("/doLogin")
//	同步登录
//	@RequestParam(value="loginacct")当参数名不同于表单name时可用这个设置参数value值要同于表单值。如果不设置只需参数名与表单name相同即可自动识别
//	public String doLogin(String loginacct, String userpswd, String type,HttpSession session) {
//		Map<String,Object> paramMap = new HashMap<String,Object>();
//		paramMap.put("loginacct",loginacct);
//		paramMap.put("userpswd", userpswd);
//		paramMap.put("type", type);
//		
//		TUser tUser = userService.queryUserLogin(paramMap);
//		session.setAttribute(Const.LOGIN_USER, tUser);
//		return "redirect:/main.htm";
//	}
}
