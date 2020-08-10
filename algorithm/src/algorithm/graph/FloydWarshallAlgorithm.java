package algorithm.graph;

/**
 * 플로이드 와샬 알고리즘
 * - 모든 정점에서 모든 정점으로 최단경로를 구하는 알고리즘
 * - 다이나믹 프로그래밍 기술에 의거함
 * - '거쳐가는 정점'을 기준으로 최단거리를 구함
 * - 시간복잡도 O(N^3)
 */
public class FloydWarshallAlgorithm {
	static int INF = 1000000000;
	static int arr[][] = {
			{ 0, 5, INF, 8 },
			{ 7, 0, 9, INF },
			{ 2, INF, 0, 4 },
			{ INF, INF, 3, 0 }
	};
	static int num = arr.length;
	
	public static void floydWarshall() {
		// k : 거쳐가는 노드
		for(int k=0;k<num;k++) {
			//i : 출발 노드
			for(int i=0;i<num;i++) {
				//j : 도착노드
				for(int j=0;j<num;j++) {
					if(arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}
		
		//결과 출력
		for(int i=0;i<num;i++) {
			for(int j=0;j<num;j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		floydWarshall();
	}
	
	
}
