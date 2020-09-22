package baekjoon.sieve_of_eratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 소수 구하기
 * M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.
 * 
 * [출력]
 * 한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.
 *
 */
public class SOE_1929 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] str = br.readLine().split(" ");
		
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		boolean arr[] = new boolean[M+1];
		
		arr[1] = true;
		int len = (int)Math.sqrt(M);
		for(int i=2;i<=len;i++) {
			if(arr[i]) continue;
			for(int j=i*2;j<=M;j+=i) {
				arr[j] = true;
			}
		}
		
		for(int i=N; i<=M;i++) {
			if(!arr[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
}
