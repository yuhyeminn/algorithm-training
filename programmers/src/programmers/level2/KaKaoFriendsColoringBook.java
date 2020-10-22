package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 카카오 프렌즈 컬러링북 
 *
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/1829
 * 
 * [참고]
 * https://swycha.tistory.com/141
 */
public class KaKaoFriendsColoringBook {

	static int[] dx = {1, -1, 0, 0};	//x좌표 방향배열
	static int[] dy = {0, 0, 1, -1};	//y좌표 방향배열
	static Queue<Point> queue = new LinkedList<>();
	static boolean[][] visited;
	static int size = 0;		//칸의 개수
	
	public static int[] solution(int m, int n, int[][] picture) {
		int area_cnt = 0;
		int max_size_area = 0;
		
		visited = new boolean[m][n];
		
		for(int i=0; i<m; i++) {
			for(int j=0;j<n;j++) {
				if(picture[i][j] > 0 && visited[i][j] != true) {
					size = 1;
					bfs(picture, i, j, m, n);
					area_cnt++;
					if(max_size_area < size) {
						max_size_area = size;
					}
				}
			}
		}
		
		int answer[] = new int[2];
		answer[0] = area_cnt;
		answer[1] = max_size_area;
		
		return answer;
	}
	
	public static void bfs(int[][] picture, int x, int y, int m, int n) {
		queue.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			//상하좌우 모두 탐색
			for(int i=0;i<4;i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				
				if(0 <= px && px < m && 0 <= py && py < n) {
					if(picture[px][py] == picture[x][y] && visited[px][py] != true) {
						queue.add(new Point(px,py));
						visited[px][py] = true;
						size++;	//지나온 칸의 개수(영역 사이즈)
					}
				}
			}
		}
	}
	
	static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int picture[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		System.out.println("result = " + Arrays.toString(solution(m, n, picture)));
	}
}
