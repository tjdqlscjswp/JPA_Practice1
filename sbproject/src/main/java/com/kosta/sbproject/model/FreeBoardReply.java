package com.kosta.sbproject.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
@ToString//(exclude = "board")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "rno")
@Table(name = "tbl_free_reply")
public class FreeBoardReply {//Board클래스와 tbl_boards테이블을 연결
	@Id//필수 PK
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long rno;
	
	String reply;
	String replyer;
	
	
	@CreationTimestamp
	Timestamp replyDate;
	@UpdateTimestamp
	Timestamp updateDate;
	
	//한개의 게시물에 여러개의 댓글. 여러 개의 댓글은 하나의 게시글을 참조한다.
	@ManyToOne 
	FreeBoard board; //FK
	

}
