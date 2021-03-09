package solved_ac.class3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 숨바꼭질
 * @author hyemin
 *
 * [해결]
 *  BFS로 해결...
 *  https://zoonvivor.tistory.com/90
 */
public class Class3_1697 {

	static int subin[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		subin = new int[100001];
		
		if(N >= K) {
			System.out.println(N-K);
		}else {
			bfs(N, K);
			System.out.println(subin[K]);
		}
	}
	
	private static void bfs(int n, int k) {
		Queue<Integer> q = new LinkedList<>();
		int status[] = new int[3]; //n-1, n+1, n*2
		
		subin[n] = 0;
		q.offer(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			
			if(x==k) break;
			
			status[0] = x - 1;
			status[1] = x + 1;
			status[2] = x * 2;
			
			for(int i=0;i<3;i++) {
				int now = status[i];
				//범위를 벗어나지 않았는지 확인
				if(now >=0 && now <= subin.length-1) {
					// 방문하지 않았을 경우
					if(subin[now]==0) {
						q.add(now);
						subin[now] = subin[x] + 1;
					}
				}
			}
		}
	}
	
}
