package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 * 직사각형에서 탈출
 * https://www.acmicpc.net/problem/1085
 * 
 * [해결]
 * - 현재 x,y가 각각 0과 w,h와의 거리 중 더 작은값을 각각 구한 후, 두 값 중 최솟값을 판별하면 됨
 */
public class Class2_1085 {
    
	public static void main(String[] args) throws Exception{
      
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		
		int x = Integer.parseInt(arr[0]);
		int y = Integer.parseInt(arr[1]);
		
		int w = Integer.parseInt(arr[2]);
		int h = Integer.parseInt(arr[3]);
		
		int d_x = Math.min(x, w-x);
		int d_y = Math.min(y, h-y);
		
		System.out.println(Math.min(d_x, d_y));
	}
}