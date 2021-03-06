package com.mySampleApplication.server.service;

import com.mySampleApplication.client.dto.SystemAdminInfoQuery;
import com.mySampleApplication.client.dto.SystemAdminInfoQueryDTO;
import com.mySampleApplication.client.dto.SystemAdminInfoSave;


public interface SystemAdminService {
    SystemAdminInfoQueryDTO readSystemAdminInfo(SystemAdminInfoQuery systemAdminInfoQuery);

    Boolean saveSystemAdminInfo(SystemAdminInfoSave systemAdminInfoSave);

}
