package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 나는야 포켓몬 마스터 이다솜
 * https://www.acmicpc.net/problem/1620
 * @author hyemin
 *
 * [해결]
 * List 시간초과 -> 두개의 Map으로 해결
 */
public class Class3_1620 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		Map<Integer, String> numberMap = new HashMap<>();
		Map<String, Integer> nameMap = new HashMap<>();
		for(int i=1;i<=N;i++) {
			String pokemon = br.readLine();
			numberMap.put(i, pokemon);
			nameMap.put(pokemon, i);
		}
		
		for(int i=0;i<M;i++) {
			String find = br.readLine();
			//포켓몬 이름
			if(find.charAt(0)-'A' >= 0) {
				sb.append(nameMap.get(find));
			}
			//포켓몬 번호
			else {
				sb.append(numberMap.get(Integer.parseInt(find)));
			}
			sb.append("\n");
		}
	
		System.out.println(sb.toString());
	}
}
