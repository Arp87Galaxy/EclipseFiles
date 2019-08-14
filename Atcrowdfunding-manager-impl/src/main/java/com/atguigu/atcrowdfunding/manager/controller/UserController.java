package com.atguigu.atcrowdfunding.manager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.atcrowdfunding.bean.TUser;
import com.atguigu.atcrowdfunding.manager.service.UserService;
import com.atguigu.atcrowdfunding.util.AjaxResult;
import com.atguigu.atcrowdfunding.util.Page;
import com.atguigu.atcrowdfunding.util.StringUtil;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/toIndex")
	public String toIindex() {

		return "user/index";

	}

	@RequestMapping("/toAdd")
	public String toAdd() {

		return "user/add";

	}

	@RequestMapping("/add")
	@ResponseBody
	public Object add(TUser tUser) {
		AjaxResult result = new AjaxResult();
		try {
			int count = userService.saveUser(tUser);
			result.setSuccess(count == 1);
			result.setMessage("保存成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("保存失败");
		}

		return result;

	}

	@RequestMapping("/queryUser")
	@ResponseBody
	public Object queryUser(TUser tUser) {
		AjaxResult result = new AjaxResult();
		try {

			TUser user = userService.queryUser(tUser);
			result.setPojo(user);
			result.setSuccess(true);
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("查询失败");
		}

		return result;

	}

	@RequestMapping("/modifyUser")
	@ResponseBody
	public Object modifyUser(TUser tUser) {
		AjaxResult result = new AjaxResult();
		try {

			int status = userService.modifyUser(tUser);
			result.setSuccess(status == 1);
			result.setMessage("修改数据成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("修改数据失败");
		}

		return result;

	}

	@RequestMapping("/deleteUser")
	@ResponseBody
	public Object deleteUser(TUser tUser) {
		AjaxResult result = new AjaxResult();
		try {
			int count = userService.deleteUser(tUser);
			result.setSuccess(count == 1);
			result.setMessage("删除用户成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("删除用户失败");
		}

		return result;

	}

	@RequestMapping("/deleteBatchUser")
	@ResponseBody
	public Object deleteBatchUser(Integer[] arrayId) {
		AjaxResult result = new AjaxResult();
		try {
			int status = userService.deleteBatchUser(arrayId);
			System.out.println(status);
			System.out.println(status==arrayId.length);
			result.setSuccess(status==arrayId.length);
			result.setMessage("删除成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("删除失败");
		}

		return result;


	}

	@RequestMapping("/index")
	@ResponseBody
	public Object index(@RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageno,
			@RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pagesize,
			String queryText) {
		AjaxResult result = new AjaxResult();
		try {

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("pageno", pageno);
			paramMap.put("pagesize", pagesize);

			if (StringUtil.isNotEmpty(queryText)) {
				paramMap.put("queryText", queryText);
			}
			Page page = userService.queryPage(paramMap);

			result.setSuccess(true);
			result.setPage(page);
			result.setMessage("查询成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			result.setSuccess(false);
			e.printStackTrace();
			result.setMessage("查询失败");
		}

		return result;

	}

//	同步查询
//	@RequestMapping("/index")
//	public String index(@RequestParam(value="pageno",required=false,defaultValue="1")Integer pageno,
//						@RequestParam(value="pagesize",required=false,defaultValue="10")Integer pagesize,
//						Map<String,Object> map) {
//		Page page = userService.queryPage(pageno,pagesize);
//		map.put("page",page);
//		return "user/index";
//		
//	}

}
