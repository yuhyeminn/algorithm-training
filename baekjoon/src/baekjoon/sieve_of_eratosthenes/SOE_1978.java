package baekjoon.sieve_of_eratosthenes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소수 찾기 1978
 * 주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.
 * 
 * [출력]
 * 주어진 수들 중 소수의 개수를 출력한다.
 * 
 */
public class SOE_1978 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int nums[] = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		int arr[] = new int[1001];
		arr[1] = 1;
		for(int i=2;i<arr.length;i++) {
			for(int j = i * 2; j < arr.length; j += i) {
				if(arr[j] == 1) continue;
				arr[j] = 1;
			}
		}
		int count = 0;
		for(int i=0;i<N;i++) {
			if(arr[nums[i]]==0) count++;
		}
		
		System.out.println(count);
	}
	
}
