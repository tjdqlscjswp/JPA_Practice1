package com.kosta.sbproject;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.kosta.sbproject.model.MemberDTO;
import com.kosta.sbproject.model.MemberRoleEnumType;
import com.kosta.sbproject.model.ProfileDTO;
import com.kosta.sbproject.persistence.MemberRepository;
import com.kosta.sbproject.persistence.ProfileRepository;

import lombok.extern.java.Log;

@Log
@SpringBootTest

public class MemberProfileTest {
	@Autowired
	MemberRepository memberRepo;

	@Autowired
	ProfileRepository profileRepo;

	// @Test
	public void sample1() {

		IntStream.range(1, 4).forEach(i -> {
			MemberDTO member = new MemberDTO();
			member.setMid("tjd" + i);
			member.setMname("name!" + i);
			member.setMpassword("1234");
			member.setMrole(MemberRoleEnumType.ADMIN);
			memberRepo.save(member);
		});

		IntStream.range(4, 7).forEach(i -> {
			MemberDTO member = MemberDTO.builder().mid("ppooii" + i).mname("코스타" + i).mpassword("1234")
					.mrole(MemberRoleEnumType.MANAGER).build();
			memberRepo.save(member);
		});
		IntStream.range(7, 10).forEach(i -> {
			MemberDTO member = new MemberDTO("joo" + i, "효연" + i, "1234", MemberRoleEnumType.USER);

			memberRepo.save(member);
		});

	}

	// @Test
	public void sample2() {// 모두조회
		memberRepo.findAll().forEach(i -> {
			log.info(i.toString());
		});

	}

	// @Test
	public void sample3() {
		// Profile테이블에 insert
		MemberDTO member = new MemberDTO();
		member.setMid("joo7");
		IntStream.range(1, 4).forEach(i -> {
			ProfileDTO prof = new ProfileDTO();
			prof.setFname("face" + i + ".jpg");
			if (i == 1) {
				prof.setCurrenYn(true);
			} else
				prof.setCurrenYn(false);

			prof.setMember(member);
			profileRepo.save(prof);
		});

		MemberDTO member2 = new MemberDTO();
		member2.setMid("tjd2");
		IntStream.range(1, 5).forEach(i -> {
			ProfileDTO prof = new ProfileDTO();
			prof.setFname("flower" + i + ".jpg");
			if (i == 1) {
				prof.setCurrenYn(true);
			} else
				prof.setCurrenYn(false);

			prof.setMember(member2);
			profileRepo.save(prof);
		});
	}

	// @Test
	public void sample4() {
		profileRepo.findById(306L).ifPresent(prof -> {
			System.out.println(prof);
			System.out.println(prof.getFname());
			System.out.println(prof.getMember());
			System.out.println(prof.getMember().getMname());

		});
	}

	//@Test
	public void findByMember() {
		//sample5
		//member의 모든 profile, member 정보를 알아내기
		MemberDTO member = MemberDTO.builder().mid("joo7").build();

		profileRepo.findByMember(member).forEach(pro -> {
			System.out.println(pro);
			System.out.println(pro.getMember().getMname());
		});

	}
	
	//@Test
	public void sample6() {
		memberRepo.getMemberWithProfileCount().forEach(arr->{
			System.out.println(Arrays.toString(arr));
		});
	}
	
	@Test
	public void sample7() {
		memberRepo.getMemberWithProfileCount2().forEach(arr->{
			System.out.println(Arrays.toString(arr));
		});
	}
}
