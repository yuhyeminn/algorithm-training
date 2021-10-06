package programmers.cos_pro;

import java.util.LinkedList;
import java.util.Queue;
/**
 * 꽃피우기
 * https://programmers.co.kr/learn/courses/11132/lessons/71155
 * 
 * @author hyemin
 * 
 * bfs 활용 문제
 */
public class Java6_1 {
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int n;
	public static int solution(int[][] garden) {
		int answer = 0;
		n = garden.length;
		Queue<Flower> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (garden[i][j] == 1) {
					q.add(new Flower(i, j, 0));
				}
			}
		}

		while (!q.isEmpty()) {
			Flower f = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = f.x + dx[i];
				int ny = f.y + dy[i];
				int nday = f.day + 1;
				
				if (nx >= 0 && ny >= 0 && nx < n && ny < n && garden[nx][ny] == 0) {
					garden[nx][ny] = 1;
					q.add(new Flower(nx, ny, nday));
					answer = nday;
				}
			}
		}
		
		return answer;
	}

	static class Flower {
		int x;
		int y;
		int day;

		public Flower(int x, int y, int day) {
			super();
			this.x = x;
			this.y = y;
			this.day = day;
		}

	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int[][] garden1 = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int ret1 = solution(garden1);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

		int[][] garden2 = { { 1, 1 }, { 1, 1 } };
		int ret2 = solution(garden2);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");

	}
}
