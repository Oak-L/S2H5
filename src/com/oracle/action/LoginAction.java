package com.oracle.action;

import com.opensymphony.xwork2.ActionSupport;
import com.oracle.dao.LoginDao;
import com.oracle.entity.User;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

public class LoginAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new LoginDao().login(username, password);
		if (user != null) {
			// 向session里面放值
			request.getSession().setAttribute("user", user);
			return "loginSuccess";
		} else {
			request.setAttribute("msg", "登录失败，用户名或密码错误");
			return "loginFail";
		}
	}
}
