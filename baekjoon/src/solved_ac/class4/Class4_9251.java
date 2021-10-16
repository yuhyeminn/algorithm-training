package solved_ac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * LCS
 * 
 * @author hyemin
 * 
 * - LCS (Longest Common SubSequence) -> 최장 공통 부분 수열
 * - 현재 
 * - 점화식을 잘 세우자..
 * - https://st-lab.tistory.com/139
 */
public class Class4_9251 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] s1 = br.readLine().toCharArray();
		char[] s2 = br.readLine().toCharArray();
		
		int len1 = s1.length;
		int len2 = s2.length;
		
		int[][] dp = new int[len1 + 1][len2 + 1];
		
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				
				if(s1[i-1] == s2[j-1]) {
					// 대각선 위의 값에 +1
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				
				// 같지 않으면 이전 열(i-1)과 이전 행(j-1) 둘 중 큰 값으로 갱신
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		
	}
	
}