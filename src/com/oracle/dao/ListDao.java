package com.oracle.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oracle.entity.Customer;
import com.oracle.utils.HibernateUtils;

public class ListDao {
	public List<Customer> list() {
		List<Customer> list = null;
		// 获取session
		Session session = null;
		// 事务
		Transaction tx = null;
		try {
			// 使用工具类获取与本地绑定的session
			session = HibernateUtils.getSessionObject();
			// 开启事务
			tx = session.beginTransaction();
			// 根据查询
			// 创建Criteria对象，此方法需要给出实体类名称
			Criteria criteria = session.createCriteria(Customer.class);
			// 调用Criteria方法进行查询
			list = (List<Customer>) criteria.list();
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			// 事务回滚
			tx.rollback();
		}
		return list;
	}

	public static void main(String[] args) {
		List<Customer> list = new ListDao().list();
		for (Customer customer : list) {
			System.out.println(customer.getCid());
		}
	}
}
