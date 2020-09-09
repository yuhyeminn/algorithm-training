package baekjoon.bipartite_matching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 열혈강호 2
 * 강호네 회사에는 직원이 N명이 있고, 해야할 일이 M개가 있다. 직원은 1번부터 N번까지 번호가 매겨져 있고, 일은 1번부터 M번까지 번호가 매겨져 있다.
 * 각 직원은 최대 두 개의 일을 할 수 있고, 각각의 일을 담당하는 사람은 1명이어야 한다.
 * 각각의 직원이 할 수 있는 일의 목록이 주어졌을 때, M개의 일 중에서 최대 몇 개를 할 수 있는지 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 직원의 수 N과 일의 개수 M이 주어진다. (1 ≤ N, M ≤ 1,000)
 * 둘째 줄부터 N개의 줄의 i번째 줄에는 i번 직원이 할 수 있는 일의 개수와 할 수 있는 일의 번호가 주어진다.
 * 
 * [출력]
 * 첫째 줄에 강호네 회사에서 할 수 있는 일의 개수를 출력한다.
 * 
 */

public class BM_11376_ver3 {
	static int n;
	static int m;
	static boolean[] visited;
	static int[] match;
	static List<Integer>[] list;
    
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		visited = new boolean[n+1]; 
		match = new int[m+1]; 
		
		
		list = new List[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			for(int j=0; j<k; j++) {
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		System.out.println(binaryMatch());
	}
	
	public static int binaryMatch() {
		int ans=0;
		for(int i=1; i<=n; i++) {
			for(int j=0; j<2; j++) {
				if(dfs(i)) {
					Arrays.fill(visited, false);
					ans++;
				}
			}
		}
		return ans;
	}
	
	public static boolean dfs(int x) {
		if(visited[x]) {
			return false;
		}
		visited[x] = true;
		for(int k : list[x]) {
			if(match[k]==0 || dfs(match[k])) {
				match[k] = x;
				return true;
			}
		}
		return false;
	}
}

/*
 * ver 3. 전역변수. 아이디 mduddns님 버전
 * 메모리109524 kb , 시간 988ms
 * ver2랑 거의 같은 코드인것같은데 왜 이렇게 차이나는지 정말정말 모르겠음,,,,,,
 */
