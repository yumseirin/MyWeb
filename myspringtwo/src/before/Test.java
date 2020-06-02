package before;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(
		"applicationContext.xml");
		Dian d=(Dian)app.getBean("d");
		d.talk("叫爸爸，打屁股");
	}
}
