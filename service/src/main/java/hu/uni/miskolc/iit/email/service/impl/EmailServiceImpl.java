package hu.uni.miskolc.iit.email.service.impl;

import hu.uni.miskolc.iit.customer.bean.Customer;
import hu.uni.miskolc.iit.customer.service.bean.EmailSendRequest;
import hu.uni.miskolc.iit.customer.service.bean.EmailSendResponse;
import hu.uni.miskolc.iit.email.service.EmailService;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailServiceImpl implements EmailService {
	
	private MailSender mailSender;
	private SimpleMailMessage templateMessage;
	
	public EmailServiceImpl(MailSender mailSender, SimpleMailMessage templateMessage) {
		if (mailSender == null) {
			throw new IllegalArgumentException(mailSender + " Bean creation error!");
		}
		if (templateMessage == null) {
			throw new IllegalArgumentException(templateMessage + " Bean creation error!");
		}
		
		this.mailSender = mailSender;
		this.templateMessage = templateMessage;
	}
	
	private String buildSampleModifyNotification(Customer customer) {
		StringBuilder sb = new StringBuilder();
		sb.append("<HTML>");
		sb.append("Dear " + "<b>" + customer.getName() + "</b>" + "your details has been changed! \n");
		sb.append("Your new details: \n");
		sb.append("Name:" + customer.getName() + "\n");
		sb.append("Age: " + customer.getAge() + "\n");
		sb.append("Email" + customer.getEmail() + "\n\n");
		sb.append("<hr>");
		sb.append("This is an automaticly generated email.");
		sb.append("</HTML>");
		
		return sb.toString();
	}

	public void sendEditNotification(Customer customer) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		msg.setFrom(templateMessage.getFrom());
		msg.setTo(customer.getEmail());
		msg.setSubject(templateMessage.getSubject());
		msg.setText(buildSampleModifyNotification(customer));
		
		mailSender.send(msg);
		
	}


	public void sendEmail(EmailSendRequest request) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
		
		msg.setFrom(templateMessage.getFrom());
		msg.setTo(request.getToEmail());
		msg.setSubject(request.getSubject());
		msg.setText(request.getMessage());
		
		mailSender.send(msg);
	}

}
