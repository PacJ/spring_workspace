package part03_exam;

public class ServiceImp implements Service{
	private User user;

	public ServiceImp() {
		
	}

	public ServiceImp(User user) {
		this.user = user;
	}
	
	@Override
	public void prn() {
		System.out.printf("%s %s\n", user.getId(), user.getPass());
	}
	
	
}
