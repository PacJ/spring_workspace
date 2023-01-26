package part01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//http://localhost:8090/myapp/firstmain.st

@Controller
public class MemController {

	private Service svc;
	
	public MemController() {
	}

	public void setSvc(Service svc) {
		this.svc = svc;
	}
	
	@ResponseBody
	@RequestMapping("/firstmain.st")
	public String execute() {
		System.out.println("execute");
		svc.insertProcess();
		return "execute";
	}
}
