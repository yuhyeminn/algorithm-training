package programmers.code_challenge.challenge_0415;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Challenge02 {

	public static void main(String[] args) {
		int a[] = { -5, 0, 2, 1, 2 };
		int edges[][] = { { 0, 1 }, { 3, 4 }, { 2, 3 }, { 0, 3 } };
		solution(a, edges);
	}

	static int N;
	static int tree[][];
	static boolean visited[];

	public static long solution(int[] a, int[][] edges) {
		long answer = -1;

		N = a.length;
		tree = new int[N][N];
		visited = new boolean[N];
		for (int i = 0; i < edges.length; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			tree[x][y] = tree[y][x] = 1;
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(visited, false);
			int result = bfs(i, a);
			if (result > 0) {
				answer = Math.min(result, answer);
			}
		}

		return answer;
	}

	public static int bfs(int start, int[] a) {
		int sum = 0;
		int count = 0;
		Queue<Integer> q = new LinkedList<>();

		q.add(start);
		sum += a[start];
		visited[start] = true;

		while (!q.isEmpty()) {
			int current = q.poll();
			count += Math.abs(a[current]);
			
			for (int i = 0; i < N; i++) {
				if (tree[current][i] == 1 && !visited[i] && a[i] != 0) {
					q.add(i);
					visited[i] = true;
					sum += a[i];
				}
			}
		}

		if (sum == 0) {
			return count-1;
		} else {
			return -1;
		}
	}
	
	public long solution2(int[] a, int[][] edges) {
        long answer = 0;

        int sum = 0;
        int psum = 0; //양수 합
        for(int i=0; i<a.length;i++) {
            sum += a[i];
            if(a[i] > 0) {
                psum += a[i];
            }
        }

        if(sum==0) {
            answer = (psum * 2)-1;
        }else {
            answer =  -1;
        }

        return answer;
    }
}
