package algorithm.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 큐(Queue)
 * - FIFO 선입선출(First In First Out) 구조를 가지는 자료구조
 *
 */
public class QueueClass {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
		
		q.offer("hello");
		q.offer("world");
		System.out.println(q.peek());	//hello
		
		q.offer("!");
		q.poll();	//hello 삭제
		System.out.println(q.toString()); //world, !
		
		System.out.println(q.element());
		while(q.isEmpty()==false){
			System.out.println(q.poll());
			//world, i 순서로 삭제
		}		
		System.out.println(q.toString()); //world, !
	}
}
