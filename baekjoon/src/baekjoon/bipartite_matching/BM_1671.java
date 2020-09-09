package baekjoon.bipartite_matching;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 상어의 저녁식사 1671
 * 어떤 상어는 저녁식사로 서로를 먹는다. 모든 상어는 자신과 다른 상어의 크기, 속도, 지능을 수치로 나타낸 것을 알고 있다. 
 * 만약, 상어 A의 크기, 속도, 지능이 상어 B의 크기, 속도, 지능보다 크거나 같다면 상어 A는 상어 B를 먹을 수 있다. 
 * 그러나, 상어들의 왕 김재홍은 상어들이 많이 없어지는 것을 방지하기 위해서 한 상어가 최대 두 개의 상어만 먹을 수 있게 했다. 상어들은 김재홍의 말을 모두 듣는다.
 * 능력치가 모두 같은 상어 A, B가 있다면 A가 B를, B가 A를 잡아먹을 수는 있지만 A, B가 서로 잡아먹을수는 없다.
 * N마리 상어의 크기, 속도, 지능이 주어졌을 때, 살아남을 수 있는 상어 수의 최솟값을 구하시오.
 * 
 * [입력]
 * 첫째 줄에 상어의 마리 수 N이 주어진다. 이 값은 50보다 작거나 같은 자연수이다. 둘째 줄부터 각 상어의 크기, 속도, 지능의 정보가 주어진다. 
 * 이 값은 2,000,000,000보다 작거나 같은 자연수이다.
 * 
 * [출력]
 * 첫째 줄에 살아남을 수 있는 상어 수의 최솟값을 출력한다.
 */
public class BM_1671 {
	static int n;
	static int shark[][];
	static List<Integer> adj[];
	static boolean visited[];
	static int match[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//상어 수
		n = Integer.parseInt(br.readLine());
		
		adj = new ArrayList[n+1];
		for(int i=1;i<=n;i++) {
			adj[i] = new ArrayList<>();
		}
		visited = new boolean[n+1];
		match = new int[n+1];
		shark = new int[n+1][3];
		
		// 각 상어의 크기, 속도, 지능을 이차원 배열(shark)에 저장
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			shark[i][0] = Integer.parseInt(st.nextToken());	 //상어의 크기
			shark[i][1] = Integer.parseInt(st.nextToken()); // 상어의 속도
			shark[i][2] = Integer.parseInt(st.nextToken()); // 상어의 지능
		}
		
		// 상어들의 크기, 속도, 지능을 비교하여 잡아먹을 수 있는 상어들을 리스트에 추가
		for(int i=1;i<=n;i++) {
			for(int j=i+1;j<=n;j++) {
				if(shark[i][0]>=shark[j][0] && shark[i][1]>=shark[j][1] && shark[i][2]>=shark[j][2]) {
					adj[i].add(j);
				}else if(shark[i][0]<=shark[j][0] && shark[i][1]<=shark[j][1] && shark[i][2]<=shark[j][2]) {
					adj[j].add(i);
				}
			}
		}
		
		System.out.println(bmatch());
	}
	
	public static int bmatch() {
		int count = 0;
		
		//최대 2마리 까지 잡아 먹을 수 있으므로 2번 매칭
		for(int i=1;i<=n;i++) {
			for(int j=0;j<2;j++) {
				if(dfs(i)) {
					Arrays.fill(visited, false);
					count++;
				}
			}
		}
		
		return n - count;
	}
	
	public static boolean dfs(int x) {
		if(visited[x]) return false;
		
		visited[x] = true;
		for(int i=0;i<adj[x].size();i++) {
			int t = adj[x].get(i);
			if(match[t] == 0 || dfs(match[t])) {
				match[t] = x;
				return true;
			}
		}
		return false;
	}
}
