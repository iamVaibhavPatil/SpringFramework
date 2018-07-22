package guru.springframework;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

	public LifeCycleDemoBean() {
		System.out.println("## I am in LifeCycleDemoBean constructor");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("## Application context has been set");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("## BeanFactory has set");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("## My bean name is " + name);
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("## The lifecyle bean has been terminated");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("## The lifecycle been has it's properties set");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("## PostConstruct annotated method has been called");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("## PreDestroy annotated method has been called");
	}
	
	public void beforeInit() {
		System.out.println("## Before Init called by Bean Post Processor");
	}
	
	public void afterInit() {
		System.out.println("## After Init called by Bean Post Processor");
	}
}
