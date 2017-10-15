package com.oracle.interceptor;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * 
 * 拦截器类
 * 
 * @author L
 *
 */
public class LoginInterceptor extends MethodFilterInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 这个方法里面写拦截器的逻辑
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		// 判断session里面是否有名称是username的值
		// 得到session
		if (ServletActionContext.getRequest().getSession().getAttribute("user") != null) {
			// 登录状态
			// 做类似放行的操作
			return invocation.invoke();
		} else {
			// 没有登录
			// 不执行action方法，返回登录页面
			return "loginFail";
		}
	}
}