package programmers.code_challenge.challenge_0910;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class challenge1 {
	static List<Integer> result;

	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		System.out.println(Arrays.toString(solution(numbers)));
	}

	public static int[] solution(int[] numbers) {
		boolean[] visited = new boolean[numbers.length];
		result = new ArrayList<>();

		combination(numbers, visited, 0, numbers.length, 2);

		Collections.sort(result);
		int answer[] = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}

	public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (visited[i]) {
					sum += arr[i];
				}
			}
			if (result.indexOf(sum) == -1)
				result.add(sum);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}
}
