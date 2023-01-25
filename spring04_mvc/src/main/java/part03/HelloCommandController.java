package part03;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

// http://localhost:8090/myapp/mem.htm

@Controller
public class HelloCommandController {

//	@GetMapping("mem.htm")
	@RequestMapping(value="/mem.htm", method = RequestMethod.GET)
	public String form() {
		return "part03/memForm";
	}

	
	@RequestMapping(value="/mem.htm", method=RequestMethod.POST)
	public ModelAndView submit(MemDTO dto, ModelAndView mav) {
		mav.setViewName("part03/memPro");
		return mav;
	}
	
}