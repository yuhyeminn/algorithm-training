package algorithm.search;

import java.util.Stack;
/**
 * 스택(Stack)
 * - 후입선출 LIFO(Last In First Out) 구조를 가지는 자료구조
 * - 가장 마지막의 데이터의 위치에 대해 삽입이나 삭제가 발생
 * - Stack util을 제공해주므로 따로 구현할 필요 없음
 */
public class StackClass {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		//데이터 삽입
		stack.push(5);
		stack.push(4);
		stack.push(3);
		//가장 마지막 데이터 삭제
		stack.pop();
		stack.push(2);
		stack.push(1);
		
		System.out.println(stack.toString());
		
		stack.pop();
		stack.pop();
		
		System.out.println(stack.toString());
		System.out.println(stack.isEmpty()); //스택이 비어있는 상태인지 boolean값 리턴
		
		System.out.println(stack.peek()); // 데이터를 삭제하지 않고 현재 가장 마지막에 위치하는 데이터 읽기
		System.out.println(stack.size()); // 사이즈 확인
	}
	
	
}
