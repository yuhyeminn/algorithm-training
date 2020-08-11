package algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 위상정렬 (Topology Sort)
 * - '순서가 정해져 있는 작업'을 차례대로 수행해야할 때 그 순서를 결정해주기 위해 사용하는 알고리즘
 * - DAG(Directed Acyclic Graph)에만 적용이 가능함. 
 *   ** DAG(Directed Acyclic Graph) : 방향그래프이면서 사이클이 없는 그래프
 * - 스택을 이용하는방법, 큐를 이용하는 방법 총 2가지가 존재함
 * 
 * 큐를 이용한 경우
 * 1. 진입차수가 0인 정점을 큐에 삽입함
 * 2. 큐에서 원소를 꺼내 연결된 모든 간선을 제거함
 * 3. 간선 제거 이후에 진입차수가 0이 된 정점을 큐에 삽입함
 * 4. 큐가 빌 때까지 2~3번 과정을 반복함. 모든 원소를 방문하기 전에 큐가 빈다면 사이클이 존재하는것.
 *    모든 원소를 방문했다면 큐에서 꺼낸 순서가 위상정렬의 결과가 됨.
 *    
 * [참고]
 * https://huisam.tistory.com/entry/TopologicalSort?category=689277
 */
public class TopologySort {

	public static int size = 8;
	public static LinkedList<Integer>[] edge;
	public static int degree[];
	
	public static void topologySort() {
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();
		
		//진입 차수가 0인 것을 q에 넣음
		for(int i=1;i<size;i++) {
			if(degree[i] == 0) {
				q.add(i);
			}
		}
		
		//모든 노드를 방문할 떄 까지
		while(!q.isEmpty()) {
			int current = q.poll();
			result.add(current);
			
			for(int next : edge[current]) {
				//간선 삭제 --> 진입 차수 - 1
				degree[next]--;
				//진입 차수 0이면 다서 q에 삽입
				if(degree[next] == 0) {
					q.add(next);
				}
			}
		}
		
		//result 큐 출력
		while(!result.isEmpty()) {
			System.out.print(result.poll() + " ");
		}
	}

	public static void main(String[] args) {
		edge = new LinkedList[size];
        for (int i = 1; i < size; i++) {
            edge[i] = new LinkedList<>();
        }
        degree = new int[size];
        
        /*edge[1].push(2);
        degree[2]++;
        edge[2].push(5);
        degree[5]++;
        edge[2].push(6);
        degree[6]++;
        edge[3].push(6);
        degree[6]++;
        edge[3].push(7);
        degree[7]++;
        edge[4].push(7);
        degree[7]++;
        edge[5].push(8);
        degree[8]++;
        edge[6].push(8);
        degree[8]++;
        edge[7].push(8);
        degree[8]++;*/
        
        edge[1].push(2);
        degree[2]++;
        edge[1].push(5);
        degree[5]++;
        edge[2].push(3);
        degree[3]++;
        edge[3].push(4);
        degree[4]++;
        edge[4].push(6);
        degree[6]++;
        edge[5].push(6);
        degree[6]++;
        edge[6].push(7);
        degree[7]++;
        
        topologySort();
	}
}
