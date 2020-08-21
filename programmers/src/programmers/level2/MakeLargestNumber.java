package programmers.level2;

import java.util.Arrays;
import java.util.Collections;

/*탐욕법*/
public class MakeLargestNumber {

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 2;
		
		System.out.println("result="+solution(number,k));
	}
	
	public static String solution(String number, int k) {
		String answer = "";
		
		String[] arr = number.split("");
		Arrays.sort(arr, Collections.reverseOrder());
		System.out.println(Arrays.toString(arr));
		
		return answer;
	}
}
