package solved_ac.class2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 카드2
 * https://www.acmicpc.net/problem/2164
 * 
 * [해결]
 * Queue 활용
 */
public class Class2_2164 {
    
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.offer(i);
		}
		
		while(q.size()>1) {
			q.poll();
			int num = q.poll();
			q.offer(num);
		}
		System.out.println(q.poll());
	}
	
}