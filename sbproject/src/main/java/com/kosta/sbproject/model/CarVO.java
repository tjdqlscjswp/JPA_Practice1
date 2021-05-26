package com.kosta.sbproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
@RequiredArgsConstructor
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder


public class CarVO {
	
	@NonNull
	String model;
	
	int price;
	
	@NonNull
	String company;
	

}
