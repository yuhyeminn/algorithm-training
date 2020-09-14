package programmers.line;

import java.util.ArrayList;
import java.util.List;

public class Line1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int solution(int[][] boxes) {
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<boxes.length;i++) {
			for(int j=0;j<boxes[i].length;j++) {
				int index = list.indexOf(boxes[i][j]);
				if(index==-1) list.add(boxes[i][j]);
				else list.remove(index);
			}
		}
		
		if(list.isEmpty()) return 0;
		
		return list.size()/2;
	}

}
