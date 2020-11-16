package programmers.level2;

/**
 * 점프와 순간 이동
 *
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 * 
 */
public class JumpAndTeleportation {

	public static void main(String[] args) {
		int N = 5000;
		System.out.println("result="+solution(N));
		
	}

	 public static int solution(int n) {
	 
		 int cnt = 0;
		 while(n != 0) {
			 if(n%2 == 0) {
				 n /= 2;
			 }else {
				 n = (n-1)/2;
				 cnt++;
			 }
		 }
		 
		 return cnt;
	 }
}
