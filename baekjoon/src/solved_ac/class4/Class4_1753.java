package solved_ac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 최단경로
 * 
 * @author hyemin
 * 
 * [해결] 
 * - 다익스트라 알고리즘 
 * - 인접 리스트
 */
public class Class4_1753 {
	static LinkedList<Node> list[];
	static int distance[];
	static boolean visit[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());

		visit = new boolean[v + 1]; 	//방문 여부
		list = new LinkedList[v + 1]; 	//인접리스트
		distance = new int[v + 1]; 		//거리 배열
		Arrays.fill(distance, -1);

		for (int i = 1; i <= v; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[v1].add(new Node(v2, w));
		}

		dijkstra(start);
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++)
			sb.append(distance[i] == -1 ? "INF" : distance[i]).append("\n");
		System.out.print(sb.toString());
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0)); // 우선 순위의 가중치에 시작 정점을 삽입
		distance[start] = 0; // 시작점의 거리 = 0

		while (!pq.isEmpty()) {
			Node now = pq.poll(); // 정점을 꺼냄
			if (!visit[now.number]) { // 정점을 방문하지 않았으면
				visit[now.number] = true; // 방문처리
				for (Node next : list[now.number]) {
					if (distance[next.number] == -1 || distance[next.number] > distance[now.number] + next.weight) { 
						distance[next.number] = distance[now.number] + next.weight;
						pq.offer(new Node(next.number, distance[next.number]));
					}
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int number, weight;

		Node(int n, int w) {
			this.number = n; // 정점의 번호
			this.weight = w; // 가중치
		}

		public int compareTo(Node n) { // 가중치의 오름차순
			return weight - n.weight;
		}
	}
}