package com.kosta.sbproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.CustomLog;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity // JPA가 관리한다는 의미
@Table(name = "tbl_dept",
uniqueConstraints = {@UniqueConstraint(name = "unique2",columnNames = {"manager_id", "location_id"})}	//DB에 만들어지는 이름을 줘야함(@Column(name="manager_id", nullable = true))
		)
public class DeptVO {
	@Id //필수
	@GeneratedValue(strategy = GenerationType.AUTO) 
	//자동으로 증가하며 시퀀스를 만든다. 자동 증가시에 필요, 정책이 DB마다 다르다.
	//AUTO(SEQUENCE, IDENTITY) DB정책에 따라 자동으로 시퀀스생성
	//hibernate_sequence가 자동생성되어 사용된다. 
	// SEQUENCE : insert시에 hibernate_sequence.nextval 사용
	// IDENTITY : AUTO_increment 사용
	
	Long departmentId;
	@Column(name="dept_name", unique = true, nullable = false, length = 30)
	String departmentName;
	
	@Column(name="manager_id", nullable = true)
	int managerId; 
	
	@Column(name = "location_id", nullable = true)
	int locationId;

}
