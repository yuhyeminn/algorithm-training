package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 덱(Deque)
 * @author hyemin
 * 
 */
public class Class2_10866 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> q = new LinkedList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push_front" :
				q.addFirst(Integer.parseInt(st.nextToken()));
				break;
			case "push_back" :
				q.addLast(Integer.parseInt(st.nextToken()));
				break;
			case "pop_front" :
				sb.append(q.size() != 0?q.pollFirst():-1).append("\n");
				break;
			case "pop_back" :
				sb.append(q.size() != 0?q.pollLast():-1).append("\n");
				break;
			case "size" :
				sb.append(q.size()).append("\n");
				break;
			case "empty" :
				sb.append(q.isEmpty()==true?1:0).append("\n");
				break;
			case "front" :
				sb.append(q.size() != 0? q.peekFirst():-1).append("\n");
				break; 
			case "back" :
				sb.append(q.size() != 0? q.peekLast():-1).append("\n");
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}