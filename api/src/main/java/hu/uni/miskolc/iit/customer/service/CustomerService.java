package hu.uni.miskolc.iit.customer.service;

import hu.uni.miskolc.iit.customer.service.bean.AddCustomerServiceRequest;
import hu.uni.miskolc.iit.customer.service.bean.AddCustomerServiceResponse;
import hu.uni.miskolc.iit.customer.service.bean.CustomerDeleteServiceRequest;
import hu.uni.miskolc.iit.customer.service.bean.CustomerDeleteServiceResponse;
import hu.uni.miskolc.iit.customer.service.bean.CustomerEditServiceRequest;
import hu.uni.miskolc.iit.customer.service.bean.CustomerEditServiceResponse;
import hu.uni.miskolc.iit.customer.service.bean.CustomerSearchServiceRequest;
import hu.uni.miskolc.iit.customer.service.bean.CustomerSearchServiceResponse;
import hu.uni.miskolc.iit.customer.service.bean.GetCustomerListServiceReply;
import hu.uni.miskolc.iit.customer.service.bean.GetCustomerServiceResponse;


public interface CustomerService {
	
	public AddCustomerServiceResponse addCustomer(AddCustomerServiceRequest request);
	
	public GetCustomerListServiceReply getCustomerList();
	
	public CustomerDeleteServiceResponse deleteCustomerById(CustomerDeleteServiceRequest request);
	
	public CustomerSearchServiceResponse searchCustomer(CustomerSearchServiceRequest request);
	
	public CustomerEditServiceResponse editCustomerById(CustomerEditServiceRequest request);
	
	public GetCustomerServiceResponse getCustomer();
}
