package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 토마토
 * @author hyemin
 * 정수 1 : 익은 토마토
 * 정수 2 : 익지 않은 토마토
 * 정수 -1 : 토마토가 들어있지 않은 칸
 * 
 * [참고]
 * https://dragon-h.tistory.com/16
 */
public class Class3_7576 {
	
	static int box[][];
	static int M, N;
	static Queue<Point> queue = new LinkedList<>();
	static int xArr[] = {-1, 0, 1, 0};	//x 방향배열
	static int yArr[] = {0, 1, 0, -1};	//y 방향배열
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		box = new int[N+1][M+1];
		
		//토마토 저장
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) queue.add(new Point(i,j));
			}
		}
		
		System.out.println(bfs());
	}
 	
 	public static int bfs() {
 		
 		while(!queue.isEmpty()) {
 			Point p = queue.poll();
 			int x = p.row;
 			int y = p.col;
 			
 			for(int i=0;i<4;i++) {
 				int px = x + xArr[i];
 				int py = y + yArr[i];
 				// 상하좌우로 토마토가 익을 수 있는지 여부 확인
 				if(!(px < 1 || px > N || py < 1 || py > M)) {
 					if(box[px][py] == 0) {
 						// 익은 토마토를 큐에 추가
 						queue.add(new Point(px,py));
 						// 익은 토마토의 값 = 이전에 익은 토마토의 값 + 1
 						box[px][py] = box[x][y] + 1;
					}
				}
			}
		}

		// 최소 일수
		int result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				// 안익은 토마토가 있을 경우
				if (box[i][j] == 0) {
					return -1;
				}
				result = Math.max(result, box[i][j]);
			}
		}
		
		return result - 1;
 	
 	}
	
 	
	static class Point{
		int row;
		int col;
		public Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
}
