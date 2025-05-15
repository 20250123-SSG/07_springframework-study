package com.ino.webmvc.service;

import com.ino.webmvc.dto.NoticeDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoticeServieImpl implements NoticeService{

    private List<NoticeDto> noticeList = new ArrayList<>(
            List.of(
                    new NoticeDto(1, "첫 번째 공지", "첫 번째 공지 내용입니다."),
                    new NoticeDto(2, "두 번째 공지", "두 번째 공지 내용입니다."),
                    new NoticeDto(3, "세 번째 공지", "세 번째 공지 내용입니다."),
                    new NoticeDto(4, "네 번째 공지", "네 번째 공지 내용입니다."),
                    new NoticeDto(5, "다섯 번째 공지", "다섯 번째 공지 내용입니다.")
            )
    );

    @Override
    public List<NoticeDto> getAllNotice() {
        return noticeList;
    }

    @Override
    public NoticeDto getNoticeByNo(int no) {
        for(NoticeDto n : getAllNotice()) {
            if(n.getNo() == no) {
                return n;
            }
        }
        return null;
    }

    @Override
    public int editNotice(NoticeDto noticeDto) {
        for (int i = 0; i < noticeList.size(); i++) {
            NoticeDto existingNotice = noticeList.get(i);
            if (existingNotice.getNo() == noticeDto.getNo()) {
                existingNotice.setTitle(noticeDto.getTitle());
                existingNotice.setContent(noticeDto.getContent());
                // 리스트의 해당 인덱스에 수정된 객체를 다시 설정
                noticeList.set(i, existingNotice);
                return 1; // 수정 성공 시 1 반환
            }
        }
        return 0; // 해당 번호의 공지를 찾지 못한 경우 0 반환
    }
}
