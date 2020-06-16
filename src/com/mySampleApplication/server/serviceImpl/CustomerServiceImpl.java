package com.mySampleApplication.server.serviceImpl;

import com.mySampleApplication.client.dto.*;
import com.mySampleApplication.server.dao.CustomerDao;
import com.mySampleApplication.server.model.CustomerInfo;
import com.mySampleApplication.server.model.SystemAdminInfo;
import com.mySampleApplication.server.service.CustomerService;
import com.sencha.gxt.data.shared.loader.PagingLoadConfig;
import com.sencha.gxt.data.shared.loader.PagingLoadResult;
import com.sencha.gxt.data.shared.loader.PagingLoadResultBean;
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

	@Override
	public PagingLoadResult<com.mySampleApplication.client.model.CustomerInfo> listCustomerInfoLimit(CustomerInfoQuery customerInfoQuery,PagingLoadConfig pagingLoadConfig) {
		CustomerInfo customerInfoQ = new CustomerInfo();
		BeanUtils.copyProperties(customerInfoQuery, customerInfoQ);
		List<CustomerInfo> customerInfoList = customerDao.listByCustomerInfo(customerInfoQ,pagingLoadConfig);

		List<com.mySampleApplication.client.model.CustomerInfo> response = new ArrayList<>();
		if (customerInfoList != null && !customerInfoList.isEmpty()){
			for (CustomerInfo tmp : customerInfoList){
				com.mySampleApplication.client.model.CustomerInfo customerInfo = new com.mySampleApplication.client.model.CustomerInfo();
				BeanUtils.copyProperties(tmp, customerInfo);
				response.add(customerInfo);
			}
			int totalNum = customerDao.countListByCustomer(customerInfoQ);
			return new PagingLoadResultBean<com.mySampleApplication.client.model.CustomerInfo>(response,totalNum,pagingLoadConfig.getOffset());
		} else {
			return null;
		}
	}

    @Override
    public PagingLoadResult<com.mySampleApplication.client.model.CustomerInfo> listCustomerInfo(int offset,int limit) {
        CustomerInfo customerInfoQuery = new CustomerInfo();
		List<CustomerInfo> customerInfoList = customerDao.listByCustomerInfoOr(customerInfoQuery);
		List<com.mySampleApplication.client.model.CustomerInfo> response = new ArrayList<>();
		if(customerInfoList!=null && !customerInfoList.isEmpty()){
			for (int i =0;i<limit;i++){
				if(i+offset<customerInfoList.size()) {
					CustomerInfo tmp = customerInfoList.get(i + offset);
					com.mySampleApplication.client.model.CustomerInfo customerInfo = new com.mySampleApplication.client.model.CustomerInfo();
					BeanUtils.copyProperties(tmp, customerInfo);
					response.add(customerInfo);
				}
			}
            return new PagingLoadResultBean<com.mySampleApplication.client.model.CustomerInfo>(response,customerInfoList.size(),offset);
        } else {
            return null;
        }
    }


}
