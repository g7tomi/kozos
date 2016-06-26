package hu.uni.miskolc.iit.customer.dao.impl;

import hu.uni.miskolc.iit.customer.bean.Customer;
import hu.uni.miskolc.iit.customer.dao.CustomerDao;
import hu.uni.miskolc.iit.customer.dao.mappers.CustomerMapper;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private static final Logger LOGGER = LogManager
			.getLogger("hu.uni.miskolc.iit.customer.dao.impl");

	private CustomerMapper customerMapper;

	public CustomerDaoImpl(CustomerMapper customerMapper) {
		if (customerMapper == null) {
			throw new IllegalArgumentException(customerMapper
					+ " Bean creation error!");
		}
		this.customerMapper = customerMapper;
	}

	public void addCustomer(Customer customer) {
		customerMapper.addCustomer(customer);
	}

	public List<Customer> getCustomerList() {
		return customerMapper.getCustomerList();
	}

	public void deleteCustomerById(int id) {
		customerMapper.deleteCustomerById(id);
	}

	public void editCustomerById(Customer customer) {
		customerMapper.editCustomerById(customer);
	}
}
