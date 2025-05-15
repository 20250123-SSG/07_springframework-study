package com.johnth.fileupload.dao;

import com.johnth.fileupload.dto.AttachmentDTO;
import com.johnth.fileupload.dto.BoardDTO;

public interface BoardMapper {
    int insertBoard(BoardDTO boardDTO);
    int insertAttach(AttachmentDTO attachmentDTO);
}
