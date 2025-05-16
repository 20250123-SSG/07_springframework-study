package com.ibe6.fileupload.dao;

import com.ibe6.fileupload.dto.AttachmentDto;
import com.ibe6.fileupload.dto.BoardDto;

public interface BoardMapper {
    int insertBoard(BoardDto board);
    int insertAttach(AttachmentDto attach);
}
