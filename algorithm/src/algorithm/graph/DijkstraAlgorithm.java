package algorithm.graph;

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
public class DijkstraAlgorithm {
	/*기본적인 다익스트라 알고리즘 구현. 시간복잡도O(N^2)*/
	
	public static int number = 6;
	public static int INF = 1000000000;
	
	// 전체 그래프 초기화
	public static int arr[][] = {
			{ 0, 2, 5, 1, INF, INF },
			{ 2, 0, 3, 2, INF, INF },
			{ 5, 3, 0, 3, 1, 5 },
			{ 1, 2, 3, 0, 1, INF },
			{ INF, INF, 1, 1, 0, 2 },
			{ INF, INF, 5, INF, 2, 0 }
	};
	
	public static boolean visited[] = new boolean[number];	//노드 방문 여부
	public static int distance[] = new int[number];			//거리
	
	//가장 최소 거리를 가지는 정점 반환
	static int getSmallIndex() {
		int min = INF;
		int index = 0;
		
		for(int i=0;i<number;i++) {
			if(distance[i] < min && !visited[i]) {
				min = distance[i];
				index = i;
			}
		}
		return index;
	}
	
	static void dijkstra(int start) {
		//거리배열 초기화
		for(int i=0;i<number;i++) {
			distance[i] = arr[start][i];
		}
		visited[start] = true;
		
		for(int i=0;i<number;i++) {
			int current = getSmallIndex();
			visited[current] = true;
			
			//첫번째 노드와 마지막 노드를 제외하여 number-2까지만..
			for(int j=0; j < number - 2; j++) {
				if(!visited[j]) {
					if(distance[current] + arr[current][j] < distance[j]) {
						distance[j] = distance[current] + arr[current][j];
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int start = 0;
		dijkstra(start);
		
		//첫번째 노드(인덱스 0)에서 나머지 노드로 가는 최단 경로들 출력
		for(int i=0;i<number;i++) {
			System.out.println("from " +(start+1) + "번 노드 to "+ (i+1) + "번 노드 : " + distance[i] + " ");
		}
	}
}
