package programmers.code_challenge.challenge_1105;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Challenge03 {
	static Map<Integer,Integer> map;
	public static void main(String[] args) {
		int a[] = {0,3,3,0,7,2,0,2,2,0};
		System.out.println("result=" + solution(a));
	}
	
	public static int solution(int[] a) {
        map = new HashMap<>();
        for(int i=0;i<a.length;i++) {
        	map.put(a[i],map.getOrDefault(a[i], 0)+1);
        }
        
        int max = 0;
        for(Integer n : map.keySet()) {
        	int size = star(a, n);
        	if(size%2==0 && size > max) {
        		max = size;
        	}
        }
        
        return max * 2;
    }
	
	public static int star(int a[], int num) {
		Set<Pair> set = new HashSet<>();
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<a.length;i++) {
			q.add(a[i]);
		}
		
		int n1 = q.poll();
		while(!q.isEmpty()) {
			int n2 = q.poll();
			if(n1 == n2) continue;
			if(q.size() < 1) break;
			if(n1 == num || n2 == num) {
				Pair p = new Pair(n1, n2);
				if(!set.contains(p)) {
					set.add(new Pair(n1, n2));
					n1 = q.poll();
					continue;
				}else {
					n1 = num;
				}
			}else {
				if(map.get(n1) > map.get(n2)) {
					n1 = n2;
				}
			}
		}
		
		return set.size();
	}
	
	static class Pair{
		int num1;
		int num2;
		
		public Pair(int num1, int num2) {
			this.num1 = num1;
			this.num2 = num2;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (num1 != other.num1)
				return false;
			if (num2 != other.num2)
				return false;
			return true;
		}
	}
}
