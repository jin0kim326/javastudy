package prob04;

import java.util.Arrays;

public class StringUtil {
	public static String concatenate(String[] str) {
		//문자열을 결합하여 리턴 하는 메소드
		String resultStr = "";
		for(int i=0; i<str.length; i++) {	
			resultStr = resultStr + str[i];
		}
		return resultStr;
	}
}
