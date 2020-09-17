package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.io.BufferedWriter;
//import java.util.Stack;

/**
 * 크게 만들기
 * N자리 숫자가 주어졌을 때, 여기서 숫자 K개를 지워서 얻을 수 있는 가장 큰 수를 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ K < N ≤ 500,000)
 * 둘째 줄에 N자리 숫자가 주어진다. 이 수는 0으로 시작하지 않는다.
 * 
 * [출력]
 * 입력으로 주어진 숫자에서 K개를 지웠을 때 얻을 수 있는 가장 큰 수를 출력한다.
 */
public class Greedy_2812 {
	//시간 : 212ms
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		String num = br.readLine();
		int arr[] = new int[num.length()];
		for(int i=0;i<num.length();i++){
			arr[i] = num.charAt(i)-'0';
		}
		int index=0;
		for(int i=0;i<n-k;i++) {
			int max = 0;
			for(int j=index;j<=i+k;j++) {
				if(max < arr[j]) {
					max = arr[j];
					index = j + 1;
					/* 분기해주지 않으면 시간초과남 */
					if(max == 9) {
						break;
					}
				}
			}
			sb.append(max);
		}
		System.out.println(sb.toString());
	}
	
	/* 시간 : 352ms
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int K = k;
		String num = br.readLine();
		Stack<Character> stack = new Stack<>();
		String result = "";
		int idx = 0;
		
		while(idx!=num.length()) {
			while(k!=0 && !stack.empty() && stack.peek() < num.charAt(idx)) {
				stack.pop();
				k--;
			}
			stack.add(num.charAt(idx));
			idx++;
		}
		for(int i=0;i<n-K;i++) {
			bw.write(stack.get(i));
		}
		
		bw.flush();
	}
	*/
}
