package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 바이러스
 * @author hyemin
 *
 * [해결]
 * BFS 또는 DFS로 해결
 */
public class Class3_2606 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int V = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N+1][N+1];
		boolean visited[] = new boolean[N+1];
		
		for(int i=0;i<V;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		System.out.println(findComputer(arr, visited, 1));
	}

	private static int findComputer(int[][] arr, boolean[] visited, int virus) {
		Queue<Integer> queue =new LinkedList<>();
		int result = 0;
		
		queue.add(virus);
		visited[virus] = true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			result++;
			for(int i=1;i<arr[x].length;i++) {
				if(i != x && arr[x][i]==1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		
		return result-1;
	}
}
