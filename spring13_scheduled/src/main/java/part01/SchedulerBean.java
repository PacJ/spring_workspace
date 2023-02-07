package part01;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

public class SchedulerBean {
	private static final Logger logger = LoggerFactory.getLogger(SchedulerBean.class);
	
	@Scheduled(cron="0/3 * * * * *")
	public void scheduleRun() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		logger.info("스케줄링 실행: " + sdf.format(calendar.getTime()));
		System.out.println("System: " + sdf.format(calendar.getTime()));
	}
}
