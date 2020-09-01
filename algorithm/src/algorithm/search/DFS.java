package algorithm.search;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 깊이우선탐색 DFS(Depth First Search)
 * - 루트노드에서 시작해서 다음 분기로 넘어가기 전에 해당 분기를 완벽하게 탐색함
 * - '맹목적인 탐색'을 하고자 할 때 사용할 수 있는 탐색 기법
 * - 너비우선탐색보다 좀 더 간단함. 대신 조금 더 느림
 * - 자기 자신을 호출하는 순환 알고리즘 형태로 많이 사용
 * - 스택(Stack)원리를 이용하여 구현 - 명시적인 스택 사용
 */

/* 인접리스트 이용 */
public class DFS {
	private int V;						//노드의 개수
	private LinkedList<Integer> adj[];	//인접리스트
	
	public DFS(int v){
		V = v;
		adj = new LinkedList[v];
		//인접리스트 초기화
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
	
	/* 노드 연결 메소드 */
	public void addEdge(int v, int w) {adj[v].add(w);}
	
	public void dfsUtil(int v, boolean visited[]) {
		//현재 노드를 방문한 것으로 표시하고 값을 출력함
		 visited[v] = true;
		 System.out.print(v + " ");
		 
		// 방문 노드와 인접한 모든 노드를 가져옴
		Iterator<Integer> iter = adj[v].listIterator();
		while(iter.hasNext()) {
			int n = iter.next();
			//방문하지 않은 노드면 해당 노드를 다시 시작 노드로 하여 dfsUtil호출(재귀)
			if(!visited[n]) {
				dfsUtil(n, visited);
			}
		}
					
	}
	/* 주어진 노드를 시작 노드로 하여 dfs탐색 */
	public void dfs(int v) {
		// 노드의 방문 여부 판단
		boolean visited[] = new boolean[V];
		
		// v를 시작 노드로 dfsUtil 순환 호출
		dfsUtil(v, visited);
	}
	
	/* dfs탐색*/
	public void dfs() {
		// 노드의 방문 여부 판단
		boolean visited[] = new boolean[V];
		
		// 비연결형 그래프의 경우 모든 정점을 하나씩 방문
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				dfsUtil(i, visited);
			}
		}
	}
	
	public static void main(String[] args) {
		DFS d = new DFS(4);
		
		d.addEdge(0, 1);
		d.addEdge(0, 2);
		d.addEdge(1, 2);
		d.addEdge(2, 0);
		d.addEdge(2, 3);
		d.addEdge(3, 3);
		
		// System.out.println(Arrays.toString(d.adj));
		
		d.dfs(2);	//주어진 노드를 시작 노드로 dfs탐색
		d.dfs();	//비연결형 그래프의 경우 dfs탐색
	}
}
