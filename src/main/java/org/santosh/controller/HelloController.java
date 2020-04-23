/**
 * 
 */
package org.santosh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author Santosh
 * @date 24-Mar-2018
 */

/**
 * Annotated way
 * */

@Controller
public class HelloController {

	@RequestMapping(value = "/welcome/{firstName}/{lastName}", method = RequestMethod.GET)
	public ModelAndView handleRequestWelcome(@PathVariable Map<String,String> pathMap) {
		
		String firstname = pathMap.get("firstName");
		String lastName = pathMap.get("lastName");
		ModelAndView modelAndView = new ModelAndView("WelcomeSpringMVC");
		modelAndView.addObject("welcomeMsg", "Super Maccha!! Vanakkam ".concat(firstname).concat(" ").concat(lastName));
		
		return modelAndView;
	}
	
	/**
	 * Non-annotated way
	 * */

	/*public class HelloController extends AbstractController {

		@Override
		protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			ModelAndView modelAndView = new ModelAndView("WelcomeSpringMVC");
			modelAndView.addObject("welcomeMsg", "Super Maccha!! Vanakkam to Spring MVC web app");
			return modelAndView;
		}
	}*/
	
}