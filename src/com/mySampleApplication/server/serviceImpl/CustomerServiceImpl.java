package com.mySampleApplication.server.serviceImpl;

import com.mySampleApplication.client.dto.*;
import com.mySampleApplication.server.dao.CustomerDao;
import com.mySampleApplication.server.model.CustomerInfo;
import com.mySampleApplication.server.model.SystemAdminInfo;
import com.mySampleApplication.server.service.CustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Transactional
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerDao customerDao;

	@Override
	public String deleteCustomerInfo(CustomerInfoDelete customerInfoDelete) {
		List<Integer> ids = customerInfoDelete.getIds();
		customerDao.deleteByPrimarykey(ids);
		return "成功";
	}

	@Override
	public String updateCustomerInfo(CustomerInfoUpdate customerInfoUpdate) {
		CustomerInfo customerInfo = new CustomerInfo();
		BeanUtils.copyProperties(customerInfoUpdate, customerInfo);
		customerDao.updateByPrimaryKey(customerInfo);
		return "成功";
	}

	@Override
	public CustomerInfoSaveDTO saveCustomerInfo(CustomerInfoSave customerInfoSave) {
		CustomerInfo customerInfo = new CustomerInfo();
		BeanUtils.copyProperties(customerInfoSave, customerInfo);
		CustomerInfoSaveDTO response = new CustomerInfoSaveDTO();
		BeanUtils.copyProperties(customerDao.save(customerInfo), response);
		return response;
	}

	@Override
	public List<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery) {
		CustomerInfo customerInfo = new CustomerInfo();
		//对象转化为查询类型的对象
		BeanUtils.copyProperties(customerInfoQuery, customerInfo);
		List<CustomerInfoQueryDTO> response = new ArrayList<>();
		List<CustomerInfo> customerInfoList = customerDao.listByCustomerInfoOr(customerInfo);
		if (customerInfoList != null && !customerInfoList.isEmpty()){
			for (CustomerInfo tmp : customerInfoList){
				CustomerInfoQueryDTO customerInfoQueryDTO = new CustomerInfoQueryDTO();
				BeanUtils.copyProperties(tmp, customerInfoQueryDTO);
				response.add(customerInfoQueryDTO);
			}
			return response;
		} else {
			return null;
		}
	}

	@Override
	public PageInfoDTO<CustomerInfoQueryDTO> listCustomerInfo(CustomerInfoQuery customerInfoQuery, PageInfoDTO<CustomerInfoQueryDTO> pageInfoDTO) {
		CustomerInfo customerInfo = new CustomerInfo();
		BeanUtils.copyProperties(customerInfoQuery, customerInfo);
		List<CustomerInfoQueryDTO> response = new ArrayList<>();
		Map<String, Object> map = customerDao.listByCustomerInfoOr(customerInfo, pageInfoDTO.getPageSize(), pageInfoDTO.getCurrentPage());
		if (map.get("data")==null){
			pageInfoDTO.setTotalNum(0);
			pageInfoDTO.setList(null);
			pageInfoDTO.setCurrentPage(0);
			return pageInfoDTO;
		};
		List<CustomerInfo> customerInfoList = (List<CustomerInfo>) map.get("data");
		pageInfoDTO.setList(null);
		if (customerInfoList != null && !customerInfoList.isEmpty()) {
			for (CustomerInfo tmp : customerInfoList) {
				CustomerInfoQueryDTO customerInfoQueryDTO = new CustomerInfoQueryDTO();
				BeanUtils.copyProperties(tmp, customerInfoQueryDTO);
				response.add(customerInfoQueryDTO);
			}
			pageInfoDTO.setList(response);
			pageInfoDTO.setTotalNum((int) map.get("total"));
//			pageInfoDTO.setTotalPage((int) map.get("total")/pageInfoDTO.getPageSize()+1);
			return pageInfoDTO;
		}
		return null;
	}



}
