package baekjoon.bipartiteMatching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 축사배정 2188
 * 농부 존은 소 축사를 완성하였다. 축사 환경을 쾌적하게 유지하기 위해서, 존은 축사를 M개의 칸으로 구분하고, 한 칸에는 최대 한 마리의 소만 들어가게 계획했다.
 * 첫 주에는 소를 임의 배정해서 축사를 운영했으나, 곧 문제가 발생하게 되었다. 바로 소가 자신이 희망하는 몇 개의 축사 외에는 들어가기를 거부하는 것이다.
 * 농부 존을 도와 최대한 많은 수의 소가 축사에 들어갈 수 있도록 하는 프로그램을 작성하시오. 축사의 번호는 1부터 M까지 매겨져 있다.
 * 
 * [입력]
 * 첫째 줄에 소의 수 N과 축사의 수 M이 주어진다. (1 ≤ N, M ≤ 200)
 * 둘째 줄부터 N개의 줄에는 각 소가 들어가기 원하는 축사에 대한 정보가 주어진다. 
 * i번째 소가 들어가기 원하는 축사의 수 Si (0 ≤ Si ≤ M)이 먼저 주어지고, 이후 Si개의 축사 번호가 주어진다. 같은 축사 번호가 두 번 이상 주어지는 경우는 없다.
 * 
 * [출력]
 * 첫째 줄에 축사에 들어갈 수 있는 소의 최댓값을 출력한다.
 */
/* 런타임 에러 - 배열 및 그래프 메인에서 생성 -> 최댓값 설정 뒤에 전역함수에서 생성 */
public class BM_2188 {

	static int MAX = 201;
	static LinkedList<Integer> adj[] = new LinkedList[MAX];
	static boolean visited[] = new boolean[MAX];
	static int match[] = new int[MAX];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine()," ");
		
		int n = Integer.parseInt(s.nextToken());	//소
		int m = Integer.parseInt(s.nextToken());	//축사
		
		for(int i=0;i<n+1;i++) {
			adj[i] = new LinkedList<>();
		}
		
		for(int i=1;i<=n;i++) {
			s = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(s.nextToken());
			for(int j=0;j<count;j++) {
				adj[i].add(Integer.parseInt(s.nextToken()));
			}
		}
		
		// 축사 배정
		int count = 0;
		for(int i=1;i<=n;i++) {
			Arrays.fill(visited, false);
			if(dfs(i)) count++;
		}
		System.out.println(count); //출력
	}
	
	
	public static boolean dfs(int x) {
		for(int i=0;i<adj[x].size();i++) {
			int t = adj[x].get(i);
			
			if(visited[t]) continue;
			
			visited[t] = true;
			if(match[t] == 0 || dfs(match[t])) {
				match[t] = x;
				return true;
			}
		}
		return false;
	}
}
