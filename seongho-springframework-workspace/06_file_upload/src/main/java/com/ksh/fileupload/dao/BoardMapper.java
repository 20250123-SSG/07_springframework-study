package com.ksh.fileupload.dao;

import com.ksh.fileupload.dto.AttachmentDto;
import com.ksh.fileupload.dto.BoardDto;

public interface BoardMapper {
    int insertBoard(BoardDto board);
    int insertAttach(AttachmentDto attach);
}
