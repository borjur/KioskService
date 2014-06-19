package aop.hello.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.hello.Store;

public class StoreClient {

	public static void main(String[] args) {
		String springConfig = "aop/spring-config.xml";
		ApplicationContext spring = new
			ClassPathXmlApplicationContext(springConfig);
		//ice cream
		String item = "ice cream";
		Store store = spring.getBean("store", Store.class);
		store.purchaseItem(item);
	}

}
