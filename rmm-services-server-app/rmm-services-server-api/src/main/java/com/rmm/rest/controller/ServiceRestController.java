package com.rmm.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmm.rest.pojo.CustomerService;
import com.rmm.rest.pojo.ResponseListRmm;
import com.rmm.rest.pojo.ResponseRmm;
import com.rmm.service.dto.CustomerServiceDto;
import com.rmm.service.manage.impl.ManageServiceImpl;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeError;

@RestController
@RequestMapping("/api")
public class ServiceRestController {
	
	
	@GetMapping("/service/{customerId}")
	public ResponseListRmm<CustomerServiceDto> getCustomerDevice(@PathVariable String customerId){
		ManageServiceImpl manageService = new ManageServiceImpl();
		try {
			List<CustomerServiceDto> serviceList = manageService.getServiceByCustomer(customerId);
			ResponseListRmm<CustomerServiceDto> responseRmm = new ResponseListRmm<CustomerServiceDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			responseRmm.setResponseList(serviceList);
			return responseRmm;
		} catch (HandledException e) {
			ResponseListRmm<CustomerServiceDto> responseRmm = new ResponseListRmm<CustomerServiceDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
	}
	
	@PostMapping(path = "/service", consumes = "application/json")
	public ResponseRmm<CustomerServiceDto> addDevice(@RequestBody CustomerService service) {
		ManageServiceImpl manageService = new ManageServiceImpl();
		try {
			CustomerServiceDto customerServiceDto = manageService.addService(service.getService(), service.getIdNumber());
			ResponseRmm<CustomerServiceDto> responseRmm = new ResponseRmm<CustomerServiceDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			responseRmm.setResponse(customerServiceDto);
			return responseRmm;
		} catch (HandledException e) {
			ResponseRmm<CustomerServiceDto> responseRmm = new ResponseRmm<CustomerServiceDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
		
	}
	
	@DeleteMapping("/service/{serviceId}")
	public ResponseRmm<CustomerServiceDto> deleteDevice(@PathVariable int serviceId) {
		ManageServiceImpl manageService = new ManageServiceImpl();
		try {
			manageService.deleteService(serviceId);
			ResponseRmm<CustomerServiceDto> responseRmm = new ResponseRmm<CustomerServiceDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			return responseRmm;
		} catch (HandledException e) {
			ResponseRmm<CustomerServiceDto> responseRmm = new ResponseRmm<CustomerServiceDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
		
	}
}
