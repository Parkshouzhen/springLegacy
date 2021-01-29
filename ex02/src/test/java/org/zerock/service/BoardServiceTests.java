package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.persistence.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;

	@Test
	public void testPrint() {
		log.info(service);
	}

	@Test
	public void testGetList() {

		service.getList().forEach(board -> log.info(board));
	}

	@Test
	public void testRegister() {

		BoardVO vo = new BoardVO();
		vo.setTitle("Test 테스트1");
		vo.setContent("마흔두살 박소분1");
		vo.setWriter("박소분1");

		long bno = service.register(vo);
		log.info("bno: " + bno);
	}

	@Test
	public void testRemove() {

		int delete = service.remove(13L);
		log.info("게시물삭제: " + delete);
	}

	@Test
	public void testUpdate() {

		BoardVO vo = new BoardVO();

		vo.setBno(11L);
		vo.setTitle("하잉");
		vo.setWriter("소분이");
		vo.setContent("수정안함!");
		
		log.info("count: " + service.modify(vo)); // modify 메소드 기능을 해주어야 하나??
//		BoardVO vo = new BoardVO();
//
//		vo.setBno(12L);
//		vo.setTitle("수정테스트");
//		vo.setWriter("소분수정");
//		vo.setContent("박소분이야나는");
//
//		log.info("count: " + service.modify(vo));
	}

}
