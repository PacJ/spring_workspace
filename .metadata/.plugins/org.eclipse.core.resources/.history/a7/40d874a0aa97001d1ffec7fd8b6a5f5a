package part01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * IoC(Inversion of Control 제어의 역전)
 * 객체생성이나 메소드 호출을 개발자가 직접 하지 않고, 스프링 프레임워크에게 제어권을 넘기는것.
 * 대부분의 프레임워크에서 IoC를 적용하고 있다.
 * 
 * DI(Dependency Injection 의존성 주입)
 * 1. 객체를 직접 생성하지 않고 외부에서 생성된 객체를 주입받아 이용하는 기능이다.
 * 2. DI는 컨테이너를 통해 서로 강하게 결합되어 있는 두 클래스를 분리하고 두 객체간의 관계를 
 *    결정해 줌으로써 결합도를 낮추고 유연성 확보를 한다.
 */

public class SpringTest {

	public static void main(String[] args) {

		//ApplicationContext : Bean들의 life cycle을 관리해준다.
		String path = "part01/di.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);

		MessageBean bean = (MessageBean)context.getBean("mb");
		display(bean, "Spring");
		
	}//end main()

	public static void display(MessageBean bean, String name) {
		bean.sayHello(name);
	}
	
}//end class
