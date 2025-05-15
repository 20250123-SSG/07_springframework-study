package com.ino.fileupload.dao;

import com.ino.fileupload.dto.AttachmentDto;
import com.ino.fileupload.dto.BoardDto;

public interface BoardMapper {
    int insertBoard(BoardDto board);
    int insertAttachment(AttachmentDto attachment);
}
