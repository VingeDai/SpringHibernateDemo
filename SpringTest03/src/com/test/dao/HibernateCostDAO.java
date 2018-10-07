package com.test.dao;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.test.pojo.Cost;

@Repository("hibernateCostDAO")
// @Scope("singleton")// 默认情况是单例
public class HibernateCostDAO extends HibernateDaoSupport implements ICostDao {

	@Resource
	public void setMySessionFactory(SessionFactory sf) {
		// 将注入的sessionFactory，用于实例化template
		super.setSessionFactory(sf);
	}

	@Override
	public List<Cost> findAll() throws DataAccessException {
		String sql = " from Cost";
		List<Cost> list = super.getHibernateTemplate().find(sql);
		return list;
	}

	@Override
	public List<Cost> findByPage(int page, int pageSize) {
		List list = (List) super.getHibernateTemplate().execute(
				new HibernateCallback() {

					@Override
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						String hql = "from Cost";
						Query query = session.createQuery(hql);
						int begin = (page - 1) * pageSize;
						query.setFirstResult(begin);
						query.setMaxResults(pageSize);

						return query.list();
					}
				});

		return list;
	}

	@Override
	public int findTotalPage(int pageSize) throws DataAccessException {
		String hql = "select count(*) from Cost";
		Session session = super.getSession();
		long size = (Long) session.createQuery(hql).uniqueResult();
		session.close();// 一定记得关闭session，使用getHibernateTemplate()会在调用结束后自动关闭session
		if (size % pageSize == 0) {
			return (int) (size / pageSize);
		} else {
			return (int) (size / pageSize + 1);
		}
	}

	@Override
	public void deleteById(Integer id) throws DataAccessException {
		Cost cost = findById(id);
		super.getHibernateTemplate().delete(cost);
	}

	@Override
	public Cost findByName(String feeName) throws DataAccessException {
		String sql = "from Cost where NAME=?";
		Object[] params = { feeName };
		List<Cost> cost = super.getHibernateTemplate().find(sql, params);
		if (cost.isEmpty()) {
			return null;
		}
		return cost.get(0);
	}

	@Override
	public Cost findById(Integer id) throws DataAccessException {
		Cost cost = (Cost) super.getHibernateTemplate().load(Cost.class, id);
		return cost;
	}

	@Override
	public void updateCost(Cost cost) throws DataAccessException {
		super.getHibernateTemplate().update(cost);
	}

}
