package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 회의실 배정
 * @author hyemin
 * 
 * [해결]
 * 끝나는 시간을 기준으로 오름차순 정렬해서 해결
 * -> 끝나는 시간이 빨라야 최대로 사용할 수 있음
 */
public class Class3_1931 {
	
 	public static void main(String[] args) throws Exception {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		
 		int N = Integer.parseInt(br.readLine());
 		List<Time> list = new ArrayList<>();
 		for(int i=0;i<N;i++) {
 			StringTokenizer st = new StringTokenizer(br.readLine());
 			int start = Integer.parseInt(st.nextToken());
 			int end = Integer.parseInt(st.nextToken());
 			list.add(new Time(start, end));
 		}
 		
 		Collections.sort(list);
 		
 		int result = 0;
 		int end_time = 0;
 		for(int i=0;i<list.size();i++) {
 			Time t = list.get(i);
 			if(end_time <= t.start) {
 				end_time = t.end;
 				result++;
 			}
 		}
 		
 		System.out.println(result);
	}
 	
 	static class Time implements Comparable<Time>{
 		int start;
 		int end;
 		
 		public Time(int start, int end) {
 			this.start = start;
 			this.end = end;
 		}

		@Override
		public int compareTo(Time o) {
			// TODO Auto-generated method stub
			if(o.end == this.end) {
				return this.start - o.start;
			}
			return this.end - o.end;
		}
 	}
	
}
