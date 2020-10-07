package algorithm.tree;

/**
 * 세그먼트 트리(Segment Tree, 구간 트리)
 * - 주어진 쿼리에 대해 빠르게 응답하기 위해 만들어진 자료구조
 * - 여러 개의 데이터가 연속적으로 존재할 때, 데이터를 적절히 전처리하여 해당 질의에 빠르게 대응할 수 있게 함
 * - 예시 쿼리 : 구간합
 *   	-> 데이터의 합을 가장 빠르고 간단하게 구할 수 있는 자료구조
 * 
 * [참고]
 * https://blog.naver.com/ndb796/221282210534
 * https://gintrie.tistory.com/31
 * https://m.blog.naver.com/PostView.nhn?blogId=sunny_86_&logNo=221495413322&proxyReferer=https:%2F%2Fwww.google.com%2F
 */
public class SegmentTree {

	public static int nums[] = {1, 9, 3, 8, 4, 5, 5, 9, 10, 3, 4, 5};
	public static int tree[];
	
	public static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = nums[start];
		}
		
		int mid = (start + end)/2;
		// 자식노드들의 합으로 부모노드를 채움
		// node*2 : 현재 노드의 왼쪽 자식노드(인덱스)
		// node*2 + 1 : 현재 노드의 오른쪽 자식노드(인덱스)
		return tree[node] = init(start, mid, node*2) + init(mid+1, end, node*2 + 1); 
	}
	
	//만들어진 세그먼트 트리 이용하여 구간합 구하기
	//start, end : 시작인덱스, 끝인덱스
	//left, right : 구간 합을 구하고자 하는 범위
	public static int sum(int start, int end, int node, int left, int right) {
		//범위 밖
		if(left > end || right < start) return 0;
		//범위 안
		if(left <= start && end <= right) return tree[node];
		
		//그 외의 경우(겹쳐져 있을 경우)
		int mid = (start + end)/2;
		return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
	}
	
	//트리 원소에 변경이 있을 경우 세그먼트 트리도 변경되어야 함
	//index : 수정된 노드 인덱스
	//dif : 수정할 값 (해당 인덱스의 원소가 dif로 수정되는 것이 아닌 dif만큼 더해지는 것)
	public static void update(int start, int end, int node, int index, int dif) {
		//범위 밖이면 수정할 필요 없음
		if(index < start || index > end) return;
		
		//범위 안이면 내려가면서 자식노드들의 원소도 갱신
		tree[node] += dif;
		if(start == end) return;
		int mid = (start+end)/2;
		//왼쪽 자식 수정
		update(start, mid, node * 2, index, dif);
		update(mid + 1, end, node * 2 + 1, index, dif);
	}
	
	public static void main(String[] args) {
		int N = nums.length;
		tree = new int[N * 4];
		
		//구간 합 세그먼트 트리 만들기
		init(0, N-1, 1);
		
		//구간 합 구하기
		System.out.println("인덱스 0 ~ 12 구간 합 : " + sum(0, N-1, 1, 0, 12));
		System.out.println("인덱스 3 ~ 8 구간 합 : " + sum(0, N-1, 1, 3, 8));
		
		//구간 합 갱신
		System.out.println("인덱스 5의 원소를 -5만큼 수정");
		update(0, N-1, 1, 5, -5);
		System.out.println("인덱스 3 ~ 8 구간 합 : " + sum(0, N-1, 1, 3, 8));
	}

}
