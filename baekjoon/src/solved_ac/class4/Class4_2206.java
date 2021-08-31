package solved_ac.class4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 벽 부수고 이동하기
 * 
 * @author hyemin
 * 
 */
public class Class4_2206 {
	
	static int N, M;
	static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int[][] visited;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		
		map = new int[N][M];
		visited = new int[N][M];
		
		for(int i=0;i<N;i++) {
			str = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(str[j]);
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		
		int result = bfs(0, 0);
		System.out.println(result);
		
	}
	
	static int bfs(int x, int y) {
		
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x, y, 1, 0));
		visited[y][x] = 0;	// 공사 횟수 초기화
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.x == M-1 && p.y == N-1) {
				return p.dis;
			}
			
			for(int i=0;i<4;i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				
				if(!(px >= 0 && py >= 0 && px < M && py < N)) continue;
				
				if(visited[py][px] <= p.breakWall) continue;
				
				// 벽이 아닐 경우
				if(map[py][px] == 0) {
					q.add(new Point(px, py, p.dis+1, p.breakWall));
					visited[py][px] = p.breakWall;
				}else {
					if(p.breakWall == 0) {
						q.add(new Point(px, py, p.dis+1, p.breakWall+1));
						visited[py][px] = p.breakWall + 1;
					}
				}
			}
		}
		
		return 0;
	}
	
	static class Point {
		int x;
		int y;
		int dis;
		int breakWall;
		
		public Point(int x, int y, int dis, int breakWall) {
			super();
			this.x = x;
			this.y = y;
			this.dis = dis;
			this.breakWall = breakWall;
		}
	}
	
}