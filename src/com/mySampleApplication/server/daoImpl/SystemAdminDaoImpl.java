package com.mySampleApplication.server.daoImpl;

import com.mySampleApplication.server.dao.SystemAdminDao;
import com.mySampleApplication.server.model.SystemAdminInfo;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("systemAdminDao")
@SuppressWarnings("all")
public class SystemAdminDaoImpl implements SystemAdminDao {
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
    public SystemAdminInfo selectSystemAdminInoByUsernameOr(SystemAdminInfo systemAdminInfo) {
        Conjunction conjunction = Restrictions.conjunction();
        if(systemAdminInfo.getUsername() !=null && !systemAdminInfo.getUsername().isEmpty()) conjunction.add(Restrictions.eq("username",systemAdminInfo.getUsername()));
        if(systemAdminInfo.getPassword() !=null && !systemAdminInfo.getPassword().isEmpty()) conjunction.add(Restrictions.eq("password",systemAdminInfo.getPassword()));
        Criteria criteria = this.getCurrentSession().createCriteria(SystemAdminInfo.class);
        List<SystemAdminInfo> list = criteria.add(conjunction).list();
        if(list!=null && list.size()>0)return list.get(0);
        return null;
    }

    @Override
    public Boolean creatSystemAdminInfo(SystemAdminInfo systemAdminInfo) {
        this.getCurrentSession().save(systemAdminInfo);
        return true;
    }

}
