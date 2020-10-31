package programmers.wintercoding;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Winter03 {

	static int[] dx = { 1, -1, 0, 0 }; // x좌표 방향배열
	static int[] dy = { 0, 0, 1, -1 }; // y좌표 방향배열
	static Queue<Point> queue = new LinkedList<>();
	static boolean[][] visited;

	public static int[] solution(int[][] v) {
		int[] answer = new int[3];

		int m = v.length;
		visited = new boolean[m][m];
		
		for(int i=0; i<m; i++) {
			for(int j=0;j<m;j++) {
				if(v[i][j] >= 0 && visited[i][j] != true) {
					bfs(v, i, j, m);
					answer[v[i][j]]++;
				}
			}
		}
		return answer;
	}

	public static void bfs(int[][] v, int x, int y, int m) {
		queue.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			//상하좌우 모두 탐색
			for(int i=0;i<4;i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				
				if(0 <= px && px < m && 0 <= py && py < m) {
					if(v[px][py] == v[x][y] && visited[px][py] != true) {
						queue.add(new Point(px,py));
						visited[px][py] = true;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int v[][] = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 }, { 2, 2, 2, 1 }, { 0, 0, 0, 2 } };
		System.out.println(Arrays.toString(solution(v)));
	}

	static class Point {
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
