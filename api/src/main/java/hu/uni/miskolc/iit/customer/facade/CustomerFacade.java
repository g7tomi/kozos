package hu.uni.miskolc.iit.customer.facade;

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

public interface CustomerFacade {

public AddCustomerFacadeResponse addCustomer(AddCustomerFacadeRequest request);
	
	public GetCustomerListFacadeReply getCustomerList();
	
	public CustomerDeleteFacadeResponse deleteCustomerById(CustomerDeleteFacadeRequest request);
	
	public CustomerSearchFacadeResponse searchCustomer(CustomerSearchFacadeRequest request);
	
	public CustomerEditFacadeResponse editCustomerById(CustomerEditFacadeRequest request);
	
	public GetCustomerFacadeResponse getCustomer();
}
