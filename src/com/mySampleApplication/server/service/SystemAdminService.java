package com.mySampleApplication.server.service;

import com.mySampleApplication.client.dto.SystemAdminInfoQuery;
import com.mySampleApplication.client.dto.SystemAdminInfoQueryDTO;
import com.mySampleApplication.client.dto.SystemAdminInfoSave;


public interface SystemAdminService {
    SystemAdminInfoQueryDTO querySystemAdminInfo(SystemAdminInfoQuery systemAdminInfoQuery);

    Boolean creatSystemAdminInfo(SystemAdminInfoSave systemAdminInfoSave);

}
