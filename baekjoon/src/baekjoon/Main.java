package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
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
