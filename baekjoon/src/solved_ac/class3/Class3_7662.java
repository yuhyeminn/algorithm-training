package solved_ac.class3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * 이중 우선순위 큐
 * 
 * @author hyemin
 * 
 */
public class Class3_7662 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			int N = Integer.parseInt(br.readLine());

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String str = st.nextToken();
				int number = Integer.parseInt(st.nextToken());

				if (str.equals("I"))
					treeMap.put(number, treeMap.getOrDefault(number, 0) + 1);
				else {
					if (!treeMap.isEmpty()) {
						int num = (number == 1) ? treeMap.lastKey() : treeMap.firstKey();
						if (treeMap.put(num, treeMap.get(num) - 1) == 1)
							treeMap.remove(num);
					}
				}
			}
			System.out.println(treeMap.size() == 0 ? "EMPTY" : treeMap.lastKey() + " " + treeMap.firstKey());
		}

	}

}
