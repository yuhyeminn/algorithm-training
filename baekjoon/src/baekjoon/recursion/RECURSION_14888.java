package baekjoon.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연산자 끼워넣기
 * @author hyemin
 * 
 * [https://covenant.tistory.com/224] - part2.재귀 탐색의 기본
 * 
 */
public class RECURSION_14888 {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int nums[];
	static int op[];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		nums = new int[N];
		op = new int[4];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<4;i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(nums[0],1);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}
	
	public static void dfs(int num, int idx) {
		// 모든 연산자를 사용했을 경우
		if(idx==N) {
			MAX = Math.max(MAX, num);
			MIN = Math.min(MIN, num);
			return;
		}
		
		for(int i=0;i<4;i++) {
			//연산자 개수가 1개 이상
			if(op[i] > 0) {
				
				op[i]--;
				
				switch(i) {
				
				case 0: dfs(num+nums[idx], idx+1);
					break;
				case 1: dfs(num-nums[idx], idx+1);
					break;
				case 2: dfs(num*nums[idx], idx+1);
					break;
				case 3: dfs(num/nums[idx], idx+1);
					break;
				}
				
				// 재귀호출 끝나면 원상복귀
				op[i]++;
			}
			
		}
		
	}

}
