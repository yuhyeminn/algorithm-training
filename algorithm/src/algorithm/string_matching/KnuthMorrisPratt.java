package algorithm.string_matching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * KMP(Knuth-Morris-Pratt) 문자열 매칭 알고리즘
 * - 접두사와 접미사의 개념을 활용하여 반복되는 연산을 얼마나 줄일 수 있는지를 판별하여 매칭할 문자열을 빠르게 건너뛰는 기법
 * - pi배열 : 접두사와 접미사의 최대 일치 길이 배열
 * - 모든 경우를 다 비교하지 아도 부분 문자열을 찾을 수 있음
 * - 시간 복잡도  : O(N+M)
 * 
 * [참고]
 * https://bowbowbow.tistory.com/6#comment5168448
 * https://mygumi.tistory.com/61
 */
public class KnuthMorrisPratt {

	public static void main(String[] args) {
		String parent = "ababacabacaabacaaba";
		String pattern = "abacaaba";
		
		List<Integer> result = kmp(parent,pattern);
		System.out.println(result.toString());
	}
	
	public static int[] getPI(String pattern){
	
		int size = pattern.length();
		int j = 0;
		
		int[] pi = new int[size];
		
		for(int i = 1; i < size; i++) {
			while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			if(pattern.charAt(i) == pattern.charAt(j)) {
				pi[i] = ++j;
			}
		}
		
		return pi;
	}
	
	public static ArrayList<Integer> kmp(String parent, String pattern){
		ArrayList<Integer> index = new ArrayList<>();
		
		int[] pi = getPI(pattern);
		
		int parentSize = parent.length();
		int patternSize = pattern.length();
		int j = 0;
		
		for(int i=0;i<parentSize;i++) {
			
			while(j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = pi[j-1];
			}
			
			if(parent.charAt(i) == pattern.charAt(j)) {
				
				if(j == patternSize-1) {
					index.add(i - patternSize + 1);
					j = pi[j];
					
				}else {
					j++;
				}
			}
		}
		
		return index;
	}
}
