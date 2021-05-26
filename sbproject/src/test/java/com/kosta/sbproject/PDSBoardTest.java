package com.kosta.sbproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.kosta.sbproject.model.PDSBoard;
import com.kosta.sbproject.model.PDSFile;
import com.kosta.sbproject.persistence.PDSBoardRepository;
import com.kosta.sbproject.persistence.PDSFileRepository;

import lombok.extern.java.Log;

@SpringBootTest
@Log
@Commit
public class PDSBoardTest {
	@Autowired
	PDSBoardRepository boardRepo;
	@Autowired
	PDSFileRepository fileRepo;
	//@Test
	public void test1() {
		//pdsboard로 pdsboard와 pdsfile entity를 insert
		
		IntStream.range(1, 6).forEach(i->{
			PDSBoard board = new PDSBoard();
			board.setPname("게시글"+i);
			board.setPwriter("작성자"+i);
			
			List<PDSFile> filelist = new ArrayList<>();
			IntStream.range(1, 4).forEach(j->{
				PDSFile file = new PDSFile();
				file.setPdsfilename("작성자파일"+j);
				filelist.add(file);
			});
			board.setFiles2(filelist);
			boardRepo.save(board);
			
		});
		
		
		
	}
	
	//@Test
	public void test2() {
		//board pid로 File 찾기
		boardRepo.findById(311L).ifPresent(b->{
			System.out.println(b.getPname());
			System.out.println(b.getPwriter());
			System.out.println(b);
			//System.out.println(b.getFiles2().size());
		});
	}
	
	
	
	
	//@Test
	public void test3() {
		//board pid로 File 찾기
		boardRepo.getBoardWithFileCount2().forEach(arr->{
			System.out.println(Arrays.toString(arr));
			//System.out.println(b.getFiles2().size());
		});
	}
	
	//@Test
	public void test4() {
		//board pid로 File 찾기
		boardRepo.getBoardWithFile().forEach(arr->{
			System.out.println(Arrays.toString(arr));
			//System.out.println(b.getFiles2().size());
		});
	}
	
	
	
	//@Transactional//insert, delete, update인 경우(@Query가 ddl). 자동 롤백된다.==> 클래스 단계에서 @Commit을 넣어주면 커밋된다.
	//@Test
	public void test5() {
		int ret = boardRepo.updatePDSFile2(312L, "수정한이름");
		System.out.println(ret+"건 수정");
	}
	
	

	//@Test
	public void test6() {
		fileRepo.findById(322L).ifPresent(file->{
			file.setPdsfilename("전통적인 방법으로 수정, 리포지터리만들어줌");
			fileRepo.save(file);
		});
		
	}
	
	@Test
	public void test7() {
		//Cascade, Eager가 필수
		boardRepo.findById(319L).ifPresent(b->{
			b.setPname("카루소");
			b.setPwriter("aaa");
			List<PDSFile> flist= b.getFiles2();
			PDSFile f = PDSFile.builder().pdsfilename("board로 file 추가").build();
			flist.add(f);
			
			boardRepo.save(b);
		});
		
	}
	
	
	
	
	
	
	
	
	
	
}
