package baekjoon.strong_connected_component;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 축구전술 3977
 * World Soccer Championship이 다가오고 있다! 천재적인 전술을 창조하는 플랜 아티스트 감독 도현이는 자신의 팀이 승리하도록 만반의 준비를 가하고 있다. 
 * 도현이의 전략은 경기장을 여러 개의 구역으로 나누고, 어떤 선수가 A구역에서 B구역으로 이동하게 하는 움직임을 (A, B)로 표현한다. 모든 도현이의 팀 선수들이 이 움직임만을 따라서 이동한다면 승리하리라고 도현이는 확신한다.
 * 도현이는 선수들에게 자신의 전술을 말해주며, 다른 모든 구역에 도달할 수 있는 시작 구역을 찾은 뒤 지시한 움직임만을 따라가라고 했다. 그러나 도현이는 한 가지 간과한 것이 있었는데 그건 선수들이 자신만큼 똑똑하지 않다는 것이다. 선수들은 그러한 시작 구역을 찾는 것이 어려웠다. 
 * 이제 당신이 적절한 시작 구역을 찾아줘야 한다.
 * 
 * [입력]
 * 첫 번째 줄에 테스트 케이스의 개수가 주어지며, 이는 11보다 작거나 같은 정수이다.
 * 그 다음 줄부터 여러 개의 테스트 케이스가 주어지는데, 각 테스트 케이스마다 첫 번째 줄에 구역의 수 N, 지시한 움직임의 수 M이 주어지며 1 ≤ N, M ≤ 100,000 이다. 
 * 그 다음 M개의 줄에 걸쳐서 움직임 (A, B)가 주어지며, A, B는 0 ≤ A, B < N인 정수이다.
 * 각 테스트 케이스는 하나의 빈 줄로 구분된다.
 * 
 * [출력]
 * 각 테스트 케이스마다 가능한 모든 시작 구역을 오름차순으로 한 줄에 하나씩 출력한다. 만약 그러한 시작 구역이 없으면, "Confused"를 출력한다.
 * 각 테스트 케이스의 끝에는 하나의 빈 줄을 출력한다.
 */
public class SCC_3977 {

	static BufferedReader br;
	static BufferedWriter bw;
	static int n, m;
	static List<Integer> adj[];
	static List<ArrayList<Integer>> SCC;
	static Stack<Integer> stack;
	static boolean finished[], inDegree[];
	static int id, identifier[], group[];
	static ArrayList<Integer> result;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testcase = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testcase;i++) {
			if(i>0)br.readLine();
			init();
			tactics();
		}
		bw.flush();
	}
	
	public static void init() throws Exception{
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());	//구역의 수
		m = Integer.parseInt(st.nextToken());	//움직임의 수
		
		stack = new Stack<>();
		SCC = new ArrayList<>();
		adj = new ArrayList[n+1];
		for(int i=0;i<n;i++) {
			adj[i] = new ArrayList<>();
		}
		identifier = new int[n+1];
		finished = new boolean[n+1];
		group = new int[n+1];
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
		}
	}
	
	public static void tactics() throws Exception{
		for(int i=0;i<n;i++) {
			if(identifier[i] == 0) dfs(i);
		}
		
		inDegree = new boolean[SCC.size()+1];
		for(int i=0;i<n;i++) {
			for(int j=0;j<adj[i].size();j++) {
				int y = adj[i].get(j);
				if(group[i] != group[y]) {
					inDegree[group[y]] = true;
				}
			}
		}
		
		int count = 0;
		result = new ArrayList<>();
		for(int i=0;i<SCC.size();i++) {
			if(!inDegree[i+1]) {
				count++;
				ArrayList<Integer> scc = SCC.get(i);
				for(int j = 0; j<scc.size();j++) {
					result.add(scc.get(j));
				}
			}
		}
		
		if(!result.isEmpty())Collections.sort(result);
		
		if(count != 1) {
			bw.write("Confused\n\n");
		}else {
			for(int i=0;i<result.size();i++) {
				bw.write(result.get(i)+"\n");
			}
			bw.write("\n");
		}
	}
	
	public static int dfs(int x) {
		identifier[x] = ++id;
		stack.push(x);
		
		int parent = identifier[x];
		for(int i=0;i<adj[x].size();i++) {
			int y = adj[x].get(i);
			if(identifier[y] == 0) {
				parent = Math.min(parent, dfs(y));
			}else if(!finished[y]) {
				parent = Math.min(parent, identifier[y]);
			}
		}
		
		if(parent == identifier[x]) {
			ArrayList<Integer> scc = new ArrayList<>();
			while(true) {
				int t = stack.pop();
				scc.add(t);
				finished[t] = true;
				group[t] = SCC.size()+1;
				if(t == x) break;
			}
			SCC.add(scc);
		}
		return parent;
	}
}
