package com.podoseee.fileupload.dao;

import com.podoseee.fileupload.dto.AttachmentDto;
import com.podoseee.fileupload.dto.BoardDto;

public interface BoardMapper {
    int insertBoard(BoardDto board);
    int insertAttach(AttachmentDto attach);
}
