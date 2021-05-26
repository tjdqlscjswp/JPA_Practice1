package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.FreeBoard;
import com.kosta.sbproject.model.FreeBoardReply;

public interface FreeBoardRepository extends CrudRepository<FreeBoard, Long>{
	
	//이름 명명 규칙을 지켜야 한다.
	public List<FreeBoard> findByWriter(String writer);
	

	
}
