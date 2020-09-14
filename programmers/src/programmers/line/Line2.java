package programmers.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Line2 {

	public static void main(String[] args) {
		int ball[] = {11,2,100,13,150};
		int order[] = {100,2,13,11,150};
		System.out.println(Arrays.toString(solution(ball,order)));
	}
	
	public static int[] solution(int[] ball, int[] order) {
		int answer[] = new int[ball.length];
		
		List<Integer> pipe = new ArrayList<>();
		List<Integer> hold = new ArrayList<>();
		for(int i=0;i<ball.length;i++) {
			pipe.add(ball[i]);
		}
		
		int orderIndex = 0;
		int resultIndex = -1;
		
		while(orderIndex != order.length) {
			for(int j=0;j<hold.size();j++) {
				for(int i=0;i<hold.size();i++) {
					int n = hold.get(i);
					if(pipe.indexOf(n)==0 || pipe.indexOf(n) == pipe.size()-1) {
						answer[++resultIndex] = n;
//						System.out.println("hold ====" + n + ", " +pipe.indexOf(n));
//						System.out.println(hold.toString());
						pipe.remove(pipe.indexOf(n));
					}
				}
			}
			
			int target = order[orderIndex++];
			int loc = pipe.indexOf(target);
			if(loc == 0 || loc==pipe.size()-1) {
				answer[++resultIndex] = target;
//				System.out.println(target + ", " +loc);
				pipe.remove(loc);
			}else {
				hold.add(target);
			}
		}
		
		return answer;
	}
}
