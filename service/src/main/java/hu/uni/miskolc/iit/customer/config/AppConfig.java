package hu.uni.miskolc.iit.customer.config;
import hu.uni.miskolc.iit.customer.dao.CustomerDao;
import hu.uni.miskolc.iit.customer.dao.impl.CustomerDaoImpl;
import hu.uni.miskolc.iit.customer.dao.mappers.CustomerMapper;
import hu.uni.miskolc.iit.customer.facade.CustomerFacade;
import hu.uni.miskolc.iit.customer.facade.impl.CustomerFacadeImpl;
import hu.uni.miskolc.iit.customer.service.CustomerService;
import hu.uni.miskolc.iit.customer.service.impl.CustomerServiceImpl;
import hu.uni.miskolc.iit.email.service.EmailService;
import hu.uni.miskolc.iit.email.service.impl.EmailServiceImpl;

import java.util.Properties;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class AppConfig {
	
	private static final String EMAIL = "manuscriptsystem@gmail.com";
	private static final String SUBJECT = "NOREPLY";
	
	private static final String DB_URL = "jdbc:mysql://localhost:3306/customerdb";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "";
	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(DRIVER_CLASS_NAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setPassword(DB_PASSWORD);

		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory)sessionFactory.getObject();
	}
	
    @Bean
    public CustomerMapper getCustomerMapper() throws Exception {
      SqlSessionTemplate sessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
      return sessionTemplate.getMapper(CustomerMapper.class);
    }
    
    @Bean
    public CustomerService getCustomerService(CustomerDao customerDao, EmailService emailService) {
    	return new CustomerServiceImpl(customerDao);
    }
    
    @Bean
    public CustomerFacade getCustomerFacade(CustomerService customerService, EmailService emailService) {
    	return new CustomerFacadeImpl(customerService, emailService);
    }
    
    @Bean
    public EmailService getEmailService(JavaMailSender javaMailSender, SimpleMailMessage simpleMailMessage) {
    	return new EmailServiceImpl(javaMailSender, simpleMailMessage);
    }
    
    @Bean
    public CustomerDao getCustomerDao(CustomerMapper customerMapper) {
    	return new CustomerDaoImpl(customerMapper);
    }
    
    @Bean
    public JavaMailSender getJavaMailSender() {
    	JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    	javaMailSender.setHost("smtp.gmail.com");
    	javaMailSender.setPort(465);
    	javaMailSender.setProtocol("smtps");
    	javaMailSender.setUsername("manuscriptsystem@gmail.com");
    	javaMailSender.setPassword("megeikbsc");
    	Properties prop = new Properties();
    	prop.setProperty("mail.smtps.auth", "true");
    	javaMailSender.setJavaMailProperties(prop);
    	
    	return javaMailSender;
    }
    
    @Bean
    public SimpleMailMessage getSimpleMailMessage() {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    	simpleMailMessage.setFrom(EMAIL);
    	simpleMailMessage.setSubject(SUBJECT);
    	return simpleMailMessage;
    }

}
