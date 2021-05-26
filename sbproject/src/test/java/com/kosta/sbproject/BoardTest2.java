package com.kosta.sbproject;

import javax.print.attribute.standard.PageRanges;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import com.kosta.sbproject.persistence.BoardRepository;

import lombok.extern.java.Log;


@SpringBootTest
@Log
public class BoardTest2 {
	
	@Autowired
	BoardRepository repo;
	
	@Test
	public void boardPagingTest3() {
		System.out.println("*****0page-------------");
		Pageable paging = PageRequest.of(0, 3);
		Pageable paging2 = PageRequest.of(0, 3, Direction.DESC,"bno");
		
	}
	
	
	
	//@Test
	public void test1() {
		//Id말고 다른걸로 조회
		//writer가 "writer1"인 데이터를 검색하기
		repo.findByWriter("writer1").forEach(data->{
			log.info(data.toString());
		});
		
		
	}
	//@Test
	public void test4() {
		//where Title like '%title2%'
		repo.findByTitleContaining("title2").forEach(data->{
			log.info(data.toString());
		});
	}
	
	@Test
	public void test7() {
		repo.findByTitleEndingWithAndBnoGreaterThan("2", 50L).forEach(data->{
			log.info(data.toString());
		});
	}
}
