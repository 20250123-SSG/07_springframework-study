package com.younggalee.fileupload.dao;

import com.younggalee.fileupload.dto.AttachmentDto;
import com.younggalee.fileupload.dto.BoardDto;

public interface BoardMapper {
    int insertBoard(BoardDto board);
    int insertAttach(AttachmentDto attach);
}
