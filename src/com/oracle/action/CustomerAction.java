package com.oracle.action;

import java.io.Serializable;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.oracle.dao.AddDao;
import com.oracle.dao.ListDao;
import com.oracle.entity.Customer;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 1 定义list变量，get方法
	private List<Customer> list;

	// 使用模型驱动获取表单数据
	private Customer customer = new Customer();

	public List<Customer> getList() {
		return list;
	}

	public String list() throws Exception {
		// 2 把返回的list放在值栈里
		list = new ListDao().list();
		return "list";
	}

	public String toAdd() throws Exception {
		return "toAdd";
	}

	public String add() throws Exception {
		Serializable s = new AddDao().add(customer);
		System.out.println(s);
		if (s != null) {
			return "yes";
		} else {
			return "no";
		}
	}

	@Override
	public Customer getModel() {
		return customer;
	}
}
