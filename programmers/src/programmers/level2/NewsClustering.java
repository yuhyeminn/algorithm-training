package programmers.level2;

import java.util.HashMap;
import java.util.Map;

/**
 * 뉴스 클러스터링(2018 카카오)
 *
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/17677
 */
public class NewsClustering {

	static Map<String, Integer> totalSet;	//두개의 문자열의 다중집합이 저장되는 map
	static Map<String, Integer> str1_set;	
	static Map<String, Integer> str2_set;	
	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";
		System.out.println("result="+solution(str1, str2));
	}
	
	public static int solution(String str1, String str2) {
        int answer = 0;
        totalSet = new HashMap<>();
        str1_set = new HashMap<>();
        str2_set = new HashMap<>();
        
        //다중집합들을 만들어 map에 저장
        int str1_size = multipleSet(str1.toLowerCase(), str1_set);
        int str2_size = multipleSet(str2.toLowerCase(), str2_set);
        
        if(totalSet.size() == 0) return 65536;
        
        //str1과 str2의 유사도 = 교집합 크기 / 합집합 크기
        //u : 합집합의 크기
        //i : 교집합의 크기
        double i = 0;
        for(String set : totalSet.keySet()) {
        	int cnt = totalSet.get(set);
        	if( cnt >= 2 && str1_set.get(set)!=null && str2_set.get(set)!=null) {
        		i += Math.min(str1_set.get(set), str2_set.get(set)); 	
        	}
        }
        double union = str1_size + str2_size - i;
        answer = (int)((double)(i/union) * 65536);
        
        return answer;
    }
	
	public static int multipleSet(String str, Map<String,Integer> map) {
		int cnt = 0;
		for(int i=0;i<str.length()-1;i++) {
			//영어가 아닐 경우 건너뜀.
			if(!Character.isAlphabetic(str.charAt(i)) || !Character.isAlphabetic(str.charAt(i+1))) {
				continue;
			}
			String key = str.substring(i, i+2);
			//해당 문자열 다중집합에 put
			map.put(key, map.getOrDefault(key, 0)+1);
			//전체 다중집합에 put
			totalSet.put(key, map.getOrDefault(key, 0)+1);
			cnt++;
		}
		
		return cnt;
	}
	
}
