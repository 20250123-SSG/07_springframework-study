package com.ssg.app.service;

import com.ssg.app.dao.BoardMapper;
import com.ssg.app.dto.AttachDto;
import com.ssg.app.dto.BoardDto;
import com.ssg.app.util.FileUtil;
import com.ssg.app.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final static String FILE_SAVE_PATH = "board";
    private final static int MAX_DISPLAY_COUNT = 5;
    private final static int PAGE_PER_BLOCK = 5;

    private final SqlSessionTemplate sqlSession;
    private final PageUtil pageUtil;
    private final FileUtil fileUtil;


    @Override
    public Map<String, Object> getBoardsAndPaging(int page) { /// int page == 현재 요청한 페이지 번호
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int totalCount = boardMapper.selectBoardListCount();
        Map<String, Object> result = pageUtil.getPageInfo(totalCount, page, MAX_DISPLAY_COUNT, PAGE_PER_BLOCK);
        List<BoardDto> boardList = boardMapper.selectBoardList(result);
        result.put("boardList", boardList);

        return result;
    }

    @Override
    public int registBoard(BoardDto board, List<MultipartFile> uploadfileList) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int result = boardMapper.insertBoard(board);

        if (result > 0 && uploadfileList != null) {
            for (MultipartFile file : uploadfileList) {
                if (file != null && !file.getOriginalFilename().equals("")) {

                    Map<String, String> fileInfo = fileUtil.fileupload(FILE_SAVE_PATH, file);
                    AttachDto attach = AttachDto.builder()
                            .filePath(fileInfo.get("filePath"))
                            .filesystemName(fileInfo.get("filesystemName"))
                            .originalName(fileInfo.get("originalFilename"))
                            .refBoardNo(board.getBoardNo())
                            .build();

                    result += boardMapper.insertAttach(attach);
                }
            }
        }
        return result;
    }

    @Override
    public Map<String, Object> getBoardDetail(int no) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        BoardDto board = boardMapper.selectBoardByNo(no);
        List<AttachDto> attachList = boardMapper.selectAttachByBoardNo(no);

        Map<String, Object> boardInfo = new HashMap<>();
        boardInfo.put("board", board);
        boardInfo.put("attachList", attachList);

        return boardInfo;
    }

}
