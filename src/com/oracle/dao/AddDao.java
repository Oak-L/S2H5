package com.oracle.dao;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oracle.entity.Customer;
import com.oracle.utils.HibernateUtils;

public class AddDao {
	public Serializable add(Customer customer) {
		Serializable s = null;
		// 获取session
		Session session = null;
		// 事务
		Transaction tx = null;
		try {
			// 使用工具类获取与本地绑定的session
			session = HibernateUtils.getSessionObject();
			// 开启事务
			tx = session.beginTransaction();
			s = session.save(customer);
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			// 事务回滚
			tx.rollback();
		}
		return s;
	}

	public static void main(String[] args) {
	}
}
