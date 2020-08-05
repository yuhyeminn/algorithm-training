package algorithm.search;

/**
 * 합집합 찾기(Union Find) 
 * - 다른말로 서로소 집합(Disjoint-Set)알고리즘이라고 하기도 함. 
 * - 다수의 노드들 중 연결된 노드를 찾거나 노드들을 합칠 때 사용 
 * - 1차원 배열 이용. 배열의 인덱스는 노드 번호 / 해당 인덱스의 원소는 부모노드 번호
 *
 */
public class UnionFind {

	// 부모 노드 찾는 재귀 메소드
	public static int getParent(int[] parents, int x) {
		if (parents[x] == x)
			return x;
		return getParent(parents, parents[x]);
	}

	// 합집합 만들기
	public static void unionParent(int[] parents, int x, int y) {
		x = getParent(parents, x);
		y = getParent(parents, y);

		// 더 작은 값으로 부모 노드 설정
		if (x < y)
			parents[y] = x;
		else
			parents[x] = y;
	}

	// 같은 부모인지 확인하는 메소드
	public static boolean isSameParent(int[] parents, int x, int y) {
		boolean result = false;
		x = getParent(parents, x);
		y = getParent(parents, y);
		
//		System.out.println("parents[x] = "+parents[x]);
//		System.out.println("parents[y] = "+parents[y]);
		
		if (x == y) {
			return true;
		}

		return result;
	}

	public static void main(String[] args) {
		int n = 10;
		int[] parents = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parents[i] = i;
		}
		
		unionParent(parents, 1, 2); 
		unionParent(parents, 2, 3); 
		unionParent(parents, 3, 4); 
//		unionParent(parents, 4, 5); 
		unionParent(parents, 5, 6); 
		unionParent(parents, 6, 7); 
		unionParent(parents, 7, 8); 
		unionParent(parents, 9, 10);

		System.out.println("1과 7은 연결이 되어있나? " + isSameParent(parents, 1, 7));
	}
}
