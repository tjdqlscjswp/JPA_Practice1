package com.kosta.sbproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString @Entity
@Builder @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(of = "fno")
@Table(name = "tbl_pdsfile")



public class PDSFile {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long fno;
	String pdsfilename;

}
