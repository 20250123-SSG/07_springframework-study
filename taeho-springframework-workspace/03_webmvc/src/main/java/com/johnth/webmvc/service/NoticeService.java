package com.johnth.webmvc.service;

import com.johnth.webmvc.dto.NoticeDto;

import java.util.List;

public interface NoticeService {

    List<NoticeDto> getNoticeAll();

    NoticeDto getNoticeByNo(int no);

    int modifyNotice(NoticeDto notice);
}
