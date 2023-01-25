package part02_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class Config {
	
//	<bean id = "svc" class = "part02_annotation.ServiceImp" />
	@Bean
	public ServiceImp svc() {
		return new ServiceImp();
	}
	
//	<bean id = "common" class = "part02_annotation.AdviceCommon" />
	@Bean
	public AdviceCommon common() {
		return new AdviceCommon();
	}
	
//	<bean id = "pn" class = "part02_annotation.ServiceImp" />
	@Bean(name = "pn")
	public ServiceImp point() {
		return new ServiceImp();
	}

}//end class
