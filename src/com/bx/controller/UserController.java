package com.bx.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bx.entity.PageBean;
import com.bx.entity.User;
import com.bx.service.UserService;
import com.bx.util.ResponseUtil;
import com.bx.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @date 2016年3月27日 UserController.java
 * @author CZP
 * @parameter
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserService userService;

	@RequestMapping("/modifyPassword")
	public void modifyPassword(User user, String id, String newPassword, HttpServletResponse response) {
		int num = 0;
		JSONObject jsonObject = new JSONObject();
		user.setPassword(newPassword);
		Map<String, Object> map = new HashMap<>();
		map.put("id", Integer.parseInt(id));
		map.put("newPassword", newPassword);
		// 由于spring中配置的事务 有一条为
		// <tx:method name="*" propagation="REQUIRED" read-only="true" />
		// 与modifyPassword()方法名匹配 所以只能 只读
		// 所以会报connection is readonly...错误
		// 解决办法 修改方法名 让他与 <tx:method name="update*" propagation="REQUIRED" /> 匹配
		num = userService.updateModifyPassword(map);
		// num=userService.update(user);
		if (num > 0) {
			jsonObject.put("success", true);
		} else {
			jsonObject.put("success", false);
		}
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		// 一定要加 / 表示是 系统的根目录
		// 因为 login.jsp是在根目录下 不加的话会报404错误
		return "redirect:/login.jsp";
	}

	@RequestMapping("/login")
	public String login(User user, HttpServletRequest request) {
		User u = userService.login(user);
		if (u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", u);
			return "redirect:/main.jsp";
		} else {
			request.setAttribute("user", u);
			request.setAttribute("errorMsg", "用户名或密码错误");
			return "login";
		}
	}

	@RequestMapping("/customerManagerComboList")
	public void customerManagerComboList(HttpServletResponse response) {
		Map<String, Object> map = new HashMap<>();
		map.put("roleName", StringUtil.formatLike("客户经理"));
		List<User> userList = userService.find(map);
		JSONArray jsonArray = JSONArray.fromObject(userList);
		// 直接输出，不需要再装入jsonObject
		try {
			ResponseUtil.write(response, jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/list")
	// 两种都行
	// public String list(String page,String rows,User
	// s_user,HttpServletResponse response){
	public void list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, HttpServletResponse response, User s_user) {

		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getSize());
		List<User> userList = userService.find(map);
		long total = userService.getTotal(map);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(userList);
		jsonObject.put("rows", jsonArray);
		jsonObject.put("total", total);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/save")
	public String save(User user, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		int num;
		if (user.getId() != null) {
			num = userService.update(user);
		} else {
			num = userService.add(user);
		}
		if (num > 0) {
			jsonObject.put("success", true);
		} else {
			jsonObject.put("success", false);
		}
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/delete")
	public void delete(String ids, HttpServletResponse response) {
		JSONObject jsonObject = new JSONObject();
		String[] id = ids.split(",");
		for (int i = 0; i < id.length; i++) {
			userService.delete(Integer.parseInt(id[i]));
		}
		jsonObject.put("success", true);
		try {
			ResponseUtil.write(response, jsonObject);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
