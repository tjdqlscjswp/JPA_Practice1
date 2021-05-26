package com.kosta.sbproject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.CarVO;

import lombok.extern.java.Log;

//JUNIT
@Log
@SpringBootTest

class SbprojectApplicationTests {
	
	//@Test
	public void lombokTest1() {
		CarVO car1 = new CarVO();
		CarVO car2 = new CarVO("abcd", 1000, "samsung");
		CarVO car3 = new CarVO("ABC모델", "기아");
		CarVO car4 = new CarVO("ABC모델", "기아");
		System.out.println(car1);
		System.out.println(car2);
		System.out.println(car3);
		System.out.println(car2.getModel());
		System.out.println(car1.equals(car2));
		System.out.println(car3.equals(car4));
		
	}
	
	@Test
	public void lombokTest2() {
		CarVO car1 = CarVO.builder().model("BMW520").price(5000).company("bmw").build();
		
		log.info(car1.toString());
	}
	
	
	

	@Test
	void contextLoads() {
	}

}
