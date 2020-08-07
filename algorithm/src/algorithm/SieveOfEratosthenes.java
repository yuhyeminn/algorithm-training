package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 에라토스테네스의 체
 * - 가장 대표적인 소수(Prime Number) 판별 알고리즘
 * 
 * 1. 이차원 배열을 생성하여 값을 초기화 함
 * 2. 2부터 시작하여 특정 숫자의 배수에 해당하는 숫자들을 모두 지움
 * 3. 이미 지워진 숫자의 경우 건너 뜀
 * 4. 2부터 시작하여 남아있는 숫자들을 출력함 -> 소수
 */
public class SieveOfEratosthenes {

	static int number = 100;
	static int arr[] = new int[number+1];
	
	public static void main(String[] args) {
		primeNumberSieve();
	}
	
	public static void primeNumberSieve() {
		//1. 배열 값 초기화
		for(int i=2;i<arr.length;i++) {
			arr[i] = i;
		}
		
		//2. 2부터 시작하여 특정 숫자의 배수에 해당하는 숫자들을 모두 지움
//		for(int i=2;i*i<arr.length;i++) {
		for(int i=2;i<arr.length;i++) {
			//3. 이미 지워진 숫자의 경우 건너 뜀
			if(arr[i] == 0) continue;
			for(int j = i + i; j < arr.length; j += i) {
				arr[j] = 0;
			}
		}
		
		//4. 2부터 시작하여 남아있는 숫자들을 출력함
		for(int i=2; i<arr.length; i++) {
			if(arr[i] != 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	//프로그래머스 소수판별 문제
	//return : n까지의 소수 개수
	/* 에라토스네스의 체 */
	public static int solution(int n) {
		boolean prime[] = new boolean[n+1];
		List<Integer> list = new ArrayList<>();
		
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
