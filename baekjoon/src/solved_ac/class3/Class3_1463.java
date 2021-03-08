package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 1로 만들기
 * https://www.acmicpc.net/problem/1463
 * @author hyemin
 *
 * [해결]
 * https://m.blog.naver.com/PostView.nhn?blogId=occidere&logNo=220787315353&proxyReferer=https:%2F%2Fwww.google.com%2F
 * - Top-down
 * - Bottom-up
 */
public class Class3_1463 {

	static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		
//		System.out.println(top_down(N));
		System.out.println(bottom_up(N));
	}
	
	static int top_down(int n) {
		if(n==1) return arr[n];
		if(arr[n]>0) return arr[n];
		
		int min = Integer.MAX_VALUE;
		if(n%3==0) min = Math.min(min, top_down(n/3));
		if(n%2==0) min = Math.min(min, top_down(n/2));
		min = Math.min(min, top_down(n-1));
		
		return arr[n] = min + 1;
	}
	
	static int bottom_up(int n) {
		for(int i=2;i<=n;i++) {
			arr[i] = arr[i-1]+1;
			if(i%2==0) arr[i] = Math.min(arr[i], arr[i/2]+1);
			if(i%3==0) arr[i] = Math.min(arr[i], arr[i/3]+1);
		}
		return arr[n];
	}

}
