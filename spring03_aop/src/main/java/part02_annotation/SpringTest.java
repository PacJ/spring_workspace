package part02_annotation;

import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
<!-- https://mvnrepository.com/artifact/org.aspectj/aspectjweaver -->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.7</version>
    <scope>runtime</scope>
</dependency>
*/

/*
 * APO(Aspect Oriented Programming) : 관점지향 프로그래밍
 * 1. AOP는 문제를 바라보는 관점을 기준으로 프로그래밍하는 기법이다.
 * 2. AOP는 문제를 해결하기 위한 핵심관심사항과 전체에 적용되는 공통관심사항을 기준으로
 *    프로그래밍함으로써 공통 모듈은 여러 코드에 쉽게 적용할 수 있도록 해준다.
 */

public class SpringTest {

	public static void main(String[] args) {

//		String path = "part02_annotation/aop.xml";
//		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Service svc = null;
		
		svc = (Service)context.getBean("svc");
//		svc.prn1();
//		svc.prn1(10);
//		svc.prn1(new Random());
//		svc.prn1(100, 200);
		
//		svc.prn2(); //핵심로직 처리 후 공통로직 처리
		
//		svc.prn3();
		
//		try {
//		svc.prn4();
//		} catch(Exception e) {
//			
//		}
		
		svc.prn5();
		
		svc = (Service)context.getBean("pn");
		svc.prn5();
		
	}//end main()

}//end class
