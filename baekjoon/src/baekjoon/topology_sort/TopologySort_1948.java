package baekjoon.topology_sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1948 임계경로
 * 
 * [문제]
 * 월드 나라는 모든 도로가 일방통행인 도로이고, 싸이클이 없다. 
 * 그런데 어떤 무수히 많은 사람들이 월드 나라의 지도를 그리기 위해서, 어떤 시작 도시로부터 도착 도시까지 출발을 하여 가능한 모든 경로를 탐색한다고 한다.
 * 이 지도를 그리는 사람들은 사이가 너무 좋아서 지도를 그리는 일을 다 마치고 도착 도시에서 모두 다 만나기로 하였다. 
 * 그렇다고 하였을 때 이들이 만나는 시간은 출발 도시로부터 출발한 후 최소 몇 시간 후에 만날 수 있는가? 즉, 마지막에 도착하는 사람까지 도착을 하는 시간을 의미한다.
 * 어떤 사람은 이 시간에 만나기 위하여 1분도 쉬지 않고 달려야 한다. 이런 사람들이 지나는 도로의 수를 카운트 하여라.
 * 출발 도시는 들어오는 도로가 0개이고, 도착 도시는 나가는 도로가 0개이다.
 * 
 * [입력]
 * 첫째 줄에 도시의 개수 n(1 ≤ n ≤ 10,000)이 주어지고 둘째 줄에는 도로의 개수 m(1 ≤ m ≤ 100,000)이 주어진다. 
 * 그리고 셋째 줄부터 m+2줄까지 다음과 같은 도로의 정보가 주어진다. 
 * 처음에는 도로의 출발 도시의 번호가 주어지고 그 다음에는 도착 도시의 번호, 그리고 마지막에는 이 도로를 지나는데 걸리는 시간이 주어진다. 
 * 도로를 지나가는 시간은 10,000보다 작거나 같은 자연수이다.
 * 그리고 m+3째 줄에는 지도를 그리는 사람들이 출발하는 출발 도시와 도착 도시가 주어진다.
 * 모든 도시는 출발 도시로부터 도달이 가능하고, 모든 도시로부터 도착 도시에 도달이 가능하다.
 * 
 * [출력]
 * 첫째 줄에는 이들이 만나는 시간을, 둘째 줄에는 1분도 쉬지 않고 달려야 하는 도로의 수가 몇 개인지 출력하여라.
 * 
 */
public class TopologySort_1948 {
	public static StringTokenizer st;
	//ArrayList로 그래프 구현해보기
	public static ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
	public static ArrayList<ArrayList<Edge>> rgraph = new ArrayList<>(); 	//그래프 역추적에 이용
	public static int[] indegree, result;

	static class Edge{
		int node;
		int time;
		public Edge(int node, int time) {
			this.node = node;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());	//도시 개수
		int m = Integer.parseInt(br.readLine());	//도로 개수
		
		indegree = new int[n+1];
		result = new int[n+1];
		
		for(int i=0;i<=n;i++) {
			graph.add(new ArrayList<>());
			rgraph.add(new ArrayList<>());
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			
			graph.get(x).add(new Edge(y,time));
			rgraph.get(y).add(new Edge(x,time));
			indegree[y]++;
		}
		
		//마지막 줄의 시작 도시와 끝 도시
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		topologySort(n, start, end);
		
	}
	
	public static void topologySort(int n, int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			for(Edge y : graph.get(x)) {
				if(result[y.node] <= result[x] + y.time) {
					result[y.node] = result[x] + y.time;
				}
				if(--indegree[y.node] == 0) {
					q.add(y.node);
				}
			}
		}
		
		System.out.println(result[end]);
		
		//임계경로에 해당하는 도시들을 찾기 위해 그래프 역추적
		int c[] = new int[n+1];		//해당 도시를 처리했는지 확인하는 배열
		int count = 0; 				//도시 개수
		
		q.add(end);
		while(!q.isEmpty()) {
			int y = q.poll();
			for(Edge x : rgraph.get(y)) {
				//최장경로(임계경로)에 포함되는 간선인지 확인
				if(result[y] - result[x.node] == x.time) {
					count++;
					//System.out.println("y="+y+", x ="+x.node);
					//System.out.println("result[y]="+result[y]+", result[x] ="+result[x.node] + ", x.time="+x.time);
					//노드를 각각 한번씩만 추적하기 위해 c배열 이용
					if(c[x.node] == 0) {
						q.add(x.node);
						c[x.node] = 1;
					}
				}
			}
		}
		System.out.println(count);
	}
}
