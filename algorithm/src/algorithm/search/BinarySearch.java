package algorithm.search;

/**
 * 이분 탐색(Binary Search)
 * - 데이터가 정렬이 되어있는 상황에서 범위를 반씩 좁혀가며 데이터를 빠르게 탐색하는 알고리즘
 * - 순차 탐색(Linear Search) : 데이터의 정렬 유무에 상관 없이 데이터를 순차적으로 하나씩 확인하여 탐색하는 알고리즘
 * - 데이터의 중간 위치에서부터 탐색을 시작하여 찾고자 하는 데이터와 크기 비교해가며 다음 탐색 구간을 정함
 * - 시간복잡도 O(logN)
 */
public class BinarySearch {
	//1 3 5 7 9 11 14 15 18 19 25 28 에서 7은 몇 번째 위치에 존재하는가
	static int data[] = {1, 3, 5, 7, 9, 11, 14, 15, 18, 19, 25, 28};
	static int find = 7;
	public static void main(String[] args) {
		int N = data.length;
		int result = search(0, N-1, find);
		if(result != -1) {
			System.out.println((result + 1) + "번째에서 찾았습니다");
		}
	}
	
	public static int search(int start, int end, int target) {
		if(start > end) return -1;
		
		int mid = (start + end)/2;
		if(data[mid] == target) return mid;
		else if(data[mid] > target) return search(start, mid - 1, target);
		else return search(mid + 1, end, target);
	}
}
