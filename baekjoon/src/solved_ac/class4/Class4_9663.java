package solved_ac.class4;

import java.util.Scanner;

/**
 * N-Queen
 * 
 * @author hyemin
 * 
 * - 백트래킹
 * - 퀸 : 상하좌우 및 대각선으로 거리 제한 없이 한 방향으로 이동이 가능함
 * - 한 열에 하나의 퀸만 존재할 수 있기 때문에 1차원 배열로 처리 -> 배열의 인덱스가 곧 열번호, 배열의 원소가 행번호 
 * - 첫번째 열부터 퀸을 놓으면서 재귀호출하면서 채워나감
 * - 참고 : https://st-lab.tistory.com/118
 */
public class Class4_9663 {
	
	static int arr[];
	static int N;
	static int cnt; // 결과
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		nQueen(0);
		System.out.println(cnt);
	}
	
	public static void nQueen(int depth) {
		// 모든 열 탐색한 경우
		if(depth == N) {
			cnt++;
			return;
		}
		
		// 퀸 놓기
		for(int i=0;i<N;i++) {
			arr[depth] = i;
			
			if(check(depth)) {
				nQueen(depth + 1);
			}
		}
	}
	
	public static boolean check(int col) {
		
		// 이전 열들을 탐색하며 퀸이 놓일 수 있는 행 위치 탐색
		for(int i=0;i<col;i++) {
			// 같은 행에 퀸이 놓일 수 없음
			if(arr[col] == arr[i]) {
				return false;
			}
			// 대각선상에 놓일 수 없음
			// 열의 차 == 행의 차 -> 대각선에 놓여있음
			else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		
		return true;
	}
	
}