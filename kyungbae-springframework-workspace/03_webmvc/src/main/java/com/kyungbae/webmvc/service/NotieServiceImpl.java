package com.kyungbae.webmvc.service;

import com.kyungbae.webmvc.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NotieServiceImpl implements NoticeService{

    private List<NoticeDto> dbList = Arrays.asList(
            new NoticeDto(1, "공지1", "내용1"),
            new NoticeDto(2, "공지2", "내용2"),
            new NoticeDto(3, "공지3", "내용3")
    );

    @Override
    public List<NoticeDto> getNoticeAll() {
        return dbList;
    }

    @Override
    public NoticeDto getNoticeByNo(int no) {
        NoticeDto notice = null;
        for (NoticeDto n : dbList){
            if(n.getNo() == no){
                notice = n;
            }
        }
        return notice;
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
