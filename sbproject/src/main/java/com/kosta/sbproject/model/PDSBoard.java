package com.kosta.sbproject.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Entity
@Builder @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "pid")
@Table(name = "tbl_pdsboard")

public class PDSBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long pid;
	String pname;
	String pwriter;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="pdsno") //PDSFlie의 테이블에 pdsno칼럼이 생긴다.
	List<PDSFile> files2;
	/*
	 @OneToMany : 기본적으로 중간테이블이 생긴다. : pid, fno 칼럼을 가지는.
	 @JoinColumn(name="pdsno")추가
	 tbl_pdsfile 테이블에 pdsno칼럼이 생긴다.
	 tbl_pdsboard 테이블에는 칼럼이 추가되지 않는다. 다치 불가능하기 때문. 즉 한 row에 여러건 쓸 수 없기 때문.
	 pdsno 가 pid를 뜻한다. 둘이 조인하기 때문
	 
	 FetchType : lazy, eager
	 
	 
	 영속전이
	 부모 또는 자식이 변경되면 연관관계 엔티티 모두에 영향을 준다.
	 cascade = CascadeType.ALL
	 */

}
