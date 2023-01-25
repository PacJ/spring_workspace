package part02_annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//공통로직만 구현해 놓은 클래스 = Advice

@Aspect
public class AdviceCommon {
	
	public AdviceCommon() {

	}
	
	@Before(value = "execution(* part02_annotation.ServiceImp.prn1(..))")
	public void comm1() {
		System.out.println("before");
	}
	
	@After(value = "execution(* part02_annotation.ServiceImp.prn2(..))")
	public void comm2() {
		System.out.println("after");
	}
	
	@AfterReturning(value = "execution(* part02_annotation.ServiceImp.prn3(..))", returning = "name")
	public void comm3(String name) {
		System.out.println("name:" + name);
	}
	
	@AfterThrowing(value = "execution(* part02_annotation.ServiceImp.prn4(..))", throwing = "ex")
	public void comm4(Exception ex) {
		System.out.println("comm4:" + ex);
	}
	
	@Around(value = "execution(* part02_annotation.ServiceImp.prn5(..))")
	public void comm5(ProceedingJoinPoint point) {
		System.out.println("comm5 start");
		try {
			point.proceed();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("comm5 end");
	} 

}//end class
