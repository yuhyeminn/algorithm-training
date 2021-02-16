package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 차이를 최대로
 * N개의 정수로 이루어진 배열 A가 주어진다. 이때, 배열에 들어있는 정수의 순서를 적절히 바꿔서 다음 식의 최댓값을 구하는 프로그램을 작성하시오.
 * 	|A[0] - A[1]| + |A[1] - A[2]| + ... + |A[N-2] - A[N-1]|
 * 
 * [입력]
 * 첫째 줄에 N (3 ≤ N ≤ 8)이 주어진다. 둘째 줄에는 배열 A에 들어있는 정수가 주어진다. 
 * 배열에 들어있는 정수는 -100보다 크거나 같고, 100보다 작거나 같다.
 * 
 * [출력]
 * 첫째 줄에 배열에 들어있는 수의 순서를 적절히 바꿔서 얻을 수 있는 식의 최댓값을 출력한다.
 * 
 * [참고]
 * https://velog.io/@sonch96/boj10819
 */
/*
 1. 만들 수 있는 모든 순서의 배열을 다 만듦(완전 탐색)
 2. 만든 배열의 값을 계산하여 최댓값 구함
 */
public class Greedy_10819 {
 
	static int N;
	static int max;
	static int[] nums;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		visited = new boolean[N];
		int[] selected = new int[N]; //빈 배열
		max = 0;
		
		for( int i=0 ; i < N ; i++ ) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		func(0, selected);
		
		System.out.println(max);
	}
	
	public static void func(int cnt, int[] selected) {
		// N만큼 탐색한 경우 max값과 비교
		if(cnt == N) {
			int sum = getMax(selected);
			if(max < sum) {
				max = sum;
			}
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				visited[i] = true;
				
				selected[cnt] = nums[i];
				func(cnt + 1, selected);
				
				visited[i] = false;
			}
		}
	}

	private static int getMax(int[] arr) {
		int sum = 0;
		for(int i = 0 ; i < N - 1 ;i++) {
			sum += Math.abs(arr[i] - arr[i+1]);
		}
		return sum;
	}
}
