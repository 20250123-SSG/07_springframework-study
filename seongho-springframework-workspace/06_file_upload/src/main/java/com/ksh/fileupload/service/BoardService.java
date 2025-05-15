package com.ksh.fileupload.service;

public interface BoardService {
    //한개의 첨부파일이 있는 게시글 등록용 서비스
    int registOneFileBoard();
    //다수의 첨부파일이 있는 게시글 등록용 서비스
    int registManyFileBoard();
}
