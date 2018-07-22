package guru.springframework.properties.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

import guru.springframework.properties.examplebeans.FakeDataSource;
import guru.springframework.properties.examplebeans.FakeJmsBroker;

@Configuration
//@PropertySource({"classpath:datasource.properties", "classpath:jms.properties"})

@PropertySources({
	@PropertySource("classpath:datasource.properties"),
	@PropertySource("classpath:jms.properties")	
})
public class PropertyConfig {
	
	@Autowired
	Environment env;	//Can be used to read the system properties on Operating system

	@Value("${guru.db.username}")
	String dbUsername;
	
	@Value("${guru.db.password}")
	String dbPassword;
	
	@Value("${guru.db.url}")
	String dbUrl;
	
	@Value("${guru.jms.username}")
	String jmsUsername;
	
	@Value("${guru.jms.password}")
	String jmsPassword;
	
	@Value("${guru.jms.url}")
	String jmsUrl;	
	
	@Bean
	FakeDataSource fakeDataSource() {
		FakeDataSource fakeDataSource = new FakeDataSource();
		fakeDataSource.setUsername(dbUsername);
		//fakeDataSource.setUsername(env.getProperty("USERNAME"));
		fakeDataSource.setPassword(dbPassword);
		fakeDataSource.setDbUrl(dbUrl);
		return fakeDataSource;
	}
	
	@Bean
	FakeJmsBroker fakeJmsBroker() {
		FakeJmsBroker fakeJmsBroker = new FakeJmsBroker();
		fakeJmsBroker.setUsername(jmsUsername);
		fakeJmsBroker.setPassword(jmsPassword);
		fakeJmsBroker.setDbUrl(jmsUrl);
		return fakeJmsBroker;
	}	
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		return propertySourcesPlaceholderConfigurer;
	}
	
}
