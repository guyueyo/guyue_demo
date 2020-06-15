package com.mySampleApplication.server.dao;

import com.mySampleApplication.server.model.SystemAdminInfo;

public interface SystemAdminDao {

    SystemAdminInfo selectSystemAdminInoByUsernameOr(SystemAdminInfo systemAdminInfo);

    Boolean creatSystemAdminInfo(SystemAdminInfo systemAdminInfo);
}
