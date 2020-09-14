package programmers.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Line6 {
	 static int n,m;
	 static ArrayList<String> adj[];
	 static boolean visited[];
	 static int match[];
	 static int count[];
	 static Map<String,String> result;
	 
	 public static String[] solution(String[] companies, String[] applicants) {
	     String[] answer;
	     
	     n = companies.length;
	     m = applicants.length;
	     
	     String cname[] = new String[n];
	     String apply[] = new String[m];
	     count = new int[n];
	     adj = new ArrayList[n];
	     for(int i=0;i<n;i++) {
	    	 adj[i] = new ArrayList<>();
	     }
	     visited = new boolean[n];
		 match = new int[m];
		 
		 //**선호도 및 지원자의 지원여부 생각해서 저장해야함
    	 for(int i=0;i<applicants.length;i++) {
    		 StringTokenizer st = new StringTokenizer(applicants[i], " ");
    		 String a = st.nextToken();	//a = 0 ~
    		 String arr[] = st.nextToken().split("");
    		 int acount = Integer.parseInt(st.nextToken());
    		 
    		 String s = "";
    		 for(int j=0;j<acount;j++) {
    			 s += arr[j];
    		 }
    		 apply[i] = s;
    	 }
    	 
	     for(int i=0;i<companies.length;i++) {
	    	 StringTokenizer st = new StringTokenizer(companies[i], " ");
	    	 cname[i] = st.nextToken();
	    	 char favorite[] = st.nextToken().toCharArray();
	    	 count[i] = Integer.parseInt(st.nextToken());
	    	 
	    	 for(int j=0;j<favorite.length;j++) {
	    		 int k = favorite[j] - 'a';
	    		 if(apply[k].contains(cname[i])) {
	    			 adj[i].add(favorite[j] + "");
	    		 }
	    	 }
	     }
	     
	     bmatch();
	     
	     answer = new String[n];
	     for(int i=0;i<match.length;i++) {
	    	 String applicant = (char)('a'+i) + "";
	    	 if(answer[match[i]] == null || answer[match[i]].equals("")) {
	    		 answer[match[i]] = cname[match[i]]+"_";
	    	 }
	    	 answer[match[i]] += applicant;
	     }
	     
	     return answer;
	 }
	 
	 public static void bmatch() {
		for (int i = 0; i < n; i++) {
			for(int j=0; j<count[i];j++) {
				if (dfs(i)) {
					Arrays.fill(visited, false);
				}
			}
		}
	}
	 
	public static boolean dfs(int x) {
		if(visited[x]) {
			return false;
		}
		visited[x] = true;
		for(String s : adj[x]) {
			int k = (int)(s.charAt(0) - 'a');
			if(match[k]==0 || dfs(match[k])) {
				match[k] = x;
				return true;
			}
		}
		return false;
	 }
	
	public static void main(String[] args) {
		 String[] companies = {"A fabdec 2", "B cebdfa 2", "C ecfadb 2"};
		 String applicants[] = {"a BAC 1", "b BAC 3", "c BCA 2", "d ABC 3", "e BCA 3", "f ABC 2"}; 
		 System.out.println(Arrays.toString(solution(companies, applicants)));;
	 }
}
