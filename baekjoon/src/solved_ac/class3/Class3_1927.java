package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 최소 힙
 * @author hyemin
 *
 * [헤결]
 * 간단히 PriorityQueue 사용
 */
public class Class3_1927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		Queue<Integer> queue = new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(queue.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(queue.poll());
				}
			}else {
				queue.add(num);
			}
		}
	}
}
