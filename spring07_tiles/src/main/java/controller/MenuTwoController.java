package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MenuTwoController {

	@RequestMapping("/menu2.do")
	public String execute() {
		return "menu2";
	}
}//end class
