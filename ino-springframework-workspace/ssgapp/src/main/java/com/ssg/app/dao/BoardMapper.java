package com.ssg.app.dao;

import com.ssg.app.dto.AttachDto;
import com.ssg.app.dto.BoardDto;

import java.util.List;
import java.util.Map;

public interface BoardMapper {
    int selectBoardListCount();
    List<BoardDto> selectBoardList(Map<String, Object> map);
    int insertBoard(BoardDto board);
    int insertAttach(AttachDto attach);
}
