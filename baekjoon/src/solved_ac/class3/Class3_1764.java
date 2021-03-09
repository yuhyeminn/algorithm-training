package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 듣보잡
 * @author hyemin
 *
 */
public class Class3_1764 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		List<String> result = new ArrayList<>();
		//듣도 못한 사람 입력
		for(int i=0;i<N;i++) {
			set.add(br.readLine());
		}
		
		//듣도 보도 못한 사람 판별
		for(int i=0;i<M;i++) {
			String name = br.readLine();
			if(set.contains(name))
				result.add(name);
		}
		
		sb.append(result.size()).append("\n");
		Collections.sort(result);
		for(String name : result) {
			sb.append(name).append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
