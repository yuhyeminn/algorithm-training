package solved_ac.class3;

import java.io.IOException;
import java.util.Scanner;

/**
 * 1, 2, 3 더하기
 * 
 * @author hyemin
 * 
 * [해결]
 * - dynamic programming
 * - dp[n] = dp[n-3] + dp[n-2] + dp[n-1]  (n>=3)
 */
public class Class3_9095 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int result = dp(sc.nextInt());
			sb.append(result).append("\n");
		}
		
		System.out.println(sb.toString());

	}

	private static int dp(int n) {
		if(n==1) return 1; 	//1
		if(n==2) return 2; 	//1+1, 2
		if(n==3) return 4;	//1+1+1, 1+2, 2+1, 3
		
		return dp(n-3) + dp(n-2) + dp(n-1);
	}

}
