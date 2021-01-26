package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component //해당 클래스가 스프링에서 관리해야하는 대상임을 표시
@Data //Lombok의 setter를 생성하는 기능과 생성자, toString() 등을 자동으로 생성하도록 하는 어노테이션
public class Restaurant {
	
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
	// @Data : toString, EqualsAndhashCode, Getter/Setter, RequiredArgsConstructor
	// Restaurant 클래스파일 보면 확인할 수 있음

}
