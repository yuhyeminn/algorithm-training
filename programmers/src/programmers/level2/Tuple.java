package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

/**
 * 튜플(2019 카카오 개발자 겨울 인턴십)
 * 
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 *
 */
public class Tuple {

	public static void main(String[] args) {
		String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(Arrays.toString(solution(s)));
	}
	
	public static int[] solution(String s) {
		
		s = s.substring(2,s.length()-2);
		StringTokenizer st = new StringTokenizer(s, "},{");
		Map<String,Integer> map = new HashMap<>();
		
		while(st.hasMoreTokens()) {
			String str = st.nextToken();
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(map.entrySet());

		// 비교함수 Comparator를 사용하여 오름차순으로 정렬
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>() {
			// compare로 값을 비교
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				return obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		int[] answer = new int[map.size()];
		int i = 0;
		for(Entry<String, Integer> entry : list_entries) {
			answer[i++] = Integer.parseInt(entry.getKey());
		}
		
		return answer;
	}

}
