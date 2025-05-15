package com.jjanggu.fileupload.dao;

import com.jjanggu.fileupload.dto.AttachmentDto;
import com.jjanggu.fileupload.dto.BoardDto;

public interface BoardMapper {

    int insertBoard(BoardDto boardDto);

    int insertAttach(AttachmentDto attachmentDto);
}
