package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 수찾기
 * https://www.acmicpc.net/problem/1920
 * 
 * [해결]
 * 선형 탐색(시간초과) -> 이분 탐색 사용
 */
public class Class2_1920 {
    
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input[] = br.readLine().split(" ");
		int arr[] = new int[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		// 이분 탐색을 위한 정렬
		Arrays.sort(arr);
		
		int M = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		for(int i=0;i<M;i++) {
			binarySearch(arr, Integer.parseInt(input[i]));
		}
	}

	private static void binarySearch(int[] arr,int num) {
		int left = 0;
		int right = arr.length-1;
		boolean flag = false;
		
		while(left <= right) {
			int mid = (left+right)/2;
			if(arr[mid] > num) {
				right = mid-1;
			}else if(arr[mid] < num) {
				left = mid+1;
			}else {
				flag = true;
				break;
			}
		}
		
		if(flag) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
}