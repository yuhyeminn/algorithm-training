package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 숫자 카드 2
 * @author hyemin
 * 
 * [해결]
 * Map or Array
 */
public class Class2_10816 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int key = Integer.parseInt(st.nextToken());
			map.put(key, map.getOrDefault(key, 0)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			int card = Integer.parseInt(st.nextToken());
			int cnt = map.get(card)==null?0:map.get(card);
			sb.append(cnt).append(" ");
		}
		
		System.out.println(sb.toString());
	}
	
	// 다른사람 풀이
	// 수 전체 범위 크기의 배열 이용
	public void solution2() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		
		int size = Integer.parseInt(br.readLine());
		
		int[] num = new int[20000001];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < size; i++) {
			num[Integer.parseInt(st.nextToken())+10000000]++;
		}
		
		int size2 = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < size2; i++) {
			sb.append(num[Integer.parseInt(st.nextToken())+10000000]).append(" ");
		}
		
		System.out.println(sb);
	}

}