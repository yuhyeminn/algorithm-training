package algorithm.tree;

/**
 * 최소 공통 조상(LCA, Lowest Common Ancestor)
 * - 트리구조에서 특정한 두 노드의 공통된 조상 중에서 가장 가까운 조상을 찾는 알고리즘
 * - 두 노드 사이의 거리를 빠르게 구하는 등 다양한 계산에서 활용됨
 * - 일종의 다이나믹 프로그래밍
 * - 이진트리가 아니여도 상관 없음
 * 
 * 1. 모든 노드에 대한 깊이를 구함
 * 2. 모든 노드에 대한 2^i번째 부모 노드를 구함
 * 3. 최소 공통 조상을 찾을 두 노드 설정
 * 4. 두 노드의 깊이가 동일하도록 거슬러 올라감
 * 5. 최상단 노드부터 내려오는 방식으로 두 노드의 공통 부모를 찾아냄
 */
public class LowestCommonAncestor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
