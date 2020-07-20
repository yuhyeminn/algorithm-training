package algorithm.sort;

import java.util.Arrays;

/**
 * 계수 정렬(Counting Sort)
 * - 크기를 기준으로 갯수만 세주기 때문에 위치를 바꿀 필요 없는 정렬 알고리즘
 * - 모든 데이터에 한번씩만 접근함
 * - 범위조건이 있는 경우에 한해 매우 빠른 알고리즘
 * - 시간 복잡도 : O(N)
 */
public class CountingSort {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 2, 4, 3, 2, 5, 3, 1, 2, 3, 4, 4, 3, 5, 1, 2, 3, 5, 2, 3, 1, 4, 3, 5, 1, 2, 1, 1, 1 };
		System.out.println(Arrays.toString(CountingSort.sort(arr)));
		
	}
	
	public static int[] sort(int[] arr) {
		
		int max = Integer.MIN_VALUE;
		int result[] = new int[arr.length];
		
		//배열 원소 중 최댓값 찾기
		for(int i=0;i<arr.length;i++) {
			if(arr[i] > max) max = arr[i];
		}
		
		int[] count = new int[max+1];
		
		//count배열 모두 0으로 초기화
		for(int i=0;i<count.length;i++) {
			count[i] = 0;
		}
		
		//배열 순회하면서 해당 카운트배열 이용하여 증가
		for(int i=0;i<arr.length;i++) {
			count[arr[i]]++;
		}
		
		//누적합으로 변경
		for(int i=1;i<count.length;i++) {
			count[i] += count[i-1];
		}
		
		//데이터배열 거꾸로 순회하면서 누적합 이용하여 인덱스값 찾아줌
		for(int i=arr.length-1;i>=0;i--) {
			result[--count[arr[i]]] = arr[i];
		}
		
		return result;
		
	}
}
