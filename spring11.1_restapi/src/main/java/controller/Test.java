package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.MemDTO;

@Controller
public class Test {
	
	@RequestMapping(value = "/mem/list", method = RequestMethod.GET)
	public MemDTO process() {
		System.out.println("test");
		return new MemDTO();
	}

}
