package com.podoseee.webmvc.service;

import com.podoseee.webmvc.dto.NoticeDto;

import java.util.Arrays;
import java.util.List;

public class NoticeServiceImpl implements NoticeService {

    // db상에 존재하는 공지사항 목록이라는 가정
    private List<NoticeDto> dbList = Arrays.asList(
            new NoticeDto(1, "제목1", "내용1"),
            new NoticeDto(2, "제목2", "내용2"),
            new NoticeDto(3, "제목3", "내용3")
    );

    @Override
    public List<NoticeDto> getNoticeAll() {
        NoticeDto notice = null;
        for(NoticeDto n : dbList){
            if(n.getNo() == no){
                notice = n;
            }
        }
        return notice;
    }

    @Override
    public NoticeDto getNoticeByNo(int no) {
        for(NoticeDto n : dbList){
            if(n.getNo() == no){
                return n;
            }
        }
        return null;
    }

    @Override
    public int modifyNotice(NoticeDto n) {
        int result = 0;
        for(NoticeDto notice : dbList){
            if(notice.getNo() == n.getNo()){
                notice.setTitle(n.getTitle());
                notice.setContent(n.getContent());
                result = 1;
            }
        }
        return result;
    }
}
