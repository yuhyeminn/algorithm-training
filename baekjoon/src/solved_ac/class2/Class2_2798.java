package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 블랙잭
 * 
 * [해결]
 * 완전 탐색
 */
public class Class2_2798 {
    static int[] cards;
    static int N;
    static int M;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		cards = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(func(0, 0, 0));
	}
	
	public static int func(int sum, int idx, int cnt) {
		if(cnt == 3) {
			return sum > M ? 0 : sum;
		}
		if(idx >= N) {
			return 0;
		}
		int max = 0;
		for(int i= idx; i < N; i++) {
			max = Math.max(max, func(sum + cards[i], i+1, cnt+1));
		}
		return max;
	}
	
}