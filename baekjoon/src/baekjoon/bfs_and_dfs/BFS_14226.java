package baekjoon.bfs_and_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 이모티콘
 * 
 * @author hyemin
 * 
 */
public class BFS_14226{

	static boolean visited[][] = new boolean[1001][1001]; //[clipboard][screen]
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int S = Integer.parseInt(br.readLine());
		
		bfs(S);
		
	}
	
	static void bfs(int S) {
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 1, 0));
		visited[0][1] = true;
		
		while(!q.isEmpty()) {
			
			Node n = q.poll();
			
			if(n.screen == S) {
				System.out.println(n.time);
				return;
			}
			
			// 복사
			q.offer(new Node(n.screen, n.screen, n.time+1));
			
			// 붙여넣기
			// 일부만 붙여넣기 할 수 없기에 visited 배열 확인
			if(n.clipboard != 0 
					&& n.screen + n.clipboard <= S 
					&& !visited[n.clipboard][n.screen + n.clipboard]) {
				
				visited[n.clipboard][n.screen + n.clipboard] = true;
				q.offer(new Node(n.clipboard, n.screen + n.clipboard, n.time + 1));
				
			}
			
			// 삭제
			if(n.screen > 0 && !visited[n.clipboard][n.screen - 1]) {
				q.offer(new Node(n.clipboard, n.screen - 1, n.time + 1));
				visited[n.clipboard][n.screen - 1] = true;
			}
			
		}
		
	}
	
	static class Node{
		int clipboard;
		int screen;
		int time;
		
		public Node(int clipboard, int screen, int time) {
			super();
			this.clipboard = clipboard;
			this.screen = screen;
			this.time = time;
		}
		
	}
	
}
