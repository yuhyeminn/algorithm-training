package baekjoon.dynamic_programming;

/**
 * 2133 타일 채우기
 * 3×N 크기의 벽을 2×1, 1×2 크기의 타일로 채우는 경우의 수를 구해보자.
 *
 * [입력]
 * 첫째 줄에 N(1 ≤ N ≤ 30)이 주어진다.
 * 
 * [출력]
 * 첫째 줄에 경우의 수를 출력한다.
 */
public class Tilling_2133 {

	public static int[] memo = new int[1001];
	
	//점화식 : 3 * D[n-2] + (2 * D[n-4] + 2 * D[n-6] + ... + 2* D[0])
	public static int tilling(int x) {
		if(x == 0) return 1;
		if(x == 1) return 0;
		if(x == 2) return 3;
		if(memo[x] != 0) return memo[x];
		int result = 3 * tilling(x-2);
		for(int i=3;i<=x;i++) {
			if(i%2==0) {
				result += 2 * tilling(x - i);
			}
		}
		return memo[x] = result;
	}
	
	public static void main(String[] args) {
		int x = 8;
		System.out.println("3 * "+x+" 크기의 직사각형을 채우는 방법의 수 = " + tilling(x));
	}
}
