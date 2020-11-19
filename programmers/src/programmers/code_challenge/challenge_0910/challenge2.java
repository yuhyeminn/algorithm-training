package programmers.code_challenge.challenge_0910;

import java.util.Arrays;

/**
 * 삼각 달팽이
 * [문제]
 * 정수 n이 매개변수로 주어집니다. 다음 그림과 같이 밑변의 길이와 높이가 n인 삼각형에서 맨 위 꼭짓점부터 반시계 방향으로 달팽이 채우기를 진행한 후, 첫 행부터 마지막 행까지 모두 순서대로 합친 새로운 배열을 return 하도록 solution 함수를 완성해주세요.
 * https://programmers.co.kr/learn/courses/30/lessons/68645
 *
 */
public class challenge2 {
	public static void main(String[] args) {
		int N = 6;
		System.out.println(Arrays.toString(solution(N)));
	}
	
	public static int[] solution(int N) {
		int[][] arr = new int[N][N];
		int x = -1, y = 0;
		int num = 1;
		for (int i = 0; i < N; i++) {
			for (int j = i; j < N; j++) {
				if (i % 3 == 0) {
					++x;
				} else if (i % 3 == 1) {
					++y;
				} else if (i % 3 == 2) {
					--x;
					--y;
				}
				arr[x][y] = num++;
			}
		}
		
//		int answer[] = new int[getSize(N)];
		int answer[] = new int[N*(N+1)/2];
		int index = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				answer[index++] = arr[i][j];
			}
		}
		
		return answer;
	}
	public static int getSize(int N) {
		int result = 0;
		for(int i=1;i<=N;i++) {
			result+=i;
		}
		return result;
	}
}
