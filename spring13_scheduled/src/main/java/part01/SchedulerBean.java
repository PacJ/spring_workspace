package part01;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/*
 src/main/resources/log4j.xml
  <!-- Root Logger -->
   <root>
      <priority value="info" /> 
      <appender-ref ref="console" />
   </root>
   
   
로그(log) 프로그램 개발이나  운영시 문제점을 추적하거나 운영상태를 모니터링하기 위한 텍스트이다.
System.out.println();을 사용하여 로그를 확인할 수 있으나 이보다는 로그를 기록하는 방법을 사용한다.

log4j은 다음과 같은 레벨은 같는다.
TRACE > DEBUG > INFO > WARN > ERROR > FATAL
만약에 INFO로 세팅하면 INFO, WARN, ERROR, FATAL은 기록된다.

FATAL : 심각한 에러-> 프로그램 자체가 실행되지 않을 수 있다.
ERROR : 문제가 발생하면 소프트웨어 일부가 기능을 수행하지 못할 수 있다.
WARNING : 소프트웨어가 동작하고 있지만, 예상지 못한 일이 발생하거 가까운 미래에 문제가 발생할 수 있다는 경고이다.
           예로 디스크 공간 부족 -> 프로그램은 동작되지만 앞으로 문게라 발생할 수도 있음
INFO : 작업이 정상적으로 작동하고 있음을 메세지를 통해 확인하고 싶은 경우에 사용한다.
DEBUG : 어떤 문제가 발생했을 경우 문제를 진단하고 싶을 때 필요한 자세한 정보를 기록한다.
        개발시 디버그 용도로 사용하는 메세지를 나타낸다.
TRACE : 디버그 레벨이 너무 광범위한 것을 해결하기 위해서 좀더 상세한 이벤트를 나타낸다.   
*/


public class SchedulerBean {
   private   static final Logger logger = LoggerFactory.getLogger(SchedulerBean.class);
   
   @Scheduled(cron = "0/3 * * * * *") //3초마다 실행
   public void scheduleRun() {
      Calendar calendar = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      logger.info("스케줄링 실행: " + sdf.format(calendar.getTime()));
      System.out.println("System: " + sdf.format(calendar.getTime()));
   }
   
}//end class 


/* CRON 스케줄러 정규 표현식
 * 1. 7개의 각 필드로 구성되어 있음
 *   초(Seconds) 분(Minutes) 시(Hours) 일(Day) 월(Month) 요일(Week) 연도(Year)
 *   
 *     필드명       값의 허용범위            허용된 특수문자
 *   초(Seconds)     0~59                 , - * /
 *   분(Minutes)     0~59                  , - * /
 *   시(Hours)       0~23                   , - * /
 *   일(Day)         1~31                   , - * ? / L W
 *   월(Month)       1~12 or JAN ~DEC     , - * /
 *   요일(Week)       0~6 or SUN~SAT       , - * ? / L #
 *   연도(Year)      empty or 1970~2099    , - * /
 *   
 *  
 *   <cron 표현식 - 특수문자 의미>
● * : 모든 값을 표현.
● ? : 특정한 값이 없음을 표현. 
● - : 범위를 의미. (예) 월요일에서 수요일까지는 MON-WED로 표현
● , : 특별한 값일 때만 동작 (예) 월,수,금 MON,WED,FRI 
● / : 시작시간 / 단위  (예) 0분부터 매 5분 0/5
● L : 일에서 사용하면 마지막 일, 요일에서는 마지막 요일(토요일)
● W : 가장 가까운 평일 (예) 15W는 15일에서 가장 가까운 평일 (월 ~ 금)을 찾음
● # : 몇째주의 무슨 요일을 표현 (예) 3#2 : 2번째주 수요일
 *   
 * cron="0/3 * * * * *" => 3초마다
 * cron="0 0/5 * * * *" => 5분마다
 * cron="0 * 12 * *  *"  => 매일 낮 12시에
 * cron="0 15 10 * * *" => 매일 10시 15분에
 * cron="0 15 10 * * * 2022" => 2022년 동안만 매일 10시 15분에
 * cron="0 0/50 9-17 * * MON-FRI  => 월요일부터 금요일까지(주중) 9시 부터 17시 까지 매 50분마다 
 * cron="0 0 0 1 1 * *" => 해년 1월 1일 0시마다
 * cron="0 15 10 15 * *" => 매월 15일 오전 10시 15분마다
 * cron="0 15 10 L * * "  => 매월 말일 오전 10시 15분마다
 * cron="0 15 10 * * 6L => 매월 마지막 금요일 오전 10시 15분마다
 * cron="0 15 10 * * 6L 2020-2022 => 2020년부터 2022년까지 매월 마지막 금요일 10시 15분마다 
 * cron="0 0   9 10 * *  => 매월 10일 9시마다
 * 
 * 2. cron 정규표현식 
 * http://www.cronmaker.com/?0
 */





