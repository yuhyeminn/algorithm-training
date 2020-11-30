package coding_test.nhn_godo;

import java.util.Arrays;

public class Godo04 {

	public static void main(String[] args) {
		String cardNumber = "21378";
		System.out.println(solution(cardNumber));

	}

	public static String solution(String cardNumber){
		String answer = "";
		StringBuilder sb = new StringBuilder();
		
		String[] arr = cardNumber.split("");
		int start = arr.length%2==0?0:1;
		for(int i = start;i<arr.length;i += 2) {
			int target = Integer.parseInt(arr[i]);
			arr[i] = String.valueOf(target*2);
		}
		
		for(int i=0;i<arr.length;i++) {
			sb.append(arr[i]);
		}
		
		String str = sb.toString();
		int sum = 0;
		for(int i=0;i<str.length();i++) {
			sum += str.charAt(i)-'0';
		}
		answer = sum%10==0?"VALID":"INVALID";
        
		return answer;
    }
}
