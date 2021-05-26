package com.kosta.sbproject;

import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.kosta.sbproject.model.FreeBoard;
import com.kosta.sbproject.model.FreeBoardReply;
import com.kosta.sbproject.persistence.FreeBoardReplyRepository;
import com.kosta.sbproject.persistence.FreeBoardRepository;

import lombok.extern.java.Log;
@Commit
@SpringBootTest
@Log
public class FreeBoardTest {
	
	@Autowired
	FreeBoardRepository boardRepo;
	@Autowired
	FreeBoardReplyRepository replyRepo;
	
	
	@Transactional
	@Test
	public void selectAllReplies() {
		replyRepo.findByBoardBno();
	}
	
	
	
	
	//@Transactional
	//@Test
	public void test6() {
		boardRepo.findById(531L).ifPresent(b->{
			System.out.println(b.getReplies().size()+"개의 댓글");
		});
	}
	
	//@Transactional //FetchType.LAZY 인경우 반드시사용. EAGER인 경우 미사용
	//@Transctional 사용하면 종료 후에 자동으로 rollback된다... @Commit을 클래스 레벨에 달아줘야함.
	//@Test
	//332번 board에 댓글 남기기
	public void test4() {
		boardRepo.findById(332L).ifPresent(board->{
			List<FreeBoardReply> rlist = board.getReplies();
			IntStream.range(1, 6).forEach(i->{
				FreeBoardReply reply = FreeBoardReply.builder()
						.reply("!!댓글작성 332번..내용"+i)
						.replyer("!!댓글작성 332..작성자"+i)
						.board(board)
						.build();
				rlist.add(reply);
			});
			boardRepo.save(board);
		});
	}
	
	
	//@Transactional
	//@Test
	//531번 board에 댓글 남기기
	public void test5() {
		boardRepo.findById(531L).ifPresent(board->{
			List<FreeBoardReply> rlist = board.getReplies();
			IntStream.range(11, 14).forEach(i->{
				FreeBoardReply reply = FreeBoardReply.builder()
						.reply("댓글 531번..내용"+i)
						.replyer("댓글 531..작성자"+i)
						.board(board)
						.build();
				rlist.add(reply);
			});
			boardRepo.save(board);
		});
	}
	
	//작성자가 writer9인 board들 찾기.
	//@Test
	public void test3() {
		boardRepo.findByWriter("writer9").forEach(board->{
			System.out.println(board);
		});
	}
	
	
	//@Test
	public void test1() {
		IntStream.range(1, 201).forEach(i->{
			FreeBoard board = FreeBoard.builder()
					.title("FreeBoard title" + i)
					.content("FreeBoard content"+i)
					.writer("writer"+i%10)
					.build();
			boardRepo.save(board);
		});
	}
	

	//@Test
	public void test2() {
		boardRepo.findAll().forEach(board->{
			System.out.println(board);
		});
	}


}
