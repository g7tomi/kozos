package hu.uni.miskolc.iit.customer.controller;

import hu.uni.miskolc.iit.customer.facade.CustomerFacade;
import hu.uni.miskolc.iit.customer.facade.bean.AddCustomerFacadeRequest;
import hu.uni.miskolc.iit.customer.facade.bean.AddCustomerFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerDeleteFacadeRequest;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerDeleteFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerEditFacadeRequest;
import hu.uni.miskolc.iit.customer.facade.bean.CustomerEditFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.GetCustomerFacadeResponse;
import hu.uni.miskolc.iit.customer.facade.bean.GetCustomerListFacadeReply;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = { "/admin" })
public class AdminController {
	
	private static final Logger LOGGER = LogManager
			.getLogger("hu.uni.miskolc.iit.customer.controller");

	private CustomerFacade customerFacade;
	
	public AdminController(CustomerFacade customerFacade) {
		if (customerFacade == null) {
			throw new IllegalArgumentException(customerFacade + " Bean creation error!");
		}
		this.customerFacade = customerFacade;
	}
	
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody AddCustomerFacadeResponse addCustomer(
			@RequestBody AddCustomerFacadeRequest request) {
		return customerFacade.addCustomer(request);
	}

	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody GetCustomerListFacadeReply getCustomerList() {
		return customerFacade.getCustomerList();
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8")
	public @ResponseBody CustomerDeleteFacadeResponse deleteCustomerById(@RequestBody CustomerDeleteFacadeRequest request) {
		return customerFacade.deleteCustomerById(request);
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.POST, headers = "Accept=application/json; charset=utf-8" ) 
	public @ResponseBody CustomerEditFacadeResponse editCustomer(@RequestBody CustomerEditFacadeRequest request) {
		return customerFacade.editCustomerById(request);
	}
	
	@RequestMapping(value = "/customer", method = RequestMethod.GET,  headers = "Accept=application/json; charset=utf-8" )
	public @ResponseBody GetCustomerFacadeResponse getCustomer() {
		return customerFacade.getCustomer();
	}

}
