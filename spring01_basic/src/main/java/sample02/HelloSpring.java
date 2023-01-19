package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		MessageBean bean = null;
		bean = new MessageBeanKorea();
		display(bean, "V");
		
		bean = new MessageBeanEnglish();
		display(bean, "V");

	}//end main()

	public static void display(MessageBean bean, String name) {
		bean.sayHello(name);
	}
	
}//end class
