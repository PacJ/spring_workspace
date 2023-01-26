package part02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8090/myapp/firstmain.ss

@Controller
public class MemController {

	private Service svc;
	
	public MemController() {
	}

	public void setSvc(Service svc) {
		this.svc = svc;
	}
	
	//호출하는 곳에서 예외처리 해야됨. ServiceImp에서는 안됨.
	@ResponseBody
	@RequestMapping("/firstmain.ss")
	public String execute() {
		
		System.out.println("execute");
		
		try {
			svc.insertProcess();	
			System.out.println("OK");
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return "execute";
	}
}
