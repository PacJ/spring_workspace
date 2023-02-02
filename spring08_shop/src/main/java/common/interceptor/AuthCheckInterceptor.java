package common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import members.dto.AuthInfo;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter{
	public AuthCheckInterceptor() {

	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//false면 세션 없으면 그냥 null이고
		//true면 세션이 없으면 세션 생성 후 return해준다. 
		HttpSession session = request.getSession(false);
		
		if(session!=null) {
			AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
			if(authInfo != null) {
				return true;
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/member/login.do");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
	
}//end class
