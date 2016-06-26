package hu.uni.miskolc.iit.customer.controller.config;

import hu.uni.miskolc.iit.customer.config.AppConfig;
import hu.uni.miskolc.iit.customer.controller.MyController;
import hu.uni.miskolc.iit.customer.facade.CustomerFacade;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppConfig.class)
public class MyControllerConfiguration {

	@Bean
	public MyController getMyController(CustomerFacade customerFacade) {
		return new MyController(customerFacade);
	}

}
