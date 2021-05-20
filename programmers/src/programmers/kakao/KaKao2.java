package programmers.kakao;


public class KaKao2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int passenger[] = { 1, 1, 1, 1, 1, 1 };
		int train[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 5 }, { 3, 6 } };
		System.out.println(solution(n, passenger, train));
	}

	static int N;

	public static int[] solution(int n, int[] passenger, int[][] train) {
		int[] answer = new int[2];
		int[] visited = new int[n + 1];
		int[][] rail = new int[n + 1][n + 1];
		N = n;

		for (int i = 0; i < train.length; i++) {
			int a = train[i][0];
			int b = train[i][1];

			rail[a][b] = rail[b][a] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (visited[i] == 0) {
				dfs(i, passenger, rail, visited);
			}
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			if (max <= passenger[i]) {
				max = passenger[i];
				answer[0] = i + 1;
				answer[1] = max;
			}
		}

		return answer;
	}

	private static void dfs(int x, int[] passenger, int[][] rail, int[] visited) {
		visited[x] = 1;

		for (int i = 1; i <= N; i++) {
			if (rail[x][i] == 1 && visited[i] == 0) {
				passenger[i - 1] += passenger[x - 1];
				dfs(i, passenger, rail, visited);
			}
		}
	}

}
