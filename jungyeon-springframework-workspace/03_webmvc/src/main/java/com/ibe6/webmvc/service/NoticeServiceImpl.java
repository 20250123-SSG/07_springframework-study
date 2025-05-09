package com.ibe6.webmvc.service;

import com.ibe6.webmvc.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService{

    // db상에 존재하는 공지사항 목록이라는 가정
    private List<NoticeDto> dbList = Arrays.asList(
            new NoticeDto(1, "제목1", "내용1"),
            new NoticeDto(2, "제목2", "내용2"),
            new NoticeDto(3, "제목3", "내용3")
    );

    @Override
    public List<NoticeDto> getNoticeAll() {
        return dbList;
    }

    @Override
    public NoticeDto getNoticeByNo(int no) {
        NoticeDto notice = null;
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
