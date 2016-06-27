package hu.uni.miskolc.iit.email.service;

import hu.uni.miskolc.iit.customer.bean.Customer;
import hu.uni.miskolc.iit.customer.service.bean.EmailSendRequest;

public interface EmailService {
	
	public void sendEditNotification(Customer customer);
	
	public void sendEmail(EmailSendRequest request); 

}
