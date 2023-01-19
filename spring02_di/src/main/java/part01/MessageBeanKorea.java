package part01;

public class MessageBeanKorea implements MessageBean{

	public MessageBeanKorea() {
		System.out.println("MessageBeanKorea Created");
	}

	@Override
	public void sayHello(String name) {
		System.out.printf("안녕, %s?\n", name);
	}
}
