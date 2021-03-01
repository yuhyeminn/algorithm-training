package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 수 정렬하기 2
 * 
 * [해결]
 * Arrays.sort() -> 시간초과
 * Collections.sort() 사용 -> O(nlogn)을 보장함
 * 
 * 계수정렬 사용 <- 훨씬 빠름
 *
 */
public class Class2_2751 {
    
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(list);
		for(Integer n : list) {
			sb.append(n).append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	// 다른사람 풀이
	// 계수정렬
	public static void test() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
    
		boolean[] arr = new boolean[2000001];
		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000] = true;
		}

		for(int i = 0; i < arr.length; i++) {
			if(arr[i]) {
				sb.append((i - 1000000)).append('\n');
			}
		}
		
		System.out.print(sb);
	}
	
	
}