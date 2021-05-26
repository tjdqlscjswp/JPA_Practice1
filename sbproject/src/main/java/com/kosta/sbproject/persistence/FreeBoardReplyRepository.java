package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.FreeBoardReply;

public interface FreeBoardReplyRepository extends CrudRepository<FreeBoardReply, Long>{
	
	@Query("select r.rno, count(b) "
			+ "from FreeBoardReply r left outer join r.board b "
			+ "group by r.rno")
	public void findByBoardBno();
}
