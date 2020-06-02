package com;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {

		// Dog dog = new Dog();
		// dog.setName("小白");
		// System.out.println(dog.getName());

		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
//		DogInf dog = (DogInf) app.getBean("dog2");
//		dog.jiao();
		Boy boy = (Boy) app.getBean("boy");
		System.out.println(boy.getName() + "," + boy.getDog().getName());
		
	}

}
