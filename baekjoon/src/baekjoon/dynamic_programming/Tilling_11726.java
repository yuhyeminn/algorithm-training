package baekjoon.dynamic_programming;

/**
 * 11726 2xn 타일링
 * 2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.
 *
 * [입력]
 * 첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)
 * 
 * [출력]
 * 첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.
 */
public class Tilling_11726 {
	
	public static int[] memo = new int[1001];
	public static int tilling(int x) {
		//가장 마지막에 오는 타일을 기준으로 생각했을 때, 가능 한 경우는 두가지 경우 (나머지 타일의 길이가 N-1,N-2 일 때)
		//점화식 : D[i] = D[i-1] + D[i-2]
		if( x == 1 ) return 1;
		if( x == 2 ) return 2;
		if(memo[x] != 0) return memo[x];
		return memo[x] = (tilling(x-1) + tilling(x-2)) % 1007;
	}
	
	public static void main(String[] args) {
		int x = 9;
		System.out.println("2 * "+x+" 크기의 직사각형을 채우는 방법의 수 = " + tilling(x));
	}
}
