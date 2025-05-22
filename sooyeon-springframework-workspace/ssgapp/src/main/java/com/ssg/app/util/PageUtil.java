package com.ssg.app.util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//프론트의 역할 아닌가? -> 해당 페이지의 데이터를 db에 접근하여 전달해줘야해서 백에 있어야됳듯

/**
 * 프론트에서 처리할 경우 모든 데이터를 프론트에 보내고 프론트에서 선택적으로출력해야하는데
 * 백에서 처리할 경우 현재 테이블에서 보여줘야할 데이터만 선택적으로 선별하여db에 접근하고 보여주기 때문에
 * 띄워야할 데이터가 많아야할 경우를 생각하면 백에서 처리하는 것이 맞는 거 같다.
 */
@Component
public class PageUtil {


    /**
     * 페이징바를 제작하기위해 필요한 값들을 연산해서 반환해주는 메서드
     * 서비스로부터 페이징처리 할 떄 필요한 정보들을 전달받아 연산 수행
     *
     * @param totalCount      :   게시글의 총 개수(db로부터 조회)
     * @param nowPage         :   현재 페이지(요청 파라미터)
     * @param maxDisplayCount :   한 페이지에 표현할 게시글 최대 개수
     * @param pagePerBlock    :
     */
    public Map<String, Object> getPageInfo(int totalCount, int nowPage, int maxDisplayCount, int pagePerBlock) {
        int totalPage = (int) Math.ceil((double) totalCount / (double) maxDisplayCount);
        int beginPage = (nowPage - 1) / pagePerBlock * pagePerBlock + 1;
        int endPage = Math.min(beginPage + pagePerBlock - 1, totalPage);
        int offset = (nowPage - 1) * maxDisplayCount;


        Map<String, Object> result = new HashMap<>();
        result.put("totalCount", totalCount);
        result.put("nowPage", nowPage);
        result.put("display", maxDisplayCount);
        result.put("pagePerBlock", pagePerBlock);
        result.put("totalPage", totalPage);
        result.put("beginPage", beginPage);
        result.put("endPage", endPage);
        result.put("offset", offset);

        return result;
    }

}
