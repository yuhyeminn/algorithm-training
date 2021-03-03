package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 큐
 * @author hyemin
 * 
 */
public class Class2_10845 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int rear = 0;
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push" :
				int num = Integer.parseInt(st.nextToken());
				q.offer(num);
				rear = num;
				break;
			case "pop" :
				num = q.size() != 0?q.poll():-1;
				sb.append(num).append("\n");
				break;
			case "size" :
				sb.append(q.size()).append("\n");
				break;
			case "empty" :
				sb.append(q.isEmpty()==true?1:0).append("\n");
				break;
			case "front" :
				sb.append(q.size() != 0? q.peek():-1).append("\n");
				break; 
			case "back" :
				sb.append(q.size() != 0? rear:-1).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}