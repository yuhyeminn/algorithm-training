package algorithm.graph;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 다익스트라(Dijkstra) 알고리즘
 * - 다이나믹 프로그래밍을 활용한 대표적인 최단 경로 탐색 알고리즘
 * - 하나의 정점에서 출발 했을 때 다른 모든 정점으로의 최단 경로를 구하는 알고리즘
 * - 흔히 인공위성 GPS 소프트웨어 등에서 많이 사용됨
 * - 음의 간선 포함할 수 없음
 * 
 * 1. 출발 노드 설정
 * 2. 출발 노드 기준으로 각 노드의 최소 비용 저장
 * 3. 방문하지 않은 노드 중에서 가장 비용이 적은 노드 선택
 * 4. 해당 노드를 거쳐 특정한 노드를 가는 경우를 고려하여 최소 비용 갱신
 * 5. 위 과정 3번 ~ 4번을 반복
 */
public class Dijkstra_PriorityQueue {
	/*
	 우선순위큐를 이용한 다익스트라 알고리즘 구현. 
	 시간복잡도O(E+NlogN) -> 노드 갯수N, 정점 개수E
	 - 우선순위 큐에 정점의 번호 와 함께 지금까지 찾아낸 해당 정점까지의 최단 거리 를 쌍으로 넣음 
	 - 우선순위 큐는 정점까지의 최단 거리를 기준으로 정점을 배열함으로써 아직 방문하지 않은 정점 중 시작점으로부터의 거리가 가장 가까운 점을 찾는 과정을 간단하게 해줌
	*/
	public static int INF = 1000000000;
	public static int num = 6;
	public static int distance[] = new int[num+1];
	public static int arr[][] = new int[num+1][num+1];
			
	public static class Node implements Comparable<Node> {
		int index;
		int distance;
		
		public Node(int index, int distance) {
			this.index = index;
			this.distance = distance;
		}
		
		public int getIndex() {
			return index;
		}
		public int getDistance() {
			return distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.getDistance() - o.getDistance();
		}

		@Override
		public String toString() {
			return "Node [index=" + index + ", distance=" + distance + "]";
		}
		
		
	}
	
	public static void dijkstra(int start){
		distance[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>(); //힙 구조
		pq.offer(new Node(start, 0));
		
		//가까운 순서대로 처리하므로 큐를 사용
		while(!pq.isEmpty()) {
			//우선순위큐를 활용해 가장 가까운 노드 정보 가져옴
			Node n = pq.poll();
			int current = n.index;
			int dist = n.distance;
//			System.out.println(n.toString());
			
			//최단 거리 아닐 경우 스킵함
			if(distance[current] < dist) continue;
			
			for(int i=0; i<arr[current].length;i++) {
				//선택된 노드의 인접 노드
				if(arr[current][i] != 0 && distance[i] > distance[current] + arr[current][i]) {
					distance[i] = distance[current] + arr[current][i];
					pq.offer(new Node(i, distance[i]));
				}
			}
		}
		System.out.println(Arrays.toString(distance));
	}
	
	public static void main(String[] args) {
		for(int i=1; i<num+1;i++) {
			distance[i] = INF;
		}
		
		arr[1][2] = 8;
		arr[1][3] = 1;
		arr[1][4] = 2;
		arr[3][4] = 2;
		arr[3][2] = 5;
		arr[4][5] = 3;
		arr[4][6] = 5;
		arr[5][6] = 1;
		arr[6][1] = 5;
		
		dijkstra(1);
	}
	

	
}
