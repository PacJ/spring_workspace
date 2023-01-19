package part01;

public class MessageBeanEnglish implements MessageBean{

	public MessageBeanEnglish() {
		System.out.println("MessageBeanEnglish Created");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("Hello, %s.\n", name);		
	}
}
