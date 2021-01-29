package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService {
	// 인터페이스를 쓰는 이유: 실제 객체가 뭔지 모르게 하기 위해?

	private final BoardMapper mapper; // final 자동으로 주입을 해준다??

	@Override
	public Long register(BoardVO board) {

		mapper.insertSelectKey(board);
		return board.getBno();

	}

	@Override
	public BoardVO get(Long bno) {

		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {

		return mapper.update(board);
	}

	@Override
	public int remove(Long bno) {

		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {

		return mapper.getList();
	}

}
