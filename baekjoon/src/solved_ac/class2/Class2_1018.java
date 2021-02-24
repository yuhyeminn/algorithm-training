package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 체스판 다시 칠하기
 * https://www.acmicpc.net/problem/1018
 * 
 * [참고]
 * https://st-lab.tistory.com/101?category=855026
 *
 */
public class Class2_1018 {
    
	public static void main(String[] args) throws Exception{
      
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		boolean board[][] = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				char ch = str.charAt(j);
				//W일 때 true, B일 때 false
				board[i][j] = ch=='W'?true:false;
			}
		}
		
		// 경우의 수 (N-7)*(M-7)*2 <-(흑/백)
		int min = 64;	//8*8
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				min = Math.min(min, find(board, i,j));
			}
		}
		
		System.out.println(min);
	}
	
	public static int find(boolean[][] board, int x, int y) {
		int end_x = x + 8;
		int end_y = y + 8;
		int cnt = 0;
		
		boolean TF = board[x][y];
		
		for(int i = x; i<end_x;i++) {
			for(int j=y;j<end_y;j++) {
				//올바른 색 아닐 경우
				if(board[i][j] != TF) {
					cnt++;
				}
				TF = !TF;
			}
			//줄 바뀔때마다 색 변경
			TF = !TF;
		}
		cnt = Math.min(cnt, 64-cnt);
		
		return cnt;
	}
}