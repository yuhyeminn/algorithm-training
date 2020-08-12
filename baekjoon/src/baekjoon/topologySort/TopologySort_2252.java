package baekjoon.topologySort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologySort_2252 {
	public static LinkedList<Integer>[] edge;
	public static int[] indegree;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine()," ");
        
		//n명의 학생, m번의 키 비교
		//정점 n, 간선 m
		int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());

		edge = new LinkedList[n+1];
		for (int i = 1; i <= n; i++) {
	            edge[i] = new LinkedList<>();
	    }
		
		indegree = new int[n+1];
		
		for(int i=0;i<m;i++) {
			s = new StringTokenizer(br.readLine()," ");
			int x = Integer.parseInt(s.nextToken());
            int y = Integer.parseInt(s.nextToken());
			edge[x].push(y);
			indegree[y]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i=1;i<n+1;i++) {
			if(indegree[i] == 0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int student = q.poll();
			System.out.print(student + " ");
			
			for(int next:edge[student]) {
				indegree[next]--;
				if(indegree[next]==0) {
					q.offer(next);
				}
			}
		}
        br.close();
	}
}
