package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardMapper {

	List<BoardVO> getList();
	
	void insert(BoardVO vo);
	
	void insertSelectKey(BoardVO vo);
	
}
