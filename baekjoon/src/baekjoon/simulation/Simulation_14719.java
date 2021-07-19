package baekjoon.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 빗물
 * 
 * @author hyemin
 * 
 * [https://covenant.tistory.com/224] - part2.시뮬레이션의 응용
 * 
 */
public class Simulation_14719 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		
		int H = Integer.parseInt(str[0]);
		int W = Integer.parseInt(str[1]);
		int blocks[] = new int[W];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<W;i++) {
			blocks[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;	//왼쪽 max
		int right = 0;	//오른쪽max
		int result = 0;
		for(int i=0;i<W;i++) {
			int now = blocks[i];
			
			//left, right 초기화
			left = 0; right = 0;
			
			// 현재 기준 왼쪽 가장 큰 블럭
			for(int j=0;j<i;j++) {
				left = Math.max(left, blocks[j]);
			}
			// 현재 기준 오른쪽 가장 큰 블럭
			for(int j=i+1;j<W;j++) {
				right = Math.max(right, blocks[j]);
			}
			
			// 현재 블럭이 left-right보다 작으면 빗물 채워짐.
			// 빗물은 left, right 중 작은 블럭 기준으로 채워짐
			if(now < left && now < right) {
				result += Math.min(left, right) - now;
			}
		}

		System.out.println(result);
	}

	
}
