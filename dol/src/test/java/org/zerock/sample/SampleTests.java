package org.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class) // 현재 테스트 코드가 스프링을 실행하는 역할을 할 것
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml") // 지정된 클래스나 문자열ㅇ르 이용해서 필요한 객체들을 스프링 내에 객체로 등록하게 됨
@Log4j // lombok을 이용해서 로그를 기록하는 logger를 변수로 생성
public class SampleTests {
	
	@Setter(onMethod_ = {@Autowired})
	private Restaurant restaurant; //lombok 사용으로 자동으로 getter/setter 만들어짐
	
	@Test
	public void testExist() {
		assertNotNull(restaurant); // restaurant 변수가 null이 아니어야만 테스트 성공한다는 것을 의미
		
		log.info(restaurant); //log4j 사용함으로써 별도의 Logger객체 선언 X
		log.info("----------");
		log.info(restaurant.getChef());
		
	}
}
