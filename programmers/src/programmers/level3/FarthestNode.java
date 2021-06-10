package programmers.level3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 가장 먼 노드
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 * 
 * @author hyemin
 * 
 * [해결]
 * - bfs
 */
public class FarthestNode {
 
	static ArrayList<Integer> adj[];
	static int count[]; //1과의 거리 저장
	static boolean visited[];
	public static int solution(int n, int[][] edge) {
		int answer = 0;

		count = new int[n+1];
		visited = new boolean[n+1];
		adj = new ArrayList[n+1];
		for (int i = 0; i < n+1; i++) {
			adj[i] = new ArrayList<>();
		}
		// 노드 연결
		int a, b;
		for (int[] node : edge) {
			a = node[0];
			b = node[1];
			adj[a].add(b);
			adj[b].add(a);
		}
		
		bfs(1); //==1
		
		// 가장 멀리 떨어진 노드
		int max = 0;
		for (int cnt : count) {
			if (max < cnt) {
				max = cnt;
				answer = 1;
			} else if (max == cnt) {
				answer++;
			}
		}
		
		return answer;
	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			for (int v : adj[now]) {
				if (!visited[v]) {
					visited[v] = true;
					q.add(v);
					count[v] = count[now] + 1;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int n = 6;
		int vertex[][] = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };

		System.out.println(solution(n, vertex));
	}
}
