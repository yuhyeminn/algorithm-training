package programmers.code_challenge.challenge_0415;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 모두 0으로 만들기
 * @author hyemin
 *
 * ** 위상 정렬을 이용해 풀어볼 것
 * [참고]
 * https://dev-note-97.tistory.com/263?category=884288
 */
public class Challenge03_solve {

	static int N;
	static boolean[] visited;
	static long[] arr;
	static LinkedList<Integer>[] adj;
	static long answer;
	public static long solution(int[] a, int[][] edges) {
	    
	    N = a.length;
	    adj = new LinkedList[N];
	    visited = new boolean[N];
	    arr = new long[N];
	    
	    long sum = 0;
	    for(int i=0;i<N;i++) {
	    	adj[i] = new LinkedList<>();
	    	arr[i] = a[i];
	    	sum += a[i];
	    }
	    
	    if(sum != 0) {
	    	return -1;
	    }
	    
	    for(int i=0;i<edges.length;i++) {
	    	int x = edges[i][0];
	    	int y = edges[i][1];
	    	adj[x].add(y);
	    	adj[y].add(x);
	    }
	    
	    dfs(0);
	    
	    return answer;
	}
	
	public static long dfs(int v) {
		visited[v] = true;
		
		for(int i=0;i<adj[v].size();i++) {
			int x = adj[v].get(i);
			if(!visited[x]) {
				arr[v] = dfs(x);
			}
		}
		
		answer += Math.abs(arr[v]);
		
		return arr[v];
	}
	
	public static void main(String[] args) {
		int a[] = {-5, 0, 2, 1, 2};
		int edges[][] = {{0,1},{3,4},{2,3},{0,3}};
		System.out.println(solution(a, edges));
	}
	
}
