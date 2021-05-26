package com.kosta.sbproject;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


import com.kosta.sbproject.model.Board;
import com.kosta.sbproject.model.QBoard;
import com.kosta.sbproject.persistence.BoardRepository;
import com.querydsl.core.BooleanBuilder;
@lombok.extern.java.Log
@SpringBootTest
public class BoartTest3_Query {
	@Autowired
	BoardRepository repo;
	
	//@Test
	public void test1() {
		repo.findByTitle2("2").forEach(b->{
			log.info(b.toString());
		});
		
	}
	
	//@Test
	public void test2() {
		repo.findByTitleAndBno("2", 150L).forEach(b->{
			log.info(b.toString());
		});
		
	}
	
	//@Test
	public void test3() {
		repo.findByContent("2", 170L).forEach(b->{
			log.info(b.toString());
		});
	}
	
	//@Test
	public void test4() {
		repo.findByWriter2("2").forEach(b->{
			log.info(b.toString());
		});
	}
	
	//@Test
	public void test5() {
		repo.findByWriter3("2").forEach(b->{
			log.info(b.toString());
		});
	}
	
	
	//@Test
	public void test7() {
		repo.selectAllEmp().forEach(arr->{
			log.info(Arrays.toString(arr));
			System.out.println("직원이름 : "+arr[1]);
		});
	}
	
	//@Test
	public void test8() {
		Pageable paging = PageRequest.of(0,5);
		Page<Board> result = repo.findWriterPaging("8", paging);
		List<Board> blist = result.getContent();
		for(Board b:blist) {
			System.out.println(b);
		}
	}
	
	@Test public void test9() {
		String type="title";
		String keyword = "9"; // title에 9들어간 걸 찾는다.
		BooleanBuilder builder = new BooleanBuilder();
		QBoard board = QBoard.board; //보드 만듦
		if(type.equals("title")) {
			builder.and(board.title.like("%"+keyword+"%"));
		}
		builder.and(board.bno.gt(90L));
		//where title like '%?1%' and bno>90
		Pageable paging = PageRequest.of(0, 5);
		Page<Board> result = repo.findAll(builder, paging);
		List<Board> blist = result.getContent();
		blist.forEach(data->{
			System.out.println(data);
		});
		
	}
}
