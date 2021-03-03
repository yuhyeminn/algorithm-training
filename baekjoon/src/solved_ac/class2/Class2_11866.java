package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 요세푸스 문제 0
 * @author hyemin
 * 
 */
public class Class2_11866 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		
		int cnt = 0;
		int arr[] = new int[N];
		int idx = 0;
		while(!q.isEmpty()) {
			cnt++;
			if(cnt == K) {
				int num = q.poll();
				arr[idx++] = num; 
				cnt = 0;
			}else {
				q.add(q.poll());
			}
		}
		
		//출력
		sb.append("<");
		for(int i=0;i<arr.length;i++) {
			if(i < arr.length - 1) {
				sb.append(arr[i])
				  .append(", ");
			}else {
				sb.append(arr[i]);
			}
		}
		sb.append(">");
		System.out.println(sb);
	}
	
}