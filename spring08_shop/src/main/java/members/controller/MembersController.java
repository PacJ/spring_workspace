package members.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import common.exception.WrongEmailPasswordException;
import members.dto.AuthInfo;
import members.dto.ChangePwdCommand;
import members.dto.MembersDTO;
import members.service.MembersService;

//http://localhost:8090/myapp/member/signup.do

@Controller
public class MembersController {

	private MembersService membersService;
	
	public MembersController() {

	}
	
	public void setMembersService(MembersService membersService) {
		this.membersService = membersService;
	}
	
	//회원가입 폼
	@RequestMapping(value="/member/signup.do", method=RequestMethod.GET)
	public ModelAndView addMember(ModelAndView mav) {
		mav.setViewName("member/signup");
		return mav;
	}
	
	//회원가입 처리
	@RequestMapping(value="/member/signup.do", method=RequestMethod.POST)
	public String addMember(MembersDTO membersDTO, HttpSession session) {
		AuthInfo authInfo = membersService.addMemberProcess(membersDTO);
		session.setAttribute("authInfo", authInfo);
		return "redirect:/home.do";
	}
	
	//로그아웃
	@RequestMapping(value="/member/logout.do")
	public String logoutMember(HttpSession session) {
		session.invalidate();
		return "redirect:/home.do";
	}
	
	//로그인 폼
	@RequestMapping(value="/member/login.do", method=RequestMethod.GET)
	public String loginMember() {
		return "member/login";
	}
	
	//로그인 처리
	@RequestMapping(value="/member/login.do", method=RequestMethod.POST)
	public String loginMember(MembersDTO membersDTO, HttpSession session, HttpServletResponse resp) {
		try {
			AuthInfo authInfo = membersService.loginProcess(membersDTO);
			session.setAttribute("authInfo", authInfo);
			Cookie rememberCookie = new Cookie("REMEMBER", membersDTO.getMemberEmail());
			rememberCookie.setPath("/");
			
			if(membersDTO.isRememberEmail()) {
				rememberCookie.setMaxAge(60 * 60 * 24 * 30); //60초 * 60분 * 24시간 * 30일 = 1개월
			}else {
				rememberCookie.setMaxAge(0);
			}
			
			resp.addCookie(rememberCookie);
			return "redirect:/home.do";
		} catch (WrongEmailPasswordException e) {
			resp.setContentType("text/html;charset=UTF-8");
			
			try {
				PrintWriter out = resp.getWriter();
//				out.print("아이디와 비밀번호가 일치하지 않습니다.");
				out.print("<script>alert('아이디와 비밀번호가 일치하지 않습니다.'); history.go(-1);</script>");
				out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
	
	@RequestMapping(value="/member/editmember.do", method=RequestMethod.GET)
	public ModelAndView updateMember(ModelAndView mav, HttpSession session) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		mav.addObject("membersDTO", membersService.updateMemberProcess(authInfo.getMemberEmail()));
		mav.setViewName("member/editmember");
		return mav;
	}
	
	@RequestMapping(value="/member/editmember.do", method=RequestMethod.POST)
	public String updateMember(MembersDTO membersDTO, HttpSession session) {
		AuthInfo authInfo = membersService.updateMemberProcess(membersDTO);
		session.setAttribute("authInfo", authInfo);
		return "redirect:/home.do";
	}
	
	@RequestMapping(value="/member/changepass.do", method=RequestMethod.GET)
	public String changePassword() {
		return "member/changepass";
	}
	
	@RequestMapping(value="/member/changepass.do", method=RequestMethod.POST)
	public String changePassword(ChangePwdCommand changePass, HttpSession session, HttpServletResponse resp) {
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		try {
			membersService.updatePassProcess(authInfo.getMemberEmail(), changePass);
			return "redirect:/home.do";
		} catch (WrongEmailPasswordException e) {
			resp.setContentType("text/html;charset=UTF-8");
			try {
				PrintWriter out = resp.getWriter();
//				out.print("아이디와 비밀번호가 일치하지 않습니다.");
				out.print("<script>alert('현재 비밀번호가 틀렸습니다.'); </script>");
				out.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return "member/changepass";
		}
	}
}//end class
