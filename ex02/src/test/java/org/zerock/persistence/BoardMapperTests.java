package org.zerock.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		log.info("-----------");
		boardMapper.getList();
	}
	
	@Test
	public void testInsert() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("Test 테스트");
		vo.setContent("마흔살 박소분");
		vo.setWriter("박소분");
		
		boardMapper.insert(vo);
		log.info("--------------------------");
		log.info("after insert" + vo.getBno());
		
	}
	
	@Test
	public void testInsertSelectKey() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("Test 테스트2");
		vo.setContent("마흔한살 박소분");
		vo.setWriter("박소분짱");
		
		boardMapper.insertSelectKey(vo);
		
		log.info("--------------------------------");
		log.info("after insert selectKey" + vo.getBno());
	}
	
	@Test
	public void testRead() {
		
		BoardVO vo = boardMapper.read(9L);
		log.info(vo);
	}
	
	@Test
	public void testDelete() {
		int count = boardMapper.delete(3L);
		log.info("count: " + count);
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = new BoardVO();
		
		vo.setBno(5L);
		vo.setTitle("하잉방가");
		vo.setWriter("잇츠미소분");
		vo.setContent("박소분이야나는");
		
		log.info("count: " + boardMapper.update(vo));
	
	}
}
