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
 * 연구소
 * 
 * @author hyemin
 * 
 * 완전 탐색 + BFS
 * 1. 벽 세개를 세운다.
 * 2. BFS로 바이러스를 퍼뜨린다.
 * 3. 바이러스가 퍼지지 않은 곳(안전영역)을 카운트한다.
 * 4. 최댓값이라면 갱신
 */
public class BFS_14502{
	
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	static int map[][], copy[][];
	static int N, M;
	static int result = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		copy = new int[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				copy[i][j] = map[i][j];
			}
		}
		
		// 벽 세우기
		buildWall(0);
		
		System.out.println(result);
		
	}
	
	// 1. 벽 세우기
	static void buildWall(int cnt) {
		
		if(cnt == 3) {
			// 2. 바이러스 퍼뜨리기
			spreadVirus();
			return;
		}
		
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(copy[i][j] == 0) {
					copy[i][j] = 1; // 벽 세우기
					buildWall(cnt+1);
					copy[i][j] = 0; // 복구
				}
			}
		}
		
	}
	
	static void spreadVirus() {
		int virus_map[][] = new int[N][M];
		
		// copy 배열 깊은 복사
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				virus_map[i][j] = copy[i][j];
			}
		}
		
		Queue<Point> q = new LinkedList<>();
		// 바이러스  queue에 추가
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(virus_map[i][j] == 2) {
					q.add(new Point(i, j));
				}
			}
		}
		
		// 바이러스 퍼뜨리기
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int i=0;i<4;i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				
				if(px >= 0 && py >= 0 && px < N && py < M) {
					if(virus_map[px][py] == 0) {
						virus_map[px][py] = 2;
						q.add(new Point(px, py));
					}
				}
			}
		}
		
		// 3. 안전영역 카운트
		count(virus_map);
	}
	
	static void count(int[][] arr) {
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		// 4. 최댓값 갱신
		result = Math.max(cnt,  result);
	}
	
	static class Point{
		int x;
		int y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
	
}
