package algorithm.search;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 너비우선탐색 BFS(Breadth First Search)
 * - 루트노드에서 시작해서 인접한 노드를 먼저 탐색하는 알고리즘
 * - '맹목적인 탐색'을 하고자 할 때 사용할 수 있는 탐색 기법
 * - '최단 경로'를 찾아준다는 점에서 최단 길이를 보장해야 할 때 많이 사용함
 * - 큐(Queue)를 사용하여 구현
 */

/* 인접리스트 이용 */
public class BFS {
	private int V;						//노드의 개수
	private LinkedList<Integer> adj[];	//인접리스트
	
	public BFS(int v){
		V = v;
		adj = new LinkedList[v];
		//인접리스트 초기화
		for(int i=0; i<v; i++) {
			adj[i] = new LinkedList();
		}
	}
	
	/* 노드 연결 메소드 */
	public void addEdge(int v, int w) {adj[v].add(w);}
	
	/** s를 시작 노드으로 한 BFS로 탐색하면서 탐색한 노드들을 출력 */
	public void bfs(int s) {
		// 노드 방문 여부 판단 배열
		boolean visited[] = new boolean[V];
		// 큐 생성
		LinkedList<Integer> queue = new LinkedList<Integer>();
		
		//현재 노드를 방문한 것으로 표시하고 큐에 삽입함
		visited[s] = true;
		queue.add(s);
		
		
		while(!queue.isEmpty()) {
			// 방문한 노드를 큐에서 추출하고 값을 출력함
			s = queue.poll();
			System.out.print(s + " ");
			
			// 방문 노드와 인접한 모든 노드를 가져옴
			Iterator<Integer> iter = adj[s].listIterator();
			while(iter.hasNext()) {
				int n = iter.next();
				if(!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		BFS b = new BFS(4);
		
		b.addEdge(0, 1);
		b.addEdge(0, 2);
		b.addEdge(1, 2);
		b.addEdge(2, 0);
		b.addEdge(2, 3);
		b.addEdge(3, 3);
		
		//System.out.println(Arrays.toString(b.adj));
		
		b.bfs(2);	//2 0 3 1
	}
}
