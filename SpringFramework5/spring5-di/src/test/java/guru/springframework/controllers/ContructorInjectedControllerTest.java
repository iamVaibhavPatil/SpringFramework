package guru.springframework.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import guru.springframework.services.GreetingServiceImpl;

public class ContructorInjectedControllerTest {

	private ContructorInjectedController contructorInjectedController;
	
	@Before
	public void setUp() throws Exception {
		this.contructorInjectedController = new ContructorInjectedController(new GreetingServiceImpl());
	}
	
	@Test
	public void testGreeting() throws Exception {
		assertEquals(GreetingServiceImpl.HELLO_GURUS, contructorInjectedController.sayHello());
	}
}
