package programmers.challenge_0910;

public class challenge2 {
	public static void main(String[] args) {
		int N = 6;

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

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i + 1; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
