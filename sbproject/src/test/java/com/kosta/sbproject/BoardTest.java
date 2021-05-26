package com.kosta.sbproject;



import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.Board;
import com.kosta.sbproject.persistence.BoardRepository;

import lombok.extern.java.Log;

@SpringBootTest
@Log
public class BoardTest {
	
	@Autowired
	BoardRepository boardrepo;
	
	//@Test
	//repository의 정보들. 내부적으로 들어있는 모양들을 알아본다. 현재 클래스의 이름, 
	public void repoInfo() {
		Class<?> bclass = boardrepo.getClass();
		System.out.println(bclass.getName());
		Class<?>[] interf =bclass.getInterfaces();
		Stream.of(interf).forEach(inter->{
			System.out.println(inter.getName());
			
		});
		System.out.println(bclass.getSuperclass().getName());
	}
	
	//@Test
	public void insertBoard() {
		Board b = new Board();
		b.setTitle("게시물의 제목2");
		b.setContent("게시물의 내용2");
		b.setWriter("작성자2");
		boardrepo.save(b);
	}
	
	//@Test //여러건 insert
	public void insertBoard2() {
		IntStream.range(1, 101).forEach(i->{
			Board b = new Board();
			b.setTitle("board title" + i);
			b.setContent("board content"+i);
			b.setWriter("writer"+i%10);
			boardrepo.save(b);
		});
	}
	
	
	//@Test
	public void selectAll() {
		boardrepo.findAll().forEach(board->{
			System.out.println(board);
			
		});
	}
	
	//@Test
	public void selectById() {
		Board board = boardrepo.findById(10L).get();
		log.info("게시판정보" + board.toString());
	}
	
	//@Test
	public void updateBoard() {
		boardrepo.findById(10L).ifPresent(board->{
			board.setTitle("title 수정");
			board.setContent("content 수정");
			board.setWriter("강성빈");
			boardrepo.save(board);
		});
	}
	
	//@Test
	public void deleteBoard10() {
		Long id = 10L;
		//if(boardrepo.findById(id).isPresent()) {
			boardrepo.deleteById(id);
		//}
			
	}
	@Test
	public void countBoard() {
		Long cnt = boardrepo.count();
		log.info("board건수 : "+cnt);
	}
	

}
