package programmers.code_challenge.challenge_1105;

import java.util.Arrays;

public class Challenge02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "01110";
		System.out.println(Arrays.toString(solution(s)));
	}
	static int[] answer;
	public static int[] solution(String s) {
		answer = new int[2];
		
		binary(s);
		
		return answer;
	}
	
	public static void binary(String s) {
		answer[0]++;
		int cnt = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) == '1') {
				cnt++;
			}else {
				answer[1]++;
			}
		}
		
		if(cnt > 1) {
			binary(Integer.toBinaryString(cnt));
		}else {
			return;
		}
	}

}
