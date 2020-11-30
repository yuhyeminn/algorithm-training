package coding_test.nhn_godo;

import java.util.PriorityQueue;

public class Godo05 {

	public static void main(String[] args) {
		int votes[] = {5,10,7,3,8};
		System.out.println(solution(votes));
	}
	
	public static int solution(int[] votes){
		if(votes.length == 1) return 0;
		
		PriorityQueue<Candidate> queue = new PriorityQueue<>();
		for(int i=1;i<votes.length;i++) {
			queue.add(new Candidate(i,votes[i]));
		}
		
		int winner = votes[0];
		int max;
		int cnt = 0;
		while(true) {
			max = queue.peek().cnt--;
			winner++;
			cnt++;
			if(winner > max) return cnt;
		}
    }
	
	public static class Candidate implements Comparable<Candidate>{
		int idx;
		int cnt;
		
		public Candidate(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Candidate o) {
			return o.cnt - this.cnt;
		}
	}
}
