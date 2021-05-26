package com.kosta.sbproject.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.kosta.sbproject.model.Board;

public interface BoardRepository 
	extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{
	//기본 제공 : findAll() , findById(), save(), count(), exists()
	//추가
	public List<Board> findByWriter(String writer);
	public List<Board> findByTitle(String title);
	public List<Board> findByContent(String content);
	
	
	public List<Board> findByTitleContaining(String title);
	public List<Board> findByTitleStartingWith(String title);
	public List<Board> findByTitleEndingWith(String title);
	
	public List<Board> findByTitleEndingWithAndBnoGreaterThan(String title, Long bno);
	
	
	//JPQL(Java Persistence Query Language)
	//함수이름은 내가정함
	//JAP entity를 사용한다. Board라는 엔티티이름을 쓴다. 테이블아 아닌.
	
	@Query("select b from Board b where b.title like %?1% order by b.bno desc ")
	public List<Board> findByTitle2(String title);
	
	@Query("select b from Board b where b.title like %?1% and b.bno > ?2 order by b.bno desc ")
	public List<Board> findByTitleAndBno(String title, Long bno);
	
	
	//@Param 이용하기
	@Query("select b from Board b where b.content like %:content% and b.bno > :bno order by b.bno desc ")
	public List<Board> findByContent(@Param("content") String cc, @Param("bno") Long bno);
	
	@Query("select b from #{#entityName} b where b.writer like %?1% ")
	public List<Board> findByWriter2(String writer);
	
	
	//DB에 국한된 SQL문 사용하기
	
	  @Query(value = "select * from tbl_boards where writer = ? order by 1", nativeQuery = true) 
	  public List<Board> findByWriter3(String writer);
	  
	
	  @Query(value = "select bno,substr() from tbl_boards where writer = ? order by 1", nativeQuery = true) 
	  public List<Board> findByWriter4(String writer);
	  
	  @Query(value = "select d.department_name, e.first_name, e.salary, e.hire_date "
	  		+ "from employees e join departments d using(department_id) ", nativeQuery = true)
	  public List<Object[]> selectAllEmp();
	  
	  //쿼리와 페이징
	  @Query("select b from #{#entityName} b where b.writer like %?1% ")
	  public Page<Board> findWriterPaging(String writer, Pageable paging);
	  
	 
	
}
