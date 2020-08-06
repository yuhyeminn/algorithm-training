package algorithm;

/**
 * 동적 프로그래밍 (Dynamic Programming)
 * - 하나의 문제는 단 한번만 풀도록 하는 알고리즘
 * - 분할 정복 기법은 동일한 문제를 다시 푼다는 단점을 갖고 있음.
 * - 메모제이션이 사용된다는 점에서 분할 정복과 다름
 * - Top-Down과 Bottom-Up 방식
 * 
 * 메모제이션 : 이미 계산한 내용들을 저장해두고, 다시 연산 할 필요없이 저장된 데이터를 불러오는 것.
 * Top-Down : 큰 문제에서 작은 부분문제를 재귀적으로 호출하여 리턴된 값으로 문제를 해결
 * Bottom-Up : 작은 부분문제를 미리계산해 두고 모아서 큰 문제를 해결
 * 
 * [참고]
 * https://hongku.tistory.com/161
 * 
 * --DP적용하여 푸는 문제
 * 1. Coin Change Problem
 * 2. KnapSack
 * 3. LCS
 * 4. LIS
 * 5. Edit Distance
 * 6. Matrix Chain Multiplication
 */
public class DynamicProgramming {
	//메모제이션 배열
	public static double[] memo = new double[50];
	
	public static void main(String[] args) {
//		System.out.println("10번째 항 = "+ DynamicProgramming.fibonacci(10));
		System.out.println("10번째 항 = "+ DynamicProgramming.dynamicFibonacci(10));
	}
	
	// 일반적인 피보나치수열 x번째 항 구하기
	public static double fibonacci(int x) {
		if(x == 1) return 1;
		if(x == 2) return 1;
		return fibonacci(x-1) + fibonacci(x-2);
	}
	
	// 동적프로그래밍을 적용한 피보나치수열 x번째 항 구하기
	public static double dynamicFibonacci(int x) {
		if(x == 1) return 1;
		if(x == 2) return 1;
		if(memo[x]!=0) return memo[x];
		return memo[x] = dynamicFibonacci(x-1) + dynamicFibonacci(x-2);
	}
}
