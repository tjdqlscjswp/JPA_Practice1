package com.kosta.sbproject;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.DeptVO;
import com.kosta.sbproject.persistence.DeptRepository;

import lombok.extern.java.Log;

@SpringBootTest
@Log
public class DeptTest {
	@Autowired
	DeptRepository deptRep;
	
	
	@Test
	public void test11() {
		deptRep.selectById(300L).forEach(data->{
			log.info("1 : "+data.toString());
		});
	}
	@Test
	public void test12() {
		deptRep.selectById2(300L).forEach(data->{
			log.info("2 : "+data.toString());
		});
	}
	@Test
	public void test13() {
		deptRep.selectById3(300L).forEach(data->{
			log.info("3 : "+data.toString());
		});
	}
	@Test
	public void test14() {
		deptRep.selectById4(300L).forEach(data->{
			log.info("4 : "+data.toString());
		});
	}
	
	
	
	//@Test
	public void test10() {
		deptRep.selectAll().forEach(dept->{
			log.info(dept.toString());
		});
	}
	
	
	
	//@Test
	public void test9() {
		deptRep.findByDepartmentName("부서이름10").forEach(d->{
			log.info(d.toString());
		});
	}
	
	//@Test
	public void patternInsert() {
		IntStream.range(200,211).forEach(i->{
			DeptVO dept = DeptVO.builder()
					.departmentName("영업부"+i)
					.managerId(i)
					.locationId(i)
					.build();
			deptRep.save(dept);
		});
	}
	
	//@Test
	public void insertDept() {
		DeptVO dept = new DeptVO();
		dept.setDepartmentId(1L);
		dept.setDepartmentName("부서1");
		dept.setLocationId(1);
		dept.setManagerId(10);
		deptRep.save(dept);
	}

	//@Test //여러건 insert
	public void insertDept2() {
		IntStream.range(10, 101).forEach(i -> {
			DeptVO dept = new DeptVO();
			dept.setDepartmentName("부서이름"+i);
			dept.setLocationId(i);
			dept.setManagerId(i%10);
			deptRep.save(dept);
		});
		
		for(int i = 120;i<130;i++) {
			DeptVO dept = new DeptVO((long) i,"개발부"+i,i,i+10);
			deptRep.save(dept);
		}
	}
	
	//@Test
	public void findAllDept() {
		deptRep.findAll().forEach(dept->{
			System.out.println(dept);
			
		});
	}
	
	//@Test
	public void findByDeptId() {
		
		Optional<DeptVO>dept = deptRep.findById(10L);
		dept.ifPresent(d->{
			log.info(d.toString());
		});
				
	}
	
	//@Test
	public void updateDept() {
		deptRep.findById(10L).ifPresent(dept->{
			dept.setDepartmentName("수정된 이름");
			dept.setLocationId(1111);
			dept.setManagerId(1111);
			deptRep.save(dept);
		});
	}
	
	//@Test
	public void deleteDept() {
		deptRep.deleteById(10L);
		
	}
	
}
