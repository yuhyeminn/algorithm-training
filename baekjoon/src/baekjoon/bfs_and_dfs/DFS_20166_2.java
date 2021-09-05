package baekjoon.bfs_and_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 문자열 지옥에 빠진 호석
 * 
 * @author hyemin
 * 
 * - 시간 초과 문제 해결 -> 완전탐색 이용
 * - 참고 : https://songwonseok.github.io/algorithm/BOJ-20166/
 *
 * - 이전 풀이는 dp적용해 볼 것
 * - 참고 : https://hj-bank.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EB%AC%B8%EC%9E%90%EC%97%B4-%EC%A7%80%EC%98%A5%EC%97%90-%EB%B9%A0%EC%A7%84-%ED%98%B8%EC%84%9D-20166-JAVA?category=873725
 */
public class DFS_20166_2{
	
	static int N, M, K;
	static int dx[] = {-1,-1,0,1,1,1,0,-1}; //위에서부터 시계방향
	static int dy[] = {0,1,1,1,0,-1,-1,-1};
	static char hell[][];
	static Map<String, Integer> map;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		hell = new char[N][M];
		for(int i=0;i<N;i++) {
			hell[i] = br.readLine().toCharArray();
		}
		
		map = new HashMap<>();
		String keyArr[] = new String[K];
		for(int i=0;i<K;i++) {
			String favorite = br.readLine();
			map.put(favorite, 0);
			keyArr[i] = favorite;
		}
		
		solution();
		
		for(String s : keyArr) {
			sb.append(map.get(s)).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void solution() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				dfs(i, j, 1, Character.toString(hell[i][j]));
			}
		}
	}
	
	static void dfs(int x, int y, int idx, String str) {
		if(map.containsKey(str)){
			map.put(str, map.get(str)+1);
		}
		
		if(idx == 5) {
			return;
		}
		
		// 8방향 다 돌기
		for(int i=0;i<8;i++) {
			// 환형
			int nx = (N + x + dx[i]) % N;
			int ny = (M + y + dy[i]) % M;
			
			dfs(nx, ny, idx+1, str + hell[nx][ny]);
		}
	}
}
