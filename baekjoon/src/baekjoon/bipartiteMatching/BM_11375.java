package baekjoon.bipartiteMatching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 열혈강호 11375
 * 강호네 회사에는 직원이 N명이 있고, 해야할 일이 M개가 있다. 직원은 1번부터 N번까지 번호가 매겨져 있고, 일은 1번부터 M번까지 번호가 매겨져 있다.
 * 각 직원은 한 개의 일만 할 수 있고, 각각의 일을 담당하는 사람은 1명이어야 한다.
 * 각각의 직원이 할 수 있는 일의 목록이 주어졌을 때, M개의 일 중에서 최대 몇 개를 할 수 있는지 구하는 프로그램을 작성하시오.
 * 
 * [입력]
 * 첫째 줄에 직원의 수 N과 일의 개수 M이 주어진다. (1 ≤ N, M ≤ 1,000)
 * 둘째 줄부터 N개의 줄의 i번째 줄에는 i번 직원이 할 수 있는 일의 개수와 할 수 있는 일의 번호가 주어진다.
 *
 * [출력]
 * 첫째 줄에 강호네 회사에서 할 수 있는 일의 개수를 출력한다.
 */

/* 시간 초과 - 간선 저장하는 adj배열을 ArrayList로 변경하였더니 해결됨*/
/* 전역변수 사용보다 메소드의 인자로 전달하여 사용하는 것이 훨씬 효율적인 것 같음(?)*/
public class BM_11375 {

	private static int max = 1001;
	private static ArrayList<Integer> adj[] = new ArrayList[max];;
	private static boolean visited[] = new boolean[max];
	private static int match[]= new int[max];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for(int i=0;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int count = Integer.parseInt(st.nextToken());
			for(int j=0;j<count;j++) {
				int work = Integer.parseInt(st.nextToken());
				adj[i].add(work);
			}
		}
		int count = 0;
		
		for(int i=1;i<=n;i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) count++;
		}
		System.out.println(count);
	}
	
	public static boolean dfs(int x) {
		for(int i=0;i<adj[x].size();i++) {
			int t = adj[x].get(i);
			
			if(visited[t]) continue;
			
			visited[t] = true;
			if(match[t]==0 || dfs(match[t])) {
				match[t] = x;
				return true;
			}
		}
		return false;
	}
}
