package hu.uni.miskolc.iit.customer.service.impl;

import hu.uni.miskolc.iit.customer.bean.Customer;
import hu.uni.miskolc.iit.customer.dao.CustomerDao;
import hu.uni.miskolc.iit.customer.service.CustomerService;
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

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LogManager
			.getLogger("hu.uni.miskolc.iit.customer.service.impl");

	private CustomerDao customerDao;

	public CustomerServiceImpl(CustomerDao customerDao) {
		if (customerDao == null) {
			throw new IllegalArgumentException(customerDao
					+ " Bean creation error!");
		}
		this.customerDao = customerDao;
	}

	public AddCustomerServiceResponse addCustomer(AddCustomerServiceRequest request) {
		AddCustomerServiceResponse response = new AddCustomerServiceResponse();
		
		if (request == null || request.getCustomer() == null) {
			LOGGER.error("AddCustomerRequest or Customer is null!");
			throw new IllegalArgumentException(
					"Request parameter can't be null!");
		} else {
			customerDao.addCustomer(request.getCustomer());
			response.setMessage("Done");
		}
		
		return response;
	}

	public GetCustomerListServiceReply getCustomerList() {
		GetCustomerListServiceReply reply = new GetCustomerListServiceReply();
		List<Customer> customers = customerDao.getCustomerList();

		reply.setCustomer(customers);
		return reply;
	}

	public CustomerDeleteServiceResponse deleteCustomerById(CustomerDeleteServiceRequest request) {
		CustomerDeleteServiceResponse response = new CustomerDeleteServiceResponse();

		customerDao.deleteCustomerById(request.getId());
		response.setMessage("You have been successfully deleted a customer");
		
		return response;
	}

	public CustomerSearchServiceResponse searchCustomer(CustomerSearchServiceRequest request) {
		return null;
	}

	public CustomerEditServiceResponse editCustomerById(CustomerEditServiceRequest request) {
		CustomerEditServiceResponse response = new CustomerEditServiceResponse();
		Customer customer = request.getCustomer();
		
		if (customer == null) {
			throw new IllegalArgumentException(
					"Customer can't be null!");
		}
		else {
			customerDao.editCustomerById(customer);
			response.setCustomer(customer);
		}
		
		return response;
	}

	public GetCustomerServiceResponse getCustomer() {
		GetCustomerServiceResponse response = new GetCustomerServiceResponse();
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		LOGGER.info("Credentials:" + authentication.getCredentials());
		LOGGER.info("Username:" + authentication.getName());
		LOGGER.info("Authorities:" + authentication.getAuthorities().toString());
		LOGGER.info("Details:" + authentication.getDetails());
		
		Customer customer = customerDao.getCustomer(authentication.getName());
		
		response.setCustomer(customer);
		
		return response;
	}
}
