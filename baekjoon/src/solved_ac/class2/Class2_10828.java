package solved_ac.class2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 스택
 * @author hyemin
 * 
 */
public class Class2_10828 {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		String command[];
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			command = br.readLine().split(" ");
			
			switch(command[0]) {
			case "push" :
				stack.push(Integer.parseInt(command[1]));
				break;
			case "pop" :
				int num = stack.size() != 0?stack.pop():-1;
				sb.append(num).append("\n");
				break;
			case "size" :
				sb.append(stack.size()).append("\n");
				break;
			case "empty" :
				sb.append(stack.isEmpty()==true?1:0).append("\n");
				break;
			case "top" :
				sb.append(stack.size() != 0? stack.peek():-1).append("\n");
				break;
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
}