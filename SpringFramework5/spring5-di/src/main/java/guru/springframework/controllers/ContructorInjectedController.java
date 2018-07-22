package guru.springframework.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import guru.springframework.services.GreetingService;

@Controller
public class ContructorInjectedController {

	public GreetingService greetingService;
	
	@Autowired
	public ContructorInjectedController(@Qualifier("constructorGreetingService") GreetingService greetingService) {
		this.greetingService = greetingService;
	}	
	
	public String sayHello() {
		return greetingService.sayGreeting();
	}
}
