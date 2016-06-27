package hu.uni.miskolc.iit.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = { "/" })
public class HomeController {

	@RequestMapping(value = { "/*" }, method = RequestMethod.GET)
	public String welcomePage() {
		return "index";
	}
}
