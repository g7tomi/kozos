package hu.uni.miskolc.iit.customer.dao;

import hu.uni.miskolc.iit.customer.bean.Customer;

import java.util.List;

public interface CustomerDao {
	
	public void addCustomer(Customer customer);
	
	public List<Customer> getCustomerList();
	
	public void deleteCustomerById(int id);	
	
	public void editCustomerById(Customer customer);
	
	public Customer getCustomer(String username);

}
