package baekjoon.bipartite_matching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 열혈강호 3
 * 강호네 회사에는 직원이 N명이 있고, 해야할 일이 M개가 있다. 직원은 1번부터 N번까지 번호가 매겨져 있고, 일은 1번부터 M번까지 번호가 매겨져 있다.
 * 각 직원은 한 개의 일만 할 수 있고, 각각의 일을 담당하는 사람은 1명이어야 한다. 
 * 단, N명 중에서 K명은 일을 최대 2개할 수 있다.
 * 각각의 직원이 할 수 있는 일의 목록이 주어졌을 때, M개의 일 중에서 최대 몇 개를 할 수 있는지 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 직원의 수 N과 일의 개수 M, 일을 2개할 수 있는 직원의 수 K가 주어진다. (1 ≤ N, M ≤ 1,000, 1 ≤ K ≤ N)
 * 둘째 줄부터 N개의 줄의 i번째 줄에는 i번 직원이 할 수 있는 일의 개수와 할 수 있는 일의 번호가 주어진다.
 * 
 * [출력]
 * 첫째 줄에 강호네 회사에서 할 수 있는 일의 개수를 출력한다.
 * 
 */

public class BM_11377 {
	static int n,m,k;
	static boolean[] visited;
	static int[] match;
	static List<Integer>[] adj;
    
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());	// 일을 최대 2개 할 수 있는 인원 수
		
		adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		match = new int[m+1];
		
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int count = Integer.parseInt(st.nextToken());
			for(int j=0;j<count;j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		System.out.println(bmatch());
	}
	
	public static int bmatch() {
		int count = 0;
		for(int i=1;i<=n;i++) {
			if(dfs(i)) {
				Arrays.fill(visited, false);
				count++;
			}
		}
		
		//2번씩 작업할 수 있는 사람 매칭
		int extra = 0;
		for(int i=1;i<=n && extra < k;i++) {
			if(dfs(i)) {
				Arrays.fill(visited, false);
				extra++;
			}
		}
		
		return count+extra;
	}
	
	public static boolean dfs(int x) {
		if(visited[x]) return false;
		
		visited[x] = true;
		for(int i=0;i<adj[x].size();i++) {
			int t = adj[x].get(i);
			if(match[t] == 0 || dfs(match[t])) {
				match[t] = x;
				return true;
			}
		}
		
		return false;
	}
}
