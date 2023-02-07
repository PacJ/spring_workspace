package part01;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// http://localhost:8090/myapp/main.do

@Controller
public class HelloController {

	@RequestMapping("/main.do")
	public String execute() {
		return "part01/form";
	}
	
	@Scheduled(fixedDelay=1000)
	public void scheduleProcess() {
		System.out.println(new Date() + "스케줄링 처리완료");
	}
}
