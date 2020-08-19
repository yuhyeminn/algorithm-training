package algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 네트워크 플로우(Network Flow)
 * - 특정한 지점에서 다른 지점으로 데이터가 얼마나 많이 흐르고 있는가를 측정하는 알고리즘
 * - 최대 유량(Max Flow)문제를 해결하는 데 사용
 * - 너비 우선 탐색(BFS)를 이용 - 에드몬드 카프(Edmonds-Karp) 알고리즘
 * [참고]
 * https://engkimbs.tistory.com/353
 */
public class NetworkFlow {
	
	public static int V = 6;
	public static LinkedList<Integer> edge[];
	public static int capacity[][], flow[][];
	public static int visit[];
	public static int INF = 1000000000;
	
	public static int maxFlow(int start, int end) {
		int result = 0;
		Queue<Integer> q = new LinkedList<>();
		while(true) {
			Arrays.fill(visit, -1);
			q.add(start);
			
			while(!q.isEmpty()) {
				int x = q.peek();
				q.poll();
				for(int i=0;i<edge[x].size();i++) {
					int y = edge[x].get(i);
					//방문하지 않은 노드 중에 용량이 남은 경우
					if(capacity[x][y] - flow[x][y] > 0 && visit[y] == -1) {
						q.add(y);
						visit[y] = x; //경로를 기억함
						if(y == end) break; //end에 도달한 경우
					}
				}
			}
			if(visit[end] == -1) break;	//모든 경로를 찾은 뒤에 탈출
			int min_flow = INF;
			//거꾸로 최소 유량 탐색
			for(int i=end;i!=start;i=visit[i]) {
				int prev = visit[i];
				min_flow = Math.min(min_flow, capacity[prev][i]-flow[prev][i]);
			}
			//최소 유량만큼 추가
			for(int i=end; i!=start; i= visit[i]) {
				flow[visit[i]][i] += min_flow;
				flow[i][visit[i]] -= min_flow;	//음의 유량
			}
			result += min_flow;
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		capacity = new int[V+1][V+1];
		flow = new int[V+1][V+1];
		visit = new int[V+1];
		
		edge = new LinkedList[V+1];
		for(int i=0; i<V+1; i++) {
			edge[i] = new LinkedList();
		}
		
		edge[1].add(2);
		edge[2].add(1);
		capacity[1][2] = 12;
		
		edge[1].add(4);
		edge[4].add(1);
		capacity[1][4] = 11;
		
		edge[2].add(3);
		edge[3].add(2);
		capacity[2][3] = 6;
		
		edge[2].add(4);
		edge[4].add(2);
		capacity[2][4] = 3;
		
		edge[2].add(5);
		edge[5].add(2);
		capacity[2][5] = 5;
		
		edge[2].add(6);
		edge[6].add(2);
		capacity[2][6] = 9;
		
		edge[3].add(6);
		edge[6].add(3);
		capacity[3][6] = 8;
		
		edge[4].add(5);
		edge[5].add(4);
		capacity[4][5] = 9;
		
		edge[5].add(3);
		edge[3].add(5);
		capacity[5][3] = 3;
		
		edge[5].add(6);
		edge[6].add(5);
		capacity[5][6] = 4;
		
		int result = maxFlow(1,6);
		System.out.println("result="+result);
	}
}
