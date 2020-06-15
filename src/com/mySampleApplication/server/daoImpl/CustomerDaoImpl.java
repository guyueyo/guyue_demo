package com.mySampleApplication.server.daoImpl;

import com.mySampleApplication.server.dao.CustomerDao;
import com.mySampleApplication.server.model.CustomerInfo;
import com.mySampleApplication.server.model.SystemAdminInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository("customerDao")
@SuppressWarnings("all")
public class CustomerDaoImpl implements CustomerDao {
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}

	@Override
	public void deleteByPrimarykey(List<Integer> ids) {
		String sql = "delete from customer_info where id in (";
		for (Integer id : ids){
			sql += id + ",";
		}
		sql = sql.substring(0, sql.length() -1) + ")";
		this.getCurrentSession().createSQLQuery(sql).executeUpdate();
	}

	@Override
	public void updateByPrimaryKey(CustomerInfo customerInfo) {

		this.getCurrentSession().update(customerInfo);
	}

	@Override
	public CustomerInfo save(CustomerInfo customerInfo) {
		Serializable result = this.getCurrentSession().save(customerInfo);
		customerInfo.setId((Integer)result);
		return customerInfo;
	}

	@Override
	public List<CustomerInfo> listByCustomerInfoOr(CustomerInfo customerInfo) {
		// 条件
		Disjunction disjunction = Restrictions.disjunction();
		if (customerInfo.getCustomerCode() != null && !customerInfo.getCustomerCode().isEmpty()){
			// 客户代码
			Criterion customerCode = Restrictions.eq("customerCode",customerInfo.getCustomerCode());
			disjunction.add(customerCode);
		}
		if (customerInfo.getCustomerName() != null && !customerInfo.getCustomerName().isEmpty()){
			// 客户名称
			Criterion customerName = Restrictions.eq("customerName",customerInfo.getCustomerName());
			disjunction.add(customerName);
		}
		if (customerInfo.getMnemonicCode() != null && !customerInfo.getMnemonicCode().isEmpty()){
			// 助记码
			Criterion mnemonicCode = Restrictions.eq("mnemonicCode",customerInfo.getMnemonicCode());
			disjunction.add(mnemonicCode);
		}
		return this.getCurrentSession().createCriteria(CustomerInfo.class).add(disjunction).list();
	}

	@Override
	public Map<String,Object> listByCustomerInfoOr(CustomerInfo customerInfo, int pageSize, int currentPage) {
		Map<String,Object> map = new HashMap<>();
		Disjunction disjunction = Restrictions.disjunction();
		if (customerInfo.getCustomerCode() != null && !customerInfo.getCustomerCode().isEmpty()){
			// 客户代码
			Criterion customerCode = Restrictions.eq("customerCode",customerInfo.getCustomerCode());
			disjunction.add(customerCode);
		}
		if (customerInfo.getCustomerName() != null && !customerInfo.getCustomerName().isEmpty()){
			// 客户名称
			Criterion customerName = Restrictions.eq("customerName",customerInfo.getCustomerName());
			disjunction.add(customerName);
		}
		if (customerInfo.getMnemonicCode() != null && !customerInfo.getMnemonicCode().isEmpty()){
			// 助记码
			Criterion mnemonicCode = Restrictions.eq("mnemonicCode",customerInfo.getMnemonicCode());
			disjunction.add(mnemonicCode);
		}
		Criteria criteria = this.getCurrentSession().createCriteria(CustomerInfo.class);
		criteria.add(disjunction);
		int total =  Integer.parseInt(criteria.setProjection(Projections.rowCount()).uniqueResult().toString());
		if(total==0){
			map.put("total",total);
			map.put("data",null);
		}
		criteria.setProjection(null);
		criteria.setFirstResult((currentPage-1)*pageSize);
		criteria.setMaxResults(pageSize);
		map.put("total",total);
		map.put("data",criteria.list());
		return map;
	}


}
