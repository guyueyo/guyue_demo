package com.mySampleApplication.server.serviceImpl;

import com.mySampleApplication.client.dto.SystemAdminInfoQuery;
import com.mySampleApplication.client.dto.SystemAdminInfoQueryDTO;
import com.mySampleApplication.client.dto.SystemAdminInfoSave;
import com.mySampleApplication.server.dao.SystemAdminDao;
import com.mySampleApplication.server.model.SystemAdminInfo;
import com.mySampleApplication.server.service.SystemAdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("systemAdminService")
public class SystemAdminServiceImpl implements SystemAdminService {
    @Autowired
    private SystemAdminDao systemAdminDao;

    @Override
    public SystemAdminInfoQueryDTO readSystemAdminInfo(SystemAdminInfoQuery systemAdminInfoQuery) {
        SystemAdminInfo systemAdminInfo = new SystemAdminInfo();
        BeanUtils.copyProperties(systemAdminInfoQuery,systemAdminInfo);
        SystemAdminInfoQueryDTO systemAdminInfoQueryDTO = new SystemAdminInfoQueryDTO();
        SystemAdminInfo systemAdminInfoDTO = systemAdminDao.readSystemAdminInoByUsernameOr(systemAdminInfo);
        if(systemAdminInfoDTO!=null) BeanUtils.copyProperties(systemAdminInfoDTO,systemAdminInfoQueryDTO);
        return systemAdminInfoQueryDTO;
    }

    @Override
    public Boolean saveSystemAdminInfo(SystemAdminInfoSave systemAdminInfoSave) {
        SystemAdminInfo systemAdminInfo = new SystemAdminInfo();
        BeanUtils.copyProperties(systemAdminInfoSave,systemAdminInfo);
        return systemAdminDao.saveSystemAdminInfo(systemAdminInfo);
    }

}
