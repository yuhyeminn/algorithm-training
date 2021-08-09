package baekjoon.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 뱀
 * 
 * @author hyemin
 * 
 */
public class Queue_3190{

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	static Map<Integer, String> change_dir;	//뱀의 방향 변환 정보
	static int board[][];	//정사각 보드(사과-1, 몸통-2)
	static int N, K;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		
		board = new int[N+1][N+1];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			board[x][y] = 1;
		}
		
		change_dir = new HashMap<>(); 
		int L = Integer.parseInt(br.readLine());
		for(int i=0;i<L;i++) {
			st = new StringTokenizer(br.readLine());
			int second = Integer.parseInt(st.nextToken());
			String direction = st.nextToken();
			
			change_dir.put(second, direction);
		}
		
		
		// 게임 진행 - 결과 반환
		int result = snake_game();
		System.out.println(result);
	}
	
	static int snake_game() {
		int time = 0;
		int dir_idx = 0;	// 뱀의 현재 방향
		
		int px = 1, py = 1;	// 뱀 머리 위치(초기값 (1,1))
		Queue<Point> snake = new LinkedList<>(); // 뱀의 머리-꼬리 정보
		snake.offer(new Point(1, 1));
		board[1][1] = 2;
		
		while(true) {
			time++;
			
			px += dx[dir_idx];
			py += dy[dir_idx];
			
			// 벽이나 자기 자신에 부딪힐 경우
			if(px < 1 || py < 1 || px > N || py > N || board[px][py] == 2) {
				break;
			}
			
			// 사과가 없는 경우
			if(board[px][py] == 0) {
				// 꼬리 줄이기
				Point retail = snake.poll();
				board[retail.x][retail.y] = 0;
			}
			
			// 머리 다음칸에 위치시킴
			snake.offer(new Point(px,py));
			board[px][py] = 2;
			
			// 방향 변환
			if(change_dir.containsKey(time)) {
				String dir = change_dir.get(time);
				if("D".equals(dir)) {
					dir_idx = (dir_idx == 3) ? 0 : dir_idx+1 ;
				}else if("L".equals(dir)) {
					dir_idx = (dir_idx == 0) ? 3 : dir_idx-1;
				}
			}
		}
		
		return time;
	}

	static class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
