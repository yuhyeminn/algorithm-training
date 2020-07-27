package programmers.level1;

import java.util.ArrayList;
import java.util.List;

/**
 * 소수 찾기
 * 
 * [문제]
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
 *
 * [제한조건]
 * n은 2이상 1000000이하의 자연수입니다.
 */
public class PrimeNumberSearch {

	public static void main(String[] args) {
		int n = 10;
		System.out.println("result = "+PrimeNumberSearch.solution(n));
	}
	
	/* 에라토스네스의 체 */
	public static int solution(int n) {
		boolean prime[] = new boolean[n+1];
		List<Integer> list = new ArrayList<>();
		int answer = 0;
		
		//기본값 false. 소수 아닌 것은 true로 변경
		//소수는 false
		//0과 1은 소수가 아니므로 제외함
		prime[0] = prime[1] = true;
		
		for(int i=2;i*i<=n;i++) {
			//prime[i]가 소수라면
			if(!prime[i]) {
				//prime[i]의 배수는 소수 아님
				for(int j=i*i;j<=n;j+=i) prime[j] = true;
			}
		}
		
		for(int i=2;i<=n;i++) {
			if(!prime[i]) list.add(i);
		}
		return list.size();
	}
}
