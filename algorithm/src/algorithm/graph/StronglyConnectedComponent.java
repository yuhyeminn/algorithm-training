package algorithm.graph;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 강한 결합 요소(Strongly Connected Component)
 * - 강하게 결합된 정점 집합
 * - 그래프 내에서 정점들이 서로 왕복 가능한 최대 크기의 집합
 * - 방향 그래프에서 어떠한 그룹 내의 임의의 두 정점 A,B사이의 경로가 항상 존재할 경우 그 그룹을 SCC라 칭함
 * - 사이클이 발생하는 경우 무조건 SCC에 해당함.
 * - 서로 다른 SCC에서 뽑은 임의의 두 점 A,B 사이의 경로 A->B로 가는 경로와 B->A로 가는 경로는 동시에 존재할 수 없음
 * - SCC 추출 알고리즘 : 코사라주(Kosaraju) 알고리즘, 타잔(Tarjan) 알고리즘
 * 
 * [참고]
 * http://blog.naver.com/kks227/220802519976
 * https://jason9319.tistory.com/98
 * 
 *
 */

/*
 * 타잔 알고리즘 
 * - 시간복잡도 O(V+E)
 */
public class StronglyConnectedComponent {

	public static LinkedList<Integer>[] edge;
	public static LinkedList<LinkedList<Integer>> SCC;
	public static Stack<Integer> stack;
	public static int id, d[];
	public static boolean finished[];
	
	//dfs는 총 정점의 갯수만큼 실행함.
	public static int dfs(int x) {
		d[x] = ++id;	// 노드마다 고유한 번호 할당
		stack.push(x);  // 스택에 삽입
		
		int parent = d[x];
		for(int i = 0; i < edge[x].size(); i++){
			int y = edge[x].get(i);
			if(d[y] == 0) {
				parent = Math.min(parent, dfs(y)); // 방문하지 않은 이웃 노드
			}else if(!finished[y]) parent = Math.min(parent, d[y]); // 처리중인 이웃 노드
			
		}
		
		if(parent == d[x]) {	// 부모 노드가 자기 자신인 경우
			LinkedList<Integer> scc = new LinkedList<>();
			while(true) {
				int t = stack.pop();
				scc.add(t);
				finished[t] = true;
				if(t == x) break;
			}
			SCC.add(scc);
		}
		//자신의 부모 값 반환
		return parent;
	}
	

	public static void main(String[] args) {
		//정점 개수
		int v = 11;
		//초기화
		stack = new Stack<>();
		SCC = new LinkedList<>();
		finished = new boolean[v+1];
		d = new int[v+1];
		edge = new LinkedList[v+1];
		
		for (int i = 1; i < v+1; i++) {
            edge[i] = new LinkedList<>();
        }
		
		edge[1].add(2);
		edge[2].add(3);
		edge[3].add(1);
		edge[4].add(2);
		edge[4].add(5);
		edge[5].add(7);
		edge[6].add(5);
		edge[7].add(6);
		edge[8].add(5);
		edge[8].add(9);
		edge[9].add(10);
		edge[10].add(11);
		edge[11].add(3);
		edge[11].add(8);
		
		// 정점 개수 만큼 dfs 실행
		for(int i=1; i<= v; i++) {
			if(d[i] == 0) dfs(i);
		}
		
		System.out.println("SCC 갯수 : " + SCC.size());
		
		// SCC 출력
		for(int i=0;i < SCC.size();i++) {
			System.out.print((i+1)+"번째 SCC : ");
			LinkedList<Integer> scc = SCC.get(i);
			for(int j=0; j < scc.size();j++) {
				System.out.print(scc.get(j) + " ");
			}
			System.out.println();
		}
	}
}
