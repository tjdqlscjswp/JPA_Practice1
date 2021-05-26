package com.kosta.sbproject.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString//(exclude = "replies")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "bno")
@Table(name = "tbl_freeboards")
public class FreeBoard {//Board클래스와 tbl_boards테이블을 연결
	@Id//필수 PK
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long bno;
	
	String title;
	String writer;
	String content;
	
	@CreationTimestamp
	Timestamp regDate;
	@UpdateTimestamp
	Timestamp updateDate;
	
	@OneToMany(mappedBy = "board", //FreeBoardReply.java의 FK
			cascade = CascadeType.ALL)
	List<FreeBoardReply> replies;//댓글이 오지 않는게 디폴트. 내 정보가 아니기때문이다. -> fetch eager를 하면 FreeBoard를 통해 replies의 정보도 불러올수있다.

}
