package solved_ac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 평범한 배낭
 * 
 * @author hyemin
 * 
 * - 배낭 문제 (Knapsack)
 *   -> 냅색 알고리즘은 짐을 쪼갤 수 있는 경우와 없는 경우로 나뉨
 *   -> 쪼갤 수 있는 경우 탐욕법(greedy)으로 해결, 쪼갤 수 없는 경우는 DP를 사용하여 해결함
 * - 이해하기 어려움 (정리 필수)
 */
public class Class4_12865 {
	
	static int result;
	static int N,K;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int things[][] = new int[N+1][2];	//[무게, 가치]
		int dp[][] = new int[N+1][K+1];		
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			things[i][0] = Integer.parseInt(st.nextToken()); 
			things[i][1] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=K;j++) {
				// 이전 누적값 저장
				int pre_val = dp[i-1][j];
				dp[i][j] = pre_val;
				
				// 물건을 더 넣을 수 있는 경우
				if(things[i][0] <= j) {
					// 현재 가치 : 자신의 가치 + 남은 무게의 누적 가치
					int now_val = things[i][1] + dp[i-1][j-things[i][0]] ;
					dp[i][j] = Math.max(pre_val, now_val);
				}
			}
		}
		
		System.out.println(dp[N][K]);
		
	}

}