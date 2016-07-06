package cn.itcast.oa.test;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.oa.domain.User;

@Service("testService")
public class TestService {

	@Resource
	private SessionFactory sessionFactory;

	@Transactional
	public void saveTwoUsers() {
		Session session = sessionFactory.getCurrentSession();
		session.save(new User());
		// int a = 1 / 0; // 这行会抛异常
		session.save(new User());
	}

	@Transactional
	public void saveUsers_23() {
		Session session = sessionFactory.getCurrentSession();

		for (int i = 1; i < 23; i++) {
			User user = new User();
			user.setName("测试-" + i);
			session.save(user);
		}
	}
}
