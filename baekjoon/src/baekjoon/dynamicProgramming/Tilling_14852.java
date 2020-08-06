package baekjoon.dynamicProgramming;

/**
 * 14852 타일 채우기 3
 * 2×N 크기의 벽을 2×1, 1×2, 1×1 크기의 타일로 채우는 경우의 수를 구해보자.
 *
 * [입력]
 * 첫째 줄에 N(1 ≤ N ≤ 1,000,000)이 주어진다.
 * 
 * [출력]
 * 첫째 줄에 경우의 수를 1,000,000,007로 나눈 나머지를 출력한다.
 */
public class Tilling_14852 {

//	public static long[] memo = new long[1000001];
	public static long[][] memo = new long[1000001][2];
	
	public static long tilling(int x) {
		memo[0][0] = 0;
		memo[1][0] = 2;
		memo[2][0] = 7;
		memo[2][1] = 1;
		for(int i=3;i<=x;i++) {
			memo[i][1] = (memo[i-1][1] + memo[i-3][0]) % 1000000007;
			memo[i][0] = (3 * memo[i-2][0] + 2 * memo[i-1][0] + 2 * memo[i][1]) % 1000000007;
		}
		return memo[x][0];
	}
	
	/*
	//시간초과
	//점화식 : 3 * D[i-2] + 2 * D[i-1] + 2 (D[i-3] + D[i-4] + ... + D[0])
	public static long tilling(int x) {
		if(x == 0) return 1;
		if(x == 1) return 2;
		if(x == 2) return 7;
		if(memo[x] > 0) return memo[x];
		long result = 3 * tilling(x-2) + 2 * tilling(x-1);
		for(int i=3;i<=x;i++) {
			result += (2 * tilling(x-i)) % 100000007;
		}
		return memo[x] = result % 100000007;
	}
	*/
	
	public static void main(String[] args) {
		int x = 3;
		System.out.println("2 * "+x+" 크기의 직사각형을 채우는 방법의 수 = " + tilling(x));
	}
}
