package com.sotogito.webmvc.service;

import com.sotogito.webmvc.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    //임시 db데이터
    private final List<NoticeDto> dbList = Arrays.asList(
            new NoticeDto(1, "제목1", "내용1"),
            new NoticeDto(2, "제목2", "내용2"),
            new NoticeDto(3, "제목3", "내용3")
    );

    @Override
    public List<NoticeDto> getNoticeAll() {
        return dbList;
    }

    @Override
    public NoticeDto getNoticeByNoticeNo(int noticeNo) {
        return dbList.stream()
                     .filter(notice -> notice.getNo() == noticeNo)
                     .findFirst()
                     .orElse(null);
    }

    @Override
    public int modifyNotice(NoticeDto newNoticeDto) {
        NoticeDto notice = getNoticeByNoticeNo(newNoticeDto.getNo());

        if(notice == null){
            return -1;
        }
        notice.setTitle(newNoticeDto.getTitle());
        notice.setContent(newNoticeDto.getContent());

        return 1;
    }

}
