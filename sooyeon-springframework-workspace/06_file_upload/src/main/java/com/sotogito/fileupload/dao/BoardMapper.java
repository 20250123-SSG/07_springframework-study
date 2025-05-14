package com.sotogito.fileupload.dao;

import com.sotogito.fileupload.dto.AttachmentDto;
import com.sotogito.fileupload.dto.BoardDto;

public interface BoardMapper {

    int insertBoard(BoardDto board);

    int insertAttach(AttachmentDto attachment);
}
