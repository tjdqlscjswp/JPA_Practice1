package com.kosta.sbproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.sbproject.model.Board;
import com.kosta.sbproject.model.CarVO;
import com.kosta.sbproject.model.DeptVO;
import com.kosta.sbproject.persistence.BoardRepository;
import com.kosta.sbproject.persistence.DeptRepository;

@RestController
public class Sample2RestController {
	@Autowired
	BoardRepository brepo;
	@Autowired
	DeptRepository deptRep;
	
	
	@RequestMapping("/hello")
	public String greeting() {
		return "안녕하세요";
	}
	
	@RequestMapping("/car")
	public CarVO getCar() {
		CarVO car = new CarVO("sm7", 1000, "samsung");
		return car;
	}
	
	@RequestMapping("/carlist")
	public List<CarVO> getCarList() {
		CarVO car1 = new CarVO("sm7", 1000, "samsung");
		CarVO car2 = new CarVO("aa", 1000, "hs");
		List<CarVO> carlist = new ArrayList<>();
		carlist.add(car1);
		carlist.add(car2);
		return carlist;
	}
	
	@RequestMapping("/boardlist")
	public Iterable<Board> boardList(){
		return brepo.findAll();
	}
	
	@RequestMapping("/board/{bno}")
	public Board selectById(@PathVariable Long bno) {
		return brepo.findById(bno).get();
		
	}
	
	@RequestMapping("/deptlist")
	public Iterable<DeptVO> deptList(){
		return deptRep.findAll();
	}
}
