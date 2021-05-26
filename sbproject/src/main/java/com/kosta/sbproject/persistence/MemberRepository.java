package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.MemberDTO;

public interface MemberRepository extends CrudRepository<MemberDTO, String> {
	
	@Query(value = "select m.mid, count(p.FNO)\r\n"
			+ "from tbl_members m left outer join tbl_profile p on (m.mid = p.member_mid)\r\n"
			+ "group by m.mid", nativeQuery = true)

	public List<Object[]> getMemberWithProfileCount();
	
	
	
	
	@Query("select m.mid, count(p) "
			+ "from MemberDTO m left outer join ProfileDTO p on (m.mid = p.member) "
			+ "group by m.mid")

	
	public List<Object[]> getMemberWithProfileCount2();

}
