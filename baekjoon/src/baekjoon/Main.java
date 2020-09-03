package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	
	static int MAX = 201;
	static LinkedList<Integer> adj[] = new LinkedList[MAX];
	static boolean visited[] = new boolean[MAX];
	static int match[] = new int[MAX];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(s.nextToken());	//소
		int m = Integer.parseInt(s.nextToken());	//축사
		
		//그래프 및 배열 생성
		adj = new LinkedList[n+1];
		for(int i=0;i<n+1;i++) {
			adj[i] = new LinkedList<>();
		}
		visited = new boolean[n+1];
		match = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			s = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(s.nextToken());
			for(int j=0;j<count;j++) {
				adj[i].add(Integer.parseInt(s.nextToken()));
			}
		}
		
		int count = 0;
		for(int i=1;i<=n;i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) count++;
		}
		System.out.println(count); //출력
	}
	
	public static boolean dfs(int x) {
		for(int i=0;i<adj[x].size();i++) {
			int t = adj[x].get(i);
			
			if(visited[t]) continue;
			
			visited[t] = true;
			if(match[t] == 0 || dfs(match[t])) {
				match[t] = x;
				return true;
			}
		}
		return false;
	}
}
