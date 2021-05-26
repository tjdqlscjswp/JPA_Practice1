package com.kosta.sbproject.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tbl_boards")
public class Board {//Board클래스와 tbl_boards테이블을 연결
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
	
	

}
