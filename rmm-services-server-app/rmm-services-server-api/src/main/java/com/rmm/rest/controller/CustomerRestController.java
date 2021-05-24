package com.rmm.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rmm.rest.pojo.ResponseListRmm;
import com.rmm.service.dto.BillDto;
import com.rmm.service.manage.impl.ManageCustomerImpl;
import com.rmm.util.exception.HandledException;
import com.rmm.util.types.TypeError;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	
	@GetMapping("/monthlyBill/{customerId}")
	public ResponseListRmm<BillDto> getMonthlyBill(@PathVariable String customerId){
		ManageCustomerImpl manageCustomer = new ManageCustomerImpl();
		try {
			List<BillDto> billDtoList = manageCustomer.getMonthly(customerId);
			ResponseListRmm<BillDto> responseRmm = new ResponseListRmm<BillDto>();
			responseRmm.setCodError(TypeError.OK.getErrorCode());
			responseRmm.setDescError(TypeError.OK.getErrorDesc());
			responseRmm.setResponseList(billDtoList);
			return responseRmm;
		} catch (HandledException e) {
			ResponseListRmm<BillDto> responseRmm = new ResponseListRmm<BillDto>();
			responseRmm.setCodError(e.getCode());
			responseRmm.setDescError(e.getMessage());
			return responseRmm;
		}
	}
}
