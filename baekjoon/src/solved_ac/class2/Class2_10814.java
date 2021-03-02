package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 나이순 정렬
 * https://www.acmicpc.net/problem/10814
 *
 * 다른사람풀이 참고해서 다시 풀어보기 - 계수정렬, StringBuilder배열 사용
 */
public class Class2_10814 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		List<Member> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.add(new Member(name, age, i));
		}
		
		Collections.sort(list);
		
		for(Member m : list) {
			sb.append(m.age)
			  .append(" ")
			  .append(m.name)
			  .append("\n");
		}
		
		System.out.println(sb.toString());
	}

	static class Member implements Comparable<Member>{
		String name;
		int age;
		int idx;
		
		public Member(String name, int age, int idx) {
			super();
			this.name = name;
			this.age = age;
			this.idx = idx;
		}

		@Override
		public int compareTo(Member o) {
			if(this.age == o.age) {
				return this.idx - o.idx;
			}
			return this.age - o.age;
		}
	}

}