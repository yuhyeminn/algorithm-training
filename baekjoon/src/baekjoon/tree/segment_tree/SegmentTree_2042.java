package baekjoon.tree.segment_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 구하기 2042
 * 어떤 N개의 수가 주어져 있다. 그런데 중간에 수의 변경이 빈번히 일어나고 그 중간에 어떤 부분의 합을 구하려 한다.
 * 만약에 1,2,3,4,5 라는 수가 있고, 3번째 수를 6으로 바꾸고 2번째부터 5번째까지 합을 구하라고 한다면 17을 출력하면 되는 것이다.
 * 그리고 그 상태에서 다섯 번째 수를 2로 바꾸고 3번째부터 5번째까지 합을 구하라고 한다면 12가 될 것이다.
 * 
 * [입력]
 * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)과 M(1 ≤ M ≤ 10,000), K(1 ≤ K ≤ 10,000) 가 주어진다. M은 수의 변경이 일어나는 횟수이고, K는 구간의 합을 구하는 횟수이다.
 * 그리고 둘째 줄부터 N+1번째 줄까지 N개의 수가 주어진다.
 * 그리고 N+2번째 줄부터 N+M+K+1번째 줄까지 세 개의 정수 a, b, c가 주어지는데, a가 1인 경우 b(1 ≤ b ≤ N)번째 수를 c로 바꾸고 a가 2인 경우에는 b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력하면 된다.
 * 입력으로 주어지는 모든 수는 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
 * 
 * [출력]
 * 첫째 줄부터 K줄에 걸쳐 구한 구간의 합을 출력한다. 단, 정답은 -263보다 크거나 같고, 263-1보다 작거나 같은 정수이다.
 */
/* update 후 원본 데이터인 nums 배열도 수정해줘야 정답처리됨*/
public class SegmentTree_2042 {

	static int N, M, K;
	static int nums[];
	static long tree[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuffer sb = new StringBuffer();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		//세그먼트 트리 생성
		tree = new long[N*4];
		init(0, N-1, 1);
		
		for(int i=0;i<M+K;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 1) {
				update(0, N-1, 1, b-1, c - nums[b-1]);
				nums[b-1] = c;
			}else {
				sb.append(sum(0, N-1, 1, b-1, c-1)).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	public static long init(int start, int end, int node) {
		//리프노드
		if(start == end) {
			return tree[node] = nums[start];
		}
		int mid = (start+end)/2;
		return tree[node] = init(start, mid, node * 2) + init(mid+1, end, node * 2 + 1);
	}
	
	public static void update(int start, int end, int node, int index, int dif) {
		//범위 밖
		if(index < start || index > end) return;
		
		tree[node] += dif;
		if(start == end) return;
		int mid = (start + end) / 2;
		update(start, mid, node * 2, index, dif);
		update(mid + 1, end, node * 2 + 1, index, dif);
	}
	
	public static long sum(int start, int end, int node, int left, int right) {
		if(right < start || left > end) {
			return 0;
		}
		if(left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start + end)/2;
		return sum(start, mid, node * 2, left, right) + sum(mid+1,end, node * 2 + 1, left, right);
	}
}
