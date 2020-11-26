package baekjoon.bfs_and_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 단지 번호 붙이기 2667
 * 
 * [문제]
 * <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 
 * 철수는 이 지도를 가지고 연결된 집들의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 
 * 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
 * 대각선상에 집이 있는 경우는 연결된 것이 아니다.
 * 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
 *
 * [입력]
 * 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
 * 
 * [출력]
 * 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 * 
 */
public class BFS_DFS_2667 {

	static int[] dx = {1, -1, 0, 0};	//x좌표 방향배열
	static int[] dy = {0, 0, 1, -1};	//y좌표 방향배열
	static String[][] apt;
	static boolean[][] visited;
	static Queue<Point> queue;
	static int size = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		apt = new String[N][N];
		visited = new boolean[N][N];
		queue = new LinkedList<>();
		List<Integer> answer = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			String arr[] = br.readLine().split("");
			for(int j=0;j<N;j++) {
				apt[i][j] = arr[j];
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if("1".equals(apt[i][j]) && visited[i][j] == false) {
					size = 1;
					bfs(i, j, N);
					answer.add(size);
				}
			}
		}
		
		System.out.println(answer.size());
		Collections.sort(answer);
		for(Integer n : answer) {
			System.out.println(n);
		}
	}
	
	public static void bfs(int x, int y, int n) {
		queue.add(new Point(x,y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			//4방향 탐색
			for(int i=0;i<4;i++) {
				int px = p.x + dx[i];
				int py = p.y + dy[i];
				
				if(0 <= px && px < n && 0 <= py && py < n) {
					if("1".equals(apt[px][py]) && visited[px][py] != true) {
						queue.add(new Point(px, py));
						visited[px][py] = true;
						size++;
					}
				}
			}
		}
	}
	
	public static class Point{
		int x;
		int y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
