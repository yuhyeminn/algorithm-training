package algorithm.graph;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 크루스칼 알고리즘(KruskalAlgorithm)
 * - 각 노드를 최소 비용으로 연결하기 위해 사용하는 알고리즘
 *   최소 비용 신장 트리를 만드는 대표적 알고리즘
 * - 두 노드와 그 간선에 소모되는 비용을 하나의 클래스로 정의하여 비용을 기준으로 오름차순 정렬 한 후,
 *   가장 적은 비용부터 차례대로 정점을 연결해나감
 * - 최소 간선 개수 = 노드 개수 - 1
 * - 최소 비용 신장 트리에서는 사이클이 발생하면 안됨
 */
public class KruskalAlgorithm {
	// 부모 노드 찾는 재귀 메소드
	public static int getParent(int[] set, int x) {
		if (set[x] == x)
			return x;
		return getParent(set, set[x]);
	}

	// 합집합 만들기
	public static void unionParent(int[] set, int x, int y) {
		x = getParent(set, x);
		y = getParent(set, y);

		// 더 작은 값으로 부모 노드 설정
		if (x < y)
			set[y] = x;
		else
			set[x] = y;
	}

	// 같은 부모인지 확인하는 메소드
	public static boolean isSameParent(int[] set, int x, int y) {
		boolean result = false;
		x = getParent(set, x);
		y = getParent(set, y);
		
		if (x == y) {
			return true;
		}
		return result;
	}
	
	// 간선 클래스 선언
	static class Edge implements Comparable<Edge>{
		int node[] = new int[2];
		int distance;
		
		public Edge(int a, int b, int distance) {
			this.node[0] = a;
			this.node[1] = b;
			this.distance = distance;
		}

		@Override
		public int compareTo(Edge e) {
			if(this.distance < e.distance) return -1;
			else if(this.distance > e.distance) return 1;
			return 0;
		}
	}
	
	public static void main(String[] args) {
		//정점의 개수
		int v = 7;
		
		ArrayList<Edge> list = new ArrayList<>(); 
		list.add(new Edge(1,7,12));
		list.add(new Edge(1,4,28));
		list.add(new Edge(1,2,67));
		list.add(new Edge(1,5,17));
		list.add(new Edge(2,4,24));
		list.add(new Edge(2,5,62));
		list.add(new Edge(3,5,20));
		list.add(new Edge(3,6,37));
		list.add(new Edge(4,7,13));
		list.add(new Edge(5,6,45));
		list.add(new Edge(5,7,73));
		
		//간선의 비용으로 오름차순 정렬
		Collections.sort(list);
		
		//각 정점이 포함된 그래프가 어디인지 저장
		int set[] = new int[v];
		int sum = 0;
		//부모 노드 첫 세팅 - 자기 자신
		for(int i=0;i<set.length;i++) {
			set[i] = i;
		}
		
		for(int i=0;i<set.length;i++) {
			//같은 부모를 가지지 않는다면 (사이클이 발생하지 않는다면)
			if(!isSameParent(set,list.get(i).node[0]-1, list.get(i).node[1]-1)) {
				sum += list.get(i).distance;
				//두 정점을 연결
				unionParent(set, list.get(i).node[0]-1 , list.get(i).node[1]-1);
			}
		}
		System.out.println("총 비용="+sum);
	}
	
}
