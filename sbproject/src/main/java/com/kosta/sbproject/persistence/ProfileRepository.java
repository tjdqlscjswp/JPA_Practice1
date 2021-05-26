package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.MemberDTO;
import com.kosta.sbproject.model.ProfileDTO;

public interface ProfileRepository 
	extends CrudRepository<ProfileDTO, Long>{
	
	public List<ProfileDTO> findByMember(MemberDTO mem);
	public List<ProfileDTO> findByFname(String fname);

}
