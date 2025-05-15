package com.ino.webmvc.service;

import com.ino.webmvc.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    // Get All Notice List
    List<NoticeDto> getAllNotice();

    // Get Detail Notice
    NoticeDto getNoticeByNo(int no);

    // Edit Notice
    int editNotice(NoticeDto noticeDto);
}
