package algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 이분 매칭(BipartiteMatching)
 * - 네트워크 플로우 알고리즘과 연계되는 개념
 * - 이분 그래프에서 최대유량을 구하는 경우 = 이분 그래프에서의 최대 매칭
 * - 이분 그래프 : 점을 두 그룹으로 나누었을 때 모든 간선에 연결 된 두 정점이 서로 다른 그룹에 존재하는 그래프
 * - 깊이우선탐색 (DFS) 이용
 * - 시간 복잡도 : O(V*E)
 * 
 * [참고]
 * https://jason9319.tistory.com/149
 */
public class BipartiteMatching {
	public static void main(String[] args) {
		int n = 3;
		Graph g = new Graph(n);
		g.addEdge(1, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 1);
		g.addEdge(3, 2);
		
		g.bmatch(n);
	}
}

class Graph{
	private int V;
	private LinkedList<Integer> adj[];
	
	private boolean[] visited;
	private int[] match;
	
	public Graph(int v) {
		V = v;
		adj = new LinkedList[V+1];
		for(int i=0;i<V+1;i++) {
			adj[i] = new LinkedList<>();
		}
		visited = new boolean[V+1];
		match = new int[V+1];
	}
	
	public void addEdge(int v, int w) {adj[v].add(w);}
	
	public void bmatch(int n) {
		int count = 0;
		
		for(int i=1;i<=n;i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) count++;
		}
		
		System.out.println(count + "개의 매칭");
		
		for(int i=1;i<=n;i++) {
			System.out.println(match[i] + " -> " + i);
		}
	}
	
	public boolean dfs(int x) {
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
