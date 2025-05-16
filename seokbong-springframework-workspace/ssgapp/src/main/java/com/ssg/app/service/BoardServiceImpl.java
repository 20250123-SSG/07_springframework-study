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
public class BoardServiceImpl implements BoardService{

    private final SqlSessionTemplate sqlSession;
    private final PageUtil pageUtil;
    private final FileUtil fileUtil;

    @Override
    public Map<String, Object> getBoardsAndPaging(int page) { // int page == 현재 요청한 페이지 번호

        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int totalCount = boardMapper.selectBoardListCount();
        Map<String, Object> map = pageUtil.getPageInfo(totalCount, page, 5, 5);
        List<BoardDto> list = boardMapper.selectBoardList(map);
        map.put("list", list); // map : {totalPage:xx, beginPage:xx, endPage:xx, ..., list:List<BoardDto>}

        return map;
    }

    @Override
    public int registBoard(BoardDto board, List<MultipartFile> uploadFiles) {
        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int result = boardMapper.insertBoard(board);
        if(result > 0 && uploadFiles != null){
            for(MultipartFile file : uploadFiles){
                if(file != null && !file.getOriginalFilename().equals("")){
                    Map<String, String> map = fileUtil.fileupload("board",file);
                    AttachDto attach = AttachDto.builder()
                            .filePath(map.get("filePath"))
                            .filesystemName(map.get("filesystemName"))
                            .originalName(map.get("originalFileName"))
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
        List<AttachDto> list = boardMapper.selectAttachByBoardNo(no);

        Map<String, Object> map = new HashMap<>();
        map.put("board", board);
        map.put("list", list);

        return map;
    }
}
