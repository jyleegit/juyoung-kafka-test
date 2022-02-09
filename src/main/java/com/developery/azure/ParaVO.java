package com.developery.azure;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParaVO {
		String myEmailBody;
		String mySubject;
		String myEmailAddress;
		String testData;
}
