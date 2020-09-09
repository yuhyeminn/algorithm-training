package baekjoon.bipartite_matching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

public class BM_11376_ver1 {

	/* 
	 어떠한 직원을 먼저 매칭시켜주던지 최종적으로 매칭되는 숫자가 동일하기 때문에 
	 단순히 dfs를 두번 수행해주면 해결 할 수 있음.
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> adj[] = new ArrayList[1001];
		for(int i=0;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int count = Integer.parseInt(st.nextToken());
			for(int j=0;j<count;j++) {
				adj[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		int answer = 0;
		boolean visited[] = new boolean[1001];
		int match[] = new int[1001];
		for(int i=0;i<2;i++) {
			for(int j=1;j<=n;j++) {
				visited = new boolean[1001];
				if (dfs(j, adj, visited, match)) answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static boolean dfs(int x, ArrayList<Integer> adj[], boolean visited[], int match[]) {
		for(int i=0;i<adj[x].size();i++) {
			int t = adj[x].get(i);
			if(visited[t]) continue;
			
			visited[t] = true;
			if (match[t] == 0 || dfs(match[t], adj, visited, match)) {
				match[t] = x;
				return true;
			}
		}
		return false;
	}
}

/*
 * ver 1. 전역변수 사용 x. dfs 동빈나 버전
 * 메모리 107024 kb , 시간 6764ms
 */
