package baekjoon.strong_connected_component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Strongly Connected Component 2150
 * 방향 그래프가 주어졌을 때, 그 그래프를 SCC들로 나누는 프로그램을 작성하시오.
 * 방향 그래프의 SCC는 우선 정점의 최대 부분집합이며, 그 부분집합에 들어있는 서로 다른 임의의 두 정점 u, v에 대해서 u에서 v로 가는 경로와 v에서 u로 가는 경로가 모두 존재하는 경우를 말한다.
 *
 * [입력]
 * 첫째 줄에 두 정수 V(1≤V≤10,000), E(1≤E≤100,000)가 주어진다. 이는 그래프가 V개의 정점과 E개의 간선으로 이루어져 있다는 의미이다. 
 * 다음 E개의 줄에는 간선에 대한 정보를 나타내는 두 정수 A, B가 주어진다. 이는 A번 정점과 B번 정점이 연결되어 있다는 의미이다. 이때 방향은 A->B가 된다.
 * 
 * [출력]
 * 첫째 줄에 SCC의 개수 K를 출력한다. 다음 K개의 줄에는 각 줄에 하나의 SCC에 속한 정점의 번호를 출력한다. 
 * 각 줄의 끝에는 -1을 출력하여 그 줄의 끝을 나타낸다. 각각의 SCC를 출력할 때 그 안에 속한 정점들은 오름차순으로 출력한다. 
 * 또한 여러 개의 SCC에 대해서는 그 안에 속해있는 가장 작은 정점의 정점 번호 순으로 출력한다.
 */
public class SCC_2150 {
	
	static int v,e,id; 	//정점, 간선
	static List<Integer> adj[];		
	static Stack<Integer> stack;	
	static List<ArrayList<Integer>> SCC;
	static boolean finished[];
	static int identifier[];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		stack = new Stack<>();
		SCC = new ArrayList<>();
		
		adj = new ArrayList[v+1];
		for(int i=0;i<=v;i++) {
			adj[i] = new ArrayList<>();
		}
		identifier = new int[v+1];
		finished = new boolean[v+1];
		
		//입력된 간선정보 저장
		for(int i=1;i<=e;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			adj[n].add(m);
		}
		
		// 정점 개수 만큼 dfs 실행
		for(int i=1;i<=v;i++) {
			if(identifier[i] == 0) dfs(i);
		}

		Collections.sort(SCC, new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
				return o1.get(0) - o2.get(0);
			}
		});
		
//		System.out.println(SCC.size());	
		bw.write(SCC.size()+"\n"); //scc 개수
		
		for(int i=0;i<SCC.size();i++) {
			ArrayList<Integer> scc = SCC.get(i);
			for(int j=0;j<scc.size();j++) {
//				System.out.print(scc.get(j) + " ");
				bw.write(scc.get(j) + " ");
			}
//			System.out.print(-1 + "\n");
			bw.write(-1 + "\n");
		}
		
		bw.flush();
	}
	
	//dfs는 정점의 개수만큼 실행됨
	public static int dfs(int x) {
		// 각 노드에 고유한 번호를 입힘.
		identifier[x] = ++id;
		stack.push(x);
		
		int parent = identifier[x];
		for(int i=0;i<adj[x].size();i++) {
			int y = adj[x].get(i);
			if(identifier[y]==0) {		//아직 방문하지 않은 이웃 노드인 경우
				parent = Math.min(parent, dfs(y));
			}else if(!finished[y]) {	//방문했으나 아직 처리중인 이웃 노드인 경우
				parent = Math.min(parent, identifier[y]);
			}
		}
		
		//부모노드가 자기 자신인 경우 SCC형성
		if(parent == identifier[x]) {
			ArrayList<Integer> scc = new ArrayList<>();
			while(true) {
				int t = stack.pop();
				scc.add(t);
				finished[t] = true;
				if(t == x) break;
			}
			Collections.sort(scc);
			SCC.add(scc);
		}
		return parent;
	}
}
