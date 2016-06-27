package hu.uni.miskolc.iit.customer.facade.impl;

import hu.uni.miskolc.iit.customer.facade.CustomerFacade;
import hu.uni.miskolc.iit.customer.facade.bean.AddCustomerFacadeRequest;
import hu.uni.miskolc.iit.customer.facade.bean.AddCustomerFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerDeleteFacadeRequest;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerDeleteFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerEditFacadeRequest;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerEditFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerSearchFacadeRequest;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerSearchFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.GetCustomerFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.GetCustomerListFacadeReply;
import hu.uni.miskolc.iit.customer.service.CustomerService;
import hu.uni.miskolc.iit.customer.service.bean.AddCustomerServiceRequest;
import hu.uni.miskolc.iit.customer.service.bean.AddCustomerServiceResponse;
import hu.uni.miskolc.iit.customer.service.bean.CustomerDeleteServiceRequest;
import hu.uni.miskolc.iit.customer.service.bean.CustomerDeleteServiceResponse;
import hu.uni.miskolc.iit.customer.service.bean.CustomerEditServiceRequest;
import hu.uni.miskolc.iit.customer.service.bean.CustomerEditServiceResponse;
import hu.uni.miskolc.iit.customer.service.bean.GetCustomerListServiceReply;
import hu.uni.miskolc.iit.customer.service.bean.GetCustomerServiceResponse;
import hu.uni.miskolc.iit.email.service.EmailService;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.annotation.Secured;

public class CustomerFacadeImpl implements CustomerFacade {
	
	private static final Logger LOGGER = LogManager
			.getLogger("hu.uni.miskolc.iit.customer.facade.impl");
	
	private CustomerService customerService;
	private EmailService emailService;
	
	public CustomerFacadeImpl(CustomerService customerService, EmailService emailService) {
		if (customerService == null) {
			throw new IllegalArgumentException(customerService + " Bean creation error!");
		}
		if (emailService == null) {
			throw new IllegalArgumentException(emailService + " Bean creation error!");
		}
		
		this.customerService = customerService;
		this.emailService = emailService;
	}

	@Secured({ "ROLE_ADMIN"})
	public AddCustomerFacadeResponse addCustomer(AddCustomerFacadeRequest request) {
		AddCustomerServiceRequest serviceRequest = new AddCustomerServiceRequest();
		AddCustomerFacadeResponse facadeResponse = new AddCustomerFacadeResponse();
		
		BeanUtils.copyProperties(request, serviceRequest);
		AddCustomerServiceResponse serviceResponse = customerService.addCustomer(serviceRequest);
		BeanUtils.copyProperties(serviceResponse, facadeResponse);
		
		return facadeResponse;
	}

	@Secured({ "ROLE_ADMIN"})
	public GetCustomerListFacadeReply getCustomerList() {
		GetCustomerListFacadeReply facadeReply = new GetCustomerListFacadeReply();
		GetCustomerListServiceReply getCustomerListServiceReply = customerService.getCustomerList();
		
		BeanUtils.copyProperties(getCustomerListServiceReply, facadeReply);
		
		return facadeReply;
	}

	@Secured({ "ROLE_ADMIN"})
	public CustomerDeleteFacadeResponse deleteCustomerById(CustomerDeleteFacadeRequest request) {
		CustomerDeleteFacadeResponse customerDeleteFacadeResponse = new CustomerDeleteFacadeResponse();
		CustomerDeleteServiceRequest serviceRequest = new CustomerDeleteServiceRequest();
		
		BeanUtils.copyProperties(request, serviceRequest);
		CustomerDeleteServiceResponse serviceResponse = customerService.deleteCustomerById(serviceRequest);
		BeanUtils.copyProperties(serviceResponse, customerDeleteFacadeResponse);
		
		return customerDeleteFacadeResponse;
	}

	@Secured({ "ROLE_ADMIN"})
	public CustomerEditFacadeResponse editCustomerById(CustomerEditFacadeRequest request) {
		CustomerEditFacadeResponse facadeResponse = new CustomerEditFacadeResponse();
		CustomerEditServiceRequest serviceRequest = new CustomerEditServiceRequest();
		
		BeanUtils.copyProperties(request, serviceRequest);
		
		CustomerEditServiceResponse customerEditServiceResponse = customerService.editCustomerById(serviceRequest);
		
		BeanUtils.copyProperties(customerEditServiceResponse, facadeResponse);
		
		emailService.sendEditNotification(request.getCustomer());
		
		return facadeResponse;
	}
	
	public CustomerSearchFacadeResponse searchCustomer(CustomerSearchFacadeRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	public GetCustomerFacadeResponse getCustomer() {
		GetCustomerFacadeResponse facadeResponse = new GetCustomerFacadeResponse();
		GetCustomerServiceResponse serviceResponse = customerService.getCustomer();
		
		BeanUtils.copyProperties(serviceResponse, facadeResponse);
		
		return facadeResponse;
	}


}
