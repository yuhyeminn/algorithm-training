package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 유기농 배추
 * @author hyemin
 *
 * [해결]
 * dfs 이용
 */
public class Class3_1012 {

	static int m;
	static int n;
	static int k;
	static int[][] arr;
	static boolean[][] visited;
	static int result;
	
	static int[] dx = {0, 1, 0, -1}; // 가로
	static int[] dy = {-1, 0, 1, 0}; // 세로
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			arr = new int[n][m];
			visited = new boolean[n][m];
			result = 0;
			
			int x;
			int y;
			//배추밭
			for(int j=0;j<k;j++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				arr[y][x] = 1;
			}
			
			solution();
			
			System.out.println(result);
			
		}
	}
	
	static void solution() {
		//지렁이 개수 구하기
		//배추밭 탐색
		for(int y=0;y<n;y++) {
			for(int x=0;x<m;x++) {
				if(arr[y][x] == 1 && !visited[y][x]) {
					result++;
					visited[y][x] = true;
					dfs(y, x);
				}
			}
		}
	}
	
	private static void dfs(int y, int x) {
		int px, py;
		
		for(int i=0;i<4;i++) {
			py = y + dy[i];
			px = x + dx[i];
			
			if(py>=0 && px>=0 && py<n && px<m) {
				if(arr[py][px]==1 && !visited[py][px]) {
					visited[py][px] = true;
					dfs(py, px);
				}
			}
		}
	}

}