package programmers.level1;

/**
 * 정수 제곱근 판별
 * 
 * [문제]
 * 임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
 * n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고, n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
 *
 * [제한사항]
 * n은 1이상, 50000000000000 이하인 양의 정수입니다.
 * 
 * [입출력 예]
 * 121 -> 144
 * 3 -> -1
 */
public class SquareRoot {

	public static void main(String[] args) {
		long n = -50;
//		long n = 3;
		System.out.println("return = " + SquareRoot.solution(n));
	}
	
	public static long solution(long n) {
		long answer = -1;
		
		double d = Math.sqrt(n);
		int i = (int)Math.sqrt(n);
		
		if(i == d) {
//			answer = (i+1)*(i+1); //오류
			answer = (long) Math.pow(i+1, 2);
		}else {
			answer = -1;
		}
		return answer;
	}
}
