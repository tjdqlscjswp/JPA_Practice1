package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.PDSBoard;

public interface PDSBoardRepository extends CrudRepository<PDSBoard, Long>{
	

	
	@Query("select b.pid, count(f) "
			+ "from PDSBoard b left outer join b.files2 f "
			+ "group by b.pid")
	
	public List<Object[]> getBoardWithFileCount2();
	
	
	
	  @Query("select b.pid, b.pname, b.pwriter, f.fno " +
	  "from PDSBoard b left outer join b.files2 f ") 
	  public List<Object[]> getBoardWithFile();
	  
	  
	  
	  //첨부파일을 수정하기
	  @Modifying
	  @Query("update from PDSFile f set f.pdsfilename = ?2 where f.fno=?1")
	  public int updatePDSFile2(Long fno, String filename);
	  
	 
}
