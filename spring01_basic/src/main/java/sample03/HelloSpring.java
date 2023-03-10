package sample03;

/*
 * factory를 이용하면 결합도는 인터페이스보다 낮지만
 * factory의 구현에 문제가 있다면 참조하는 모든 객체들에 영향이 간다. 
 */

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean bean = null;
		bean = MessageFactory.getInstance("ko");
		display(bean, "Jarvis");
		
		bean = MessageFactory.getInstance("en");
		display(bean, "V");
	}
	
	public static void display(MessageBean bean, String name) {
		bean.sayHello(name);
	}//end display
}
