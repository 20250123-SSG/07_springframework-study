package com.ibe6.webmvc.service;

import com.ibe6.webmvc.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    // 공지사항 전체 목록 조회
    List<NoticeDto> getNoticeAll();

    // 공지사항 상세 조회
    NoticeDto getNoticeByNo(int no);

    // 공지사항 수정
    int modifyNotice(NoticeDto n);
}
