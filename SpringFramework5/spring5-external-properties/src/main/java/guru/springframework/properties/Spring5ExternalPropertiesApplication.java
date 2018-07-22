package guru.springframework.properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import guru.springframework.properties.examplebeans.FakeDataSource;
import guru.springframework.properties.examplebeans.FakeJmsBroker;

@SpringBootApplication
public class Spring5ExternalPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Spring5ExternalPropertiesApplication.class, args);
		
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);
		FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
		System.out.println(fakeDataSource);
		System.out.println(fakeJmsBroker);
	}
}
