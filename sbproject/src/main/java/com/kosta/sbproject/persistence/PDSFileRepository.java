package com.kosta.sbproject.persistence;

import org.springframework.data.repository.CrudRepository;

import com.kosta.sbproject.model.PDSFile;

public interface PDSFileRepository extends CrudRepository<PDSFile, Long>{
	
}
