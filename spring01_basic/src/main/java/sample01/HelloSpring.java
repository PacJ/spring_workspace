package sample01;

/*
 * 결합도
 * 1. 클래스 간의 상호 연결성 측정을 의미한다.
 * 2. 낮은 결합도를 가지려면 하나의 객체 변경이 다른 객체에 영향을 미쳐서는 안된다.
 * 3. 높으 결합도를 낮추기 위하여 interface를 사용한다.
 * 4. factory를 이용하면 결합도는 인터페이스보다 낮지만
 * 	  factory의 구현에 문제가 있다면 참조하는 모든 객체들에 영향이 간다. 
 */

public class HelloSpring {

	public static void main(String[] args) {
//		MessageBeanKorea bean = new MessageBeanKorea();
//		display(bean, "V");
		
		MessageBeanEnglish engBean = new MessageBeanEnglish();
//		engBean.sayHello("V");
		display(engBean, "V");
		
	}//end main()

	public static void display(MessageBeanEnglish bean, String name) {
		bean.sayHello(name);
	}//end display()
	
}//end class
