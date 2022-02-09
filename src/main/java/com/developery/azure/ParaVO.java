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
@Builder
public class ParaVO {
		private String myEmailBody;
		private String mySubject;
		private String myEmailAddress;
		private String testData;
		
		public ParaVO(String myEmailBody, String mySubject, String myEmailAddress, String testData) {
			this.myEmailBody = myEmailBody;
			this.mySubject = mySubject;
			this.myEmailAddress = myEmailAddress;
			this.testData = testData;
		}
		
		public ParaVO() {
			this.myEmailBody = null;
			this.mySubject = null;
			this.myEmailAddress = null;
			this.testData = null;
		}
}


