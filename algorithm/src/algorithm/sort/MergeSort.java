package algorithm.sort;

import java.util.Arrays;

/**
 * 병합 정렬(Merge Sort)
 * 분할 정복 알고리즘
 * - 반으로 나누고(분할) 각 부분집합들에 대해 정렬한 후에 다시 결합 하는 정렬 알고리즘
 * 		1. 데이터가 저장된 배열을 절반으로 나눔
 * 		2. 각각을 순환적으로 정렬
 * 		3. 정렬된 두 개의 배열을 합쳐 전체를 정렬
 * - 기존의 데이터를 담을 추가적인 배열이 필요함
 * - 일반적인 경우 퀵정렬보다 느리지만 어떠한 상황에서도 정확히 O(NlogN)을 보장함
 * - 정확히 반씩 나눈다는 점에서 최악의 경우에도 O(NlogN)
 * - 시간 복잡도 : O(NlogN)
 * 
*/
public class MergeSort {
	
	static int arr[] = {7, 6, 5, 8, 3, 5, 9, 1};
	static int[] temp = new int[arr.length];
	
	public static void main(String[] args) {
		new MergeSort().mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	
	public void merge(int[] arr, int m, int middle, int n) {
		int i = m;				// 첫 번째 부분집합의 시작 위치
		int j = middle + 1;		// 두 번째 부분집합의 시작 위치
		int k = m;				// 배열 temp에 정렬된 원소를 저장할 위치
		
		// 작은 순서대로 배열에 삽입됨
		while(i <= middle && j <= n) {
			if(arr[i]<=arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		//남은 데이터 삽입
		if( i > middle) {
			for(int t=j;t<=n;t++) {
				temp[k++] = arr[t];
			}
		}else {
			for(int t=i;t<=middle;t++) {
				temp[k++] = arr[t];
			}
		}
		
		for(int t=m;t<=n;t++) {
			arr[t] = temp[t];
		}
	}

	void mergeSort(int[] arr, int m, int n) {
		if(m<n) {
			int middle = (m+n)/2;
			mergeSort(arr, m, middle);
			mergeSort(arr, middle+1, n);
			merge(arr, m, middle, n);
		}
	}
}
