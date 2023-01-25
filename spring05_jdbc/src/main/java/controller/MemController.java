package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.MemDAO;
import model.MemDTO;

// http://localhost:8090/myapp/list.do

@Controller
public class MemController {
	
	private MemDAO memDao;
	
	public MemController() {

	}
	
	public void setMemDao(MemDAO memDao) {
		this.memDao = memDao;
	}
	
	@RequestMapping(value="/list.do")
	public ModelAndView process(ModelAndView mav) {
		mav.addObject("list", memDao.List());
		mav.setViewName("mem/list");
		return mav;
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.GET)
	public String insert() {
		return "mem/insert";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insert(MemDTO dto) {
			memDao.insertMethod(dto);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public ModelAndView update(int num, ModelAndView mav) {
		mav.addObject("dto", memDao.one(num));
		mav.setViewName("mem/update");
		return mav;
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String update(MemDTO dto) {
		memDao.updateMethod(dto);
		return "redirect:/list.do";
	}
	
	@RequestMapping(value="/delete.do")
	public String delete(int num) {
		memDao.deleteMethod(num);
		return "redirect:/list.do";
	}
}
