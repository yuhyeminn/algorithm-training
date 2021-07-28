package baekjoon.two_pointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 부분합
 * 
 * @author hyemin
 * 
 * **
 * 투포인터 알고리즘 : 두 개의 포인터를 두고, 그 포인터들을 이동 시키면서 답을 구해나가는 알고리즘
 * -> 부분합이 S보다 작으면 오른쪽 포인터를 오른쪽으로, S보다 크면 왼쪽 포은터를 오른쪽으로 이동하면서 해결
 */
public class TP_1806{

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long S = Long.parseLong(st.nextToken());	//100,000,000 이하
		
		int arr[] = new int[N]; 
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = 0;	// 부분합
		int first = 0;	// 첫번째 포인터
		int second = 0;	// 두번째 포인터
		int min = 100001; 	// 결과값 -> 가장 짧은 길이 (N<100000)
		while(true) {
			// sum < S 경우를 먼저 판별할 경우 틀림 -> second포인터가 늘어나는 부분에서 index 초과 발생가능
			if(sum >= S) {
				sum -= arr[first++];
				min = Math.min(min, (second-first)+1);
			}else if(second == N) {
				break;
			}else {
				sum += arr[second++];
			}
		}
		
		// 합을 만들 수 없는 경우
		if(min == 100001) {
			System.out.println(0);
		}else {
			System.out.println(min);
		}
	}
}
