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

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final SqlSessionTemplate sqlSession;
    private final PageUtil pageUtil;
    private final FileUtil fileUtil;

    @Override
    public Map<String, Object> getBoardsAndPaging(int page) { // int page == 현재 요청 페이지 번호

        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int totalCount = boardMapper.selectBoardListCount();

        Map<String, Object> map = pageUtil.getPageInfo(totalCount, page, 5, 5);

        List<BoardDto> list = boardMapper.selectBoardList(map);
        map.put("list", list);
        return map;
    }

    @Override
    public int registBorad(BoardDto board, List<MultipartFile> uploadFiles) {

        BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);

        int result = boardMapper.insertBoard(board);

        if (result > 0 && uploadFiles != null) {
            for (MultipartFile file : uploadFiles) {
                if (file != null && !file.getOriginalFilename().equals("")) {
                    Map<String, String> map = fileUtil.fileupload("board", file);
                    AttachDto attachDto = AttachDto.builder()
                            .filePath(map.get("filePath"))
                            .filesystemName(map.get("filesystemName"))
                            .originalName(map.get("originalFilename"))
                            .refBoardNo(board.getBoardNo())
                            .build();
                    result += boardMapper.insertAttach(attachDto);
                }
            }
        }
        return result;
    }
}
