package org.santosh.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class HelloController {

	@RequestMapping(value = "/welcome/{firstName}/{lastName}", method = RequestMethod.GET)
	public ModelAndView handleRequestWelcome(@PathVariable Map<String,String> pathMap) {
		
		String firstname = pathMap.get("firstName");
		String lastName = pathMap.get("lastName");
		ModelAndView modelAndView = new ModelAndView("WelcomeSpringMVC");
		modelAndView.addObject("welcomeMsg", "Super Maccha!! Vanakkam ".concat(firstname).concat(" ").concat(lastName));
		
		return modelAndView;
	}
}
