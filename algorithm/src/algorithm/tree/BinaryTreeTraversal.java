package algorithm.tree;

/**
 * 이진 트리의 구현과 순회 알고리즘
 * 
 * 이진 트리
 * - 기본적으로 가장 많이 사용되는 비선형 자료구조
 * - 데이터의 탐색 속도 증진을 위해 사용하는 구조
 * - 하나의 노드는 왼쪽 자식과 오른쪽 자식을 가질 수 있도록 설계
 * 
 * 트리에서 데이터 탐색하는 방법
 * 	1. 전위 순회(Preorder Traversal) : 루트 > 왼쪽 > 오른족
 *	2. 중위 순회(Inorder Traversal) : 왼쪽 > 루트 > 오른쪽
 * 	3. 후위 순회(Postorder Traversal) : 왼쪽 > 오른쪽 > 루트
 * 
 */
public class BinaryTreeTraversal {
	
	public static class Node {
	       protected Node left;
	       private Object data;
	       protected Node right;

	       public Node(Object data) {
	              left =null;
	              right =null;
	              this.data = data;
	       }

	       public Object getData(){
	              return this.data;
	       }
	}

	public Node makeBT(Node bt1, Object data, Node bt2){
	
	        Node newNode = new Node(data);
	        newNode.left = bt1;
	        newNode.right =bt2;
	
	        return newNode;
	 }
	
	 public void preorder(Node root){
	        if(root != null){
	               System.out.print(root.getData());
	               preorder(root.left);
	               preorder(root.right);
	        }
	 }
	
	 public void inorder(Node root){
	        if(root != null){
	               inorder(root.left);
	               System.out.print(root.getData());
	               inorder(root.right);
	        }
	 }
	
	 public void postorder(Node root){
	        if(root != null){
	               postorder(root.left);
	               postorder(root.right);
	               System.out.print(root.getData());
	        }
	 }

	 public static void main(String[] args) {
		 BinaryTreeTraversal bt = new BinaryTreeTraversal();

         Node n4 = bt.makeBT(null, 4, null);
         Node n5 = bt.makeBT(null, 5, null);
         Node n2 = bt.makeBT(n4, 2, n5);
         Node n3 = bt.makeBT(null, 3, null);
         Node n1 = bt.makeBT(n2, 1, n3);

         System.out.print("preorder : ");
         bt.preorder(n1);
         System.out.println();

         System.out.print("inorder : ");
         bt.inorder(n1);
         System.out.println();

         System.out.print("postorder : ");
         bt.postorder(n1);
         System.out.println();
	 }
}
