package com.ssg.app.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PageUtil {

    /**
     * 페이징바 제작을 위한 값 연산 및 반환 메소드
     * 서비스로부터 페이징처리에 필요한 정보를 전달받아 연산 수행
     *
     * @param totalCount   전체 게시글 수(db로부터 조회)
     * @param page         현재 페이지(요청 파라미터)
     * @param display      한 페이지에 표현할 게시글 최대 수
     * @param pagePerBlock 페이징바에 표현할 페이지 최대 개수 ( 임의 설정 )
     * @return
     */
    public Map<String, Object> getPageInfo(int totalCount, int page, int display, int pagePerBlock){
        int totalPage = (int)Math.ceil((double) totalCount / display);
        int beginPage = page - page % pagePerBlock + 1;
        int endPage = Math.min(beginPage + pagePerBlock -1, totalPage);

        int offset = (page -1) * display;
        Map<String, Object> map = new HashMap<>();
        map.put("totalCount", totalCount);
        map.put("totalPage", totalPage);
        map.put("page", page);
        map.put("display", display);
        map.put("pagePerBlock", pagePerBlock);
        map.put("beginPage", beginPage);
        map.put("endPage", endPage);
        map.put("offset", offset);
        return map;
    }
}
