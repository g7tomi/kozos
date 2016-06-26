//package hu.uni.miskolc.iit.customer.service.test;
//
//import static org.junit.Assert.assertEquals;
//import hu.uni.miskolc.iit.customer.bean.Customer;
//import hu.uni.miskolc.iit.customer.dao.CustomerDao;
//import hu.uni.miskolc.iit.customer.service.CustomerService;
//import hu.uni.miskolc.iit.customer.service.bean.AddCustomerRequest;
//import hu.uni.miskolc.iit.customer.service.bean.AddCustomerResponse;
//import hu.uni.miskolc.iit.customer.service.bean.GetCustomerListReply;
//import hu.uni.miskolc.iit.customer.service.impl.CustomerServiceImpl;
//import hu.uni.miskolc.iit.email.service.EmailService;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.easymock.EasyMock;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class CustomerServiceImplTest {
//
//	@Autowired
//	private CustomerDao customerDao;
//
//	@Autowired
//	private CustomerService customerService;
//	
//	@Autowired
//	private EmailService emailService;
//
//	@Before
//	public void setUp() {
//		customerDao = EasyMock.createNiceMock(CustomerDao.class);
//		customerService = new CustomerServiceImpl(customerDao);
//	}
//
//	@After
//	public void after() {
//		resetMocks();
//	}
//
//	public void resetMocks() {
//		EasyMock.reset(customerDao);
//	}
//
//	public List<Customer> getCustomers() {
//		List<Customer> customers = new ArrayList<Customer>();
//		Customer customer = new Customer();
//		customer.setId(1);
//		customer.setName("Mate Karolyi");
//		customer.setAge(23);
//		customer.setEmail("hirannormatt@gmail.com");;
//
//		customers.add(customer);
//
//		return customers;
//	}
//
//	@Test
//	public void testGetCustomers() {
//		EasyMock.expect(customerDao.getCustomerList())
//				.andReturn(getCustomers());
//		EasyMock.replay(customerDao);
//		GetCustomerListReply customerList = customerService.getCustomerList();
//
//		assertEquals(customerList.getCustomer().size(), getCustomers().size());
//	}
//
//	@Test
//	public void testAddCustomer() {
//		AddCustomerRequest request = new AddCustomerRequest();
//		request.setCustomer(getCustomers().get(0));
//
//		customerService.addCustomer(request);
//		EasyMock.expectLastCall();
//		EasyMock.replay(customerDao);
//		
//
//		AddCustomerResponse response = customerService.addCustomer(request);
//
//		assertEquals("Done", response.getMessage());
//
//	}
//
//	@Test(expected = IllegalArgumentException.class)
//	public void testAddNullCustomer() {
//		customerService.addCustomer(null);
//		EasyMock.replay(customerDao);
//		
//		customerService.addCustomer(null);
//		
//		AddCustomerRequest request = new AddCustomerRequest();
//		request.setCustomer(null);
//
//		customerService.addCustomer(request);
//		EasyMock.replay(customerDao);
//		
//		customerService.addCustomer(request);
//
//	}
//}
