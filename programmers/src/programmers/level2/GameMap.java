package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMap {

	public static void main(String[] args) {
		int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		System.out.println(solution(maps));
	}
	
	//방향배열 필요
	static int dx[] = {0, 1, 0, -1};
	static int dy[] = {-1, 0, 1, 0};
	static boolean visited[][];
	static int n, m;
	public static int solution(int[][] maps) {
        int answer = 0;
        
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = bfs(0, 0, maps);
        
        return answer;
    }
	
	private static int bfs(int x, int y, int[][] maps) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, 1));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node now = queue.poll();
			if(now.x == n-1 && now.y == m-1) return now.cnt; //(n,m) 도달할 경우
			
			for(int i=0;i<4;i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if(maps[nx][ny] == 1 && !visited[nx][ny]) {
						visited[nx][ny] = true;
						queue.add(new Node(nx, ny, now.cnt + 1));
					}
				}
			}
		}
		
		return -1;
	}
	
	static class Node{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
		
	}
	
	

}
