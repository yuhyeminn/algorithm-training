package programmers.code_challenge.challenge_0415;

import java.util.ArrayList;

/**
 * 모두 0으로 만들기
 * @author hyemin
 *
 * ** 위상 정렬을 이용해 풀어볼 것
 * ** LinkedList -> 시간초과
 * ** dfs -> 시간 효율이 떨어짐
 * [참고]
 * https://dev-note-97.tistory.com/263?category=884288
 */
public class Challenge03_solve {

	static int N;
	static boolean[] visited;
	static long[] arr;
	static ArrayList<Integer>[] adj;
	static long answer;
	public static long solution(int[] a, int[][] edges) {
	    
	    N = a.length;
	    adj = new ArrayList[N];
	    visited = new boolean[N];
	    arr = new long[N];
	    
	    long sum = 0;
	    for(int i=0;i<N;i++) {
	    	adj[i] = new ArrayList<>();
	    	arr[i] = a[i];
	    	sum += a[i];
	    }
	    
	    if(sum != 0) {
	    	return -1;
	    }
	    
	    for(int i=0;i<edges.length;i++) {
	    	adj[edges[i][0]].add(edges[i][1]);
	    	adj[edges[i][1]].add(edges[i][0]);
	    }
	    
	    dfs(0);
	    
	    return answer;
	}
	
	public static long dfs(int v) {
		visited[v] = true;
		
		for(int i=0;i<adj[v].size();i++) {
			int x = adj[v].get(i);
			if(!visited[x]) {
				arr[v] += dfs(x);	
			}
		}
		
		answer += Math.abs(arr[v]); //현재 가중치 더하기
		
		return arr[v];
	}
	
	public static void main(String[] args) {
		int a[] = {-5, 0, 2, 1, 2};
		int edges[][] = {{0,1},{3,4},{2,3},{0,3}};
		System.out.println(solution(a, edges));
	}
	
}
