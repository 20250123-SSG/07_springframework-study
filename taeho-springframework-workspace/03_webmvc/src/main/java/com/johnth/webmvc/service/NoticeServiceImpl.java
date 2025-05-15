package com.johnth.webmvc.service;

import com.johnth.webmvc.dto.NoticeDto;

import java.util.Arrays;
import java.util.List;

public class NoticeServiceImpl implements NoticeService {

    private List<NoticeDto> noticeList = Arrays.asList(
            new NoticeDto(1, "제목1", "내용1"),
            new NoticeDto(2, "제목2", "내용2"),
            new NoticeDto(3, "제목3", "내용3")
    );

    @Override
    public List<NoticeDto> getNoticeAll() {
        return List.of();
    }

    @Override
    public NoticeDto getNoticeByNo(int no) {
        NoticeDto noticeDto = null;
        for (NoticeDto noticeDto1 : noticeList) {
            if(no == noticeDto1.getNo()) {
                noticeDto = noticeDto1;
            }
        }
        return noticeDto;
    }

    @Override
    public int modifyNotice(NoticeDto notice) {
        int result = 0;
        for (NoticeDto noticeDto1 : noticeList) {
            if(noticeDto1.getNo() == notice.getNo()) {
                noticeDto1.setTitle(notice.getTitle());
                noticeDto1.setContent(notice.getContent());
                result++;
            }
        }
        return result;
    }
}
