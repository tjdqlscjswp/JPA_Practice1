package com.kosta.sbproject.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode(of = "mid") //mid만 같으면 같은 걸로 취급하겠다. of={"mid", "mname"}-> 두개만 같으면 같은 걸로 취급
@Entity
@Table(name="tbl_members")
public class MemberDTO {
	@Id
	String mid;
	String mname;
	String mpassword;
	@Enumerated(EnumType.STRING)
	MemberRoleEnumType mrole;
}
