package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;

public interface BoardService { //메소드
	
	Long register(BoardVO board);
	// public void register(BoardVO board);
	//void register(BoardVO board);
	
	public BoardVO get(Long bno);
	
	int modify(BoardVO board);
	
	int remove(Long bno);
	
	List<BoardVO> getList();
}
