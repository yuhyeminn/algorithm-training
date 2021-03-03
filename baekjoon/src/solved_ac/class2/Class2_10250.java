package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * ACM 호텔
 * @author hyemin
 *
 */
public class Class2_10250 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		int H, W, N;
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int floor = N % H ;
			int distance = (N / H) + 1;
			
			if(N%H==0) {
				floor = H;
				distance = N / H ;
			}
			
			sb.append(floor * 100 + distance).append("\n");
		}
		
		System.out.println(sb.toString());
	}

}