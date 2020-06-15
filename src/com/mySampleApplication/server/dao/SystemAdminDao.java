package com.mySampleApplication.server.dao;

import com.mySampleApplication.server.model.SystemAdminInfo;

public interface SystemAdminDao {

    SystemAdminInfo readSystemAdminInoByUsernameOr(SystemAdminInfo systemAdminInfo);

    Boolean saveSystemAdminInfo(SystemAdminInfo systemAdminInfo);
}
