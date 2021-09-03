package baekjoon.bfs_and_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문자열 지옥에 빠진 호석
 * 
 * @author hyemin
 * 
 * 시간초과-..
 */
public class DFS_20166{
	
	static int N, M, K;
	static int dx[] = {-1,-1,0,1,1,1,0,-1}; //위에서부터 시계방향
	static int dy[] = {0,1,1,1,0,-1,-1,-1};
	static String favorite;
	static int max_len, answer;
	static char hell[][];
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
		
		for(int i=0;i<K;i++) {
			// 초기화
			answer = 0;
			favorite = br.readLine();
			max_len = favorite.length();
			
			// 실행
			solution(favorite);
			
			// 결과 저장
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void solution(String favorite) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				// 첫번째 글자와 동일할 경우, 주변 격자 탐색
				if(hell[i][j] == favorite.charAt(0)) {
					dfs(i, j, 1);
				}
			}
		}
	}
	
	static void dfs(int x, int y, int idx) {
		
		// 선호하는 문자 길이만큼 dfs 돌았을 경우 (최대 깊이 도달)
		if(idx == max_len) {
			// 선호하는 문자와 같다면 (마지막 글자까지 전부 동일)
			if(hell[x][y] == favorite.charAt(idx-1)) {
				answer = answer + 1;
			}
			return;
		}
		
		// 8방향 다 돌기
		for(int i=0;i<8;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			// 환형
			if(nx < 0) {
				nx = N-1;
			}
			else if(nx >= N) {
				nx = 0;
			}
			
			if(ny < 0) {
				ny = M-1;
			}
			else if(ny >= M) {
				ny = 0;
			}
			
			if(hell[nx][ny] == favorite.charAt(idx)) {
				dfs(nx, ny, idx+1);
			}
		}
	}
}
