package com.ssg.app.scheduler;

import com.ssg.app.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@RequiredArgsConstructor
@Component
public class BoardScheduler {

    /*
    ## Scheduler ##
    1. 특정 날짜, 특정 시간, 일정 주기 마다 특정 작업을 묵시적으로 실행시켜주는 주체
    2. 별도의 액션을 주지 않아도 지정한 날짜 및 시간, 주기마다 자동 실행됨
    3. Spring에서의 Scheduler 등록
       1) 묵시적으로 실행시킬 작업을 따로 정의할 클래스 만들기 (빈 등록)
       2) 클래스 내에 각 작업별 메소드 정의하기
          (1) 반환타입 : void
          (2) 매개변수 : 없음
          (3) 메소드 상단에 @Scheduled 등록
          (4) servlet-context.xml에서 스케줄링 활성화를 위한 task 추가
              <task:annotation-driven/>

   ## Cron 표현식 ##
   1. 작성 형식
      초 분 시 일 월 요일 [연도]
   2. 형식별 표기 가능한 값
      1) 초     : 0 ~ 59
      2) 분     : 0 ~ 59
      3) 시     : 0 ~ 23
      4) 일     : 1 ~ 31
      5) 월     : 0 ~ 11(JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC)
      6) 요일   : 0 ~ 6 (SUN, MON, TUE, WED, THR, FRI, SAT)
      7) 연도 : 생략 가능
   3. 형식별 작성 가능한 키워드
      1) ?      : 설정값 없을때 (일|요일)
      2) *      : 모든조건 (초|분|시|일|월)
      3) L      : 마지막 (일|요일)
      4) W      : 가장가까운 평일 (일) ex) 10W ==> 10일이 평일일경우(10일에 실행) / 10일이 토요일일경우(9일에 실행) / 10일이 일요일일경우(11일에 실행)
      5) #      : 몇주째인지 (요일)      ex) 3#2 ==> 수요일2째주
      6) /      : 주기 (시작시간/단위) ex) 분 자리에 0/10 ==> 0분부터 10분 간격으로
      7) -      : 범위               ex) 시 자리에 1-3  ==> 1시, 2시, 3시
   4. 예시
      → 0 0 * * * *        : 매일 모든 시간마다
      → 0 0 5 * * *        : 매일 5시마다
      → 0 0 3-5 * * *      : 매일 3,4,5시마다
      → 0 0 4,5 * * *      : 매일 4,5시마다
      → 0 1/30 3-5 * * *   : 매일 3:01/3:31/4:01/4:31/5:01/5:31 마다
      → 0 0 12 * * MON-FRI : 월~금 12시마다
 */

    private final BoardService boardService;

    @Scheduled(cron="0 0/1 * * * *")
    public void execute1() {
        log.debug("1분마다 실행됨");
    }

    @Scheduled(cron = "0 0 1 * * SUN")
    public void execute2() {
        int totalCount = (int) boardService.getBoardsAndPaging(1).get("totalCount");
        log.debug("현재 게스글의 총 개수 {}", totalCount);
    }

}
