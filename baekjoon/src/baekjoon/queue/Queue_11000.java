package baekjoon.queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 강의실 배정
 * 
 * @author hyemin
 * 
 * [해결]
 * 강의 시작 시간 기준으로 오름차순 정렬 - 같을 경우 종료시간으로 오름차순 정렬
 * 	-> 우선순위큐에 시작시간순서대로 넣어 비교하기 위해
 * 
 */
public class Queue_11000{

	public static void main(String[] args) throws Exception{
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int start, end;
		Lecture lectures[] = new Lecture[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			lectures[i] = new Lecture(start, end);
		}
		
		Arrays.sort(lectures);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(lectures[0].end);
		for(int i=1;i<N;i++) {
			Lecture now = lectures[i];
			// 가장 작은 종료시간보다 다음 시작시간이 클 경우
			// 사용하던 강의실을 그대로 사용
			if(pq.peek() <= now.start) {
				pq.poll();
			}
			pq.add(now.end);
		}
		
		System.out.println(pq.size());
		System.out.println(pq.toString());
		
	}
	
	public static class Lecture implements Comparable<Lecture> {
		int start;
		int end;
		
		public Lecture(int start, int end) {
			super();
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Lecture o) {
			// 시작시간 같을 경우 끝나는 시간 기준으로 오름차순
			if(this.start == o.start) {
				return this.end - o.end;
			}
			// 시작시간 오름차순
			return this.start - o.start;
		}
	}
	
}
