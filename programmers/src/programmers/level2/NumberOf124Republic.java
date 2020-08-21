package programmers.level2;

/**
 * 124나라의 숫자
 * 
 * [문제]
 * 124 나라가 있습니다. 124 나라에서는 10진법이 아닌 다음과 같은 자신들만의 규칙으로 수를 표현합니다.
 * 		124 나라에는 자연수만 존재합니다.
 * 		124 나라에는 모든 수를 표현할 때 1, 2, 4만 사용합니다.
 * 
 * 자연수 n이 매개변수로 주어질 때, n을 124 나라에서 사용하는 숫자로 바꾼 값을 return 하도록 solution 함수를 완성해 주세요.
 * 
 * [제한사항]
 * n은 500,000,000이하의 자연수 입니다.
 */
public class NumberOf124Republic {

	public static void main(String[] args) {
		int n = 6;
		System.out.println("result="+solution(n));
	}
	
	public static String solution(int n) {
		String answer = "";
		String numbers[] = {"4","1","2"};
		
		while(n > 0) {
			int m = n%3;
			n = n/3;
			
			//n이 3으로 나누어 떨어질 경우 몫에 -1함
			if(m == 0) n--;
			
			answer = numbers[m] + answer;
		}
		
		return answer;
	}
}
