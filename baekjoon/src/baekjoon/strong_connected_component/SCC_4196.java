package baekjoon.strong_connected_component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 도미노 4196
 * 도미노는 재밌다. 도미노 블록을 일렬로 길게 늘어세운 뒤 블록 하나를 넘어뜨리면 그 블록이 넘어지며 다음 블록을 넘어뜨리는 일이 반복되어 일렬로 늘어선 블록들을 연쇄적으로 모두 쓰러뜨릴 수 있다. 
 * 그러나, 가끔씩 도미노가 다른 블록을 넘어뜨리지 못하게 배치되어 있다면, 우리는 다음 블록을 수동으로 넘어뜨려야 한다.
 * 이제 각 도미노 블록의 배치가 주어졌을 때, 모든 블록을 넘어뜨리기 위해 손으로 넘어뜨려야 하는 블록 개수의 최솟값을 구하자.
 * 
 * [입력]
 * 첫 번째 줄에 테스트 케이스의 개수가 주어진다.
 * 각 테스트 케이스의 첫 번째 줄에는 두 정수 N, M이 주어지며 두 수는 100,000을 넘지 않는다. 
 * N은 도미노의 개수를, M은 관계의 개수를 나타낸다. 도미노 블록의 번호는 1과 N 사이의 정수다. 
 * 다음 M개의 줄에는 각각 두 정수 x, y가 주어지는데, 이는 x번 블록이 넘어지면 y번 블록도 넘어짐을 뜻한다.
 * 
 * [출력]
 * 각 테스트 케이스마다 한 줄에 정수 하나를 출력한다. 정답은 손으로 넘어뜨려야 하는 최소의 도미노 블록 개수이다.
 */

/*
   각 SCC를 하나의 정점으로 보고 위상정렬을 수행했을 때, 진입 차수가 0인 정점의 개수를 세면 되는 문제
   따라서 모든 강한 결합 요소에 대해서 각각 고유한 번호 값을 매겨 그룹을 만든 뒤에, 각가의 그룹을 하나의 정점으로 보고 단순하게 진입 차수가 0인 그룹의 갯수만 세주면 됨. 
 */
public class SCC_4196 {
	static BufferedReader br;
	static int n, m;
	static int id, identifier[];
	static List<Integer> adj[];
	static List<ArrayList<Integer>> SCC;
	static Stack<Integer> stack;
	static boolean finished[];
	static int group[];
	static boolean inDegree[];
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		//테스트케이스 개수만큼 실행
		int testcase = Integer.parseInt(br.readLine());
		for(int i=0;i<testcase;i++) {
			domino();
		}
	}
	
	public static void domino() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());	//도미노의 개수
		m = Integer.parseInt(st.nextToken());	//관계의 개수
		
		adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		finished = new boolean[n+1];
		identifier = new int[n+1];
		group = new int[n+1];
		stack = new Stack<>();
		SCC = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adj[x].add(y);
		}
		
		// n번의 dfs수행하며 SCC 찾기
		for(int i=1;i<=n;i++) {
			if(identifier[i]==0) dfs(i);
		}
		
		// SCC를 한 정점으로 생각
		inDegree = new boolean[SCC.size()+1];
		for(int i=1;i<=n;i++) {
			for(int j=0;j<adj[i].size();j++) {
				//i와 연결된 노드 중 다른 그룹에 있는 노드가 존재할 경우 해당 그룹의 진입차수 true로 설정
				int y = adj[i].get(j);
				if(group[i] != group[y]) {
					inDegree[group[y]] = true;
				}
			}
		}
		
		//result = 진입 차수가 존재하지 않는(false) 그룹의 수 = 모든 블록을 넘어뜨리기 위해 손으로 넘어뜨려야 하는 블록 개수의 최솟값
		int result = 0;
		for(int i=0;i<SCC.size();i++) {
			if(!inDegree[i]) result++;
		}
		
		System.out.println(result);
	}
	
	public static int dfs(int x) {
		identifier[x] = ++id;
		stack.push(x);
		
		int parent = identifier[x];
		for(int i=0;i<adj[x].size();i++) {
			int y = adj[x].get(i);
			if(identifier[y]==0) {
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
				if(t==x) break;
			}
			SCC.add(scc);
		}
		
		return parent;
	}
	
}
