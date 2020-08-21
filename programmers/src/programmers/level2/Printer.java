package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {

	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		System.out.println("result="+solution(priorities,location));
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 1;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i=0;i<priorities.length;i++) {
			pq.offer(priorities[i]);
		}
		
		while(!pq.isEmpty()) {
			for(int i=0;i<priorities.length;i++) {
				int num = pq.peek();
				if(num == priorities[i]) {
					if(location == i) {
						return answer;
					}
					pq.poll();
					answer++;
				}
			}
		}
		return answer;
	}
}
