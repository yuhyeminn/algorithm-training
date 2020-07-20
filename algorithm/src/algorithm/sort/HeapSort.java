package algorithm.sort;

import java.util.Arrays;

/**
 * 힙 정렬(Heap Sort)
 * - 힙 트리구조(Heap Tree Structure)를 이용하는 정렬 알고리즘
 * - 병합, 퀵 정렬만큼 빠른 알고리즘
 * - 시간복잡도 : O(NlogN)
 * 
 * 힙(Heap)
 * - 최솟값이나 최댓값을 빠르게 찾아내기 위해서 완전 이진트리 기반으로 하는 트리
 * - Heap property를 만족해야함
 * 	 ** max heap property : 부모는 자식보다 크거나 같다
 * 	 ** min heap property : 부모는 자식보다 작거나 같다.
 * - 최대힙 : 부모노드가 자식노드보다 큰 힙
 * 
 * 힙 생성 알고리즘(Heapify Algorithm)
 * - 특정한 노드의 두 자식 중에서 더 큰 자식과 자신의 위치를 바꾸는 알고리즘
 */
public class HeapSort {

	public static void main(String[] args) {
		int heap[] = {5, 6, 5, 8, 3, 5, 9, 1, 6};
//		HeapSort.test(heap);
		HeapSort.heapSort(heap);
		System.out.println(Arrays.toString(heap));
	}
	
	//재귀 사용
	public static void heapify(int[] arr, int n, int i) {
		int p = i; //부모 노드
		int l = i * 2;	//왼쪽 자식 노드
		int r = i * 2 + 1; //오른쪽 자식 노드
		
		if(l < n && arr[p] < arr[l]) {
			p = l;
		}
		
		if(r < n && arr[p] < arr[r]) {
			p = r;
		}
		
		if( i!= p) {
			swap(arr, p, i);
			heapify(arr, n, p);
		}
	}
	
	public static void heapSort(int[] arr) {
		int n = arr.length;
		 /* 주어진 데이터로 max heap을 만든다. Root 노드 방향으로 거슬러 올라감
        	마지막 노드의 부모 노드에서부터 시작 */
		for(int i= n/2-1;i>=0;i--) {
			heapify(arr, n, i);
		}
		
		for(int i= n-1; i>0;i--) {	/* 원소가 하나 남을 때 까지 반복 */
			swap(arr,0,i);			/* 힙에서 최대값(루트)을 가장 마지막 값과 바꾼다. for문을 돌면서 배열 뒤에서부터 차곡차곡 오름차순으로 쌓임 */
			heapify(arr, i, 0);		/* Root 노드 heapify */
		}
		
	}
	
	
	
	//동빈나 ver
	public static void test(int[] heap) {
		//힙 구성
		for(int i=1;i<heap.length;i++) {
			int c = i;
			do {
				int root = (c-1)/2;
				if(heap[root] < heap[c]) {
					swap(heap,root,c);
				}
				c = root;
			}while(c!=0);
		}
		
		//크기를 줄여가며 반복적으로 힙을 구성
		for(int i = heap.length - 1; i>=0; i--) {
			swap(heap, 0, i);
			int root = 0;
			int c = 1;
			do {
				//왼쪽 자식 노드
				c = 2 * root + 1;
				//자식 중에 더 큰 값 찾기
				if(c < i-1 && heap[c] < heap[c+1]) {
					c++;
				}
				//루트보다 자식이 크다면 교환
				if(c<i && heap[root] < heap[c]) {
					swap(heap,root,c);
				}
				root = c;
			}while(c<i);
		}
	}
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
