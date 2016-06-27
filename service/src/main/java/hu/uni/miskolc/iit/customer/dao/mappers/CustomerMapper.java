package hu.uni.miskolc.iit.customer.dao.mappers;

import hu.uni.miskolc.iit.customer.bean.Customer;

import java.util.List;

public interface CustomerMapper {
	
	public void addCustomer(Customer customer);
	
	public List<Customer> getCustomerList();
	
	public void deleteCustomerById(int id);
	
	public void editCustomerById(Customer customer);
	
	public Customer getCustomer(String username);

}
