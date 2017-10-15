package com.oracle.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.oracle.entity.User;
import com.oracle.utils.HibernateUtils;

public class LoginDao {
	public User login(String name, String word) {
		User user = null;
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
			Query q = session.createQuery("from User where username=?");
			q.setParameter(0, name);
			List<User> list = q.list();
			for (User u : list) {
				if (u.getUsername().equals(name)) {
					if (u.getPassword().equals(word)) {
						user = u;
					}
				}
			}
			// 提交事务
			tx.commit();
		} catch (Exception e) {
			// 事务回滚
			tx.rollback();
		}
		return user;
	}

	public static void main(String[] args) {
		User u = new LoginDao().login("admin", "admi1n");
		if (u != null) {
			System.out.println(u.getUid());
		} else {
			System.out.println("null");
		}
	}
}
