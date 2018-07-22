package guru.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.controllers.ContructorInjectedController;
import guru.springframework.controllers.MyController;
import guru.springframework.controllers.PropertyInjectedController;
import guru.springframework.controllers.SetterInjectedController;

@SpringBootApplication
public class SpringDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDiApplication.class, args);
		
		//Get the bean - Created by Spring on Initialization of application context - All beans instances are present in application context
		MyController myController = (MyController)ctx.getBean("myController");

		System.out.println(myController.hello());
		System.out.println(((PropertyInjectedController)ctx.getBean("propertyInjectedController")).sayHello());
		System.out.println(((SetterInjectedController)ctx.getBean("setterInjectedController")).sayHello());
		System.out.println(((ContructorInjectedController)ctx.getBean("contructorInjectedController")).sayHello());	
		
	}
}
