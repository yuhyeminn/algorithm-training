package programmers.level2;

import java.util.LinkedList;

/**
 * 캐시(2018 카카오)
 * 
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 * 
 * [조건]
 * 캐시 교체 알고리즘은 LRU(Least Recently Used)를 사용한다.
 * cache hit일 경우 실행시간은 1이다.
 * cache miss일 경우 실행시간은 5이다.
 *
 * **cache hit : 이미 캐시에 있던 페이지를 가장 처음으로 가져옴. 기존에 있던 페이지를 지우고 Queue의 처음에 삽입
 * **cache miss : 캐시가 가득찬 경우 가장 오랫동안 참조하지 않은 페이지 캐시에서 삭제한 후 가장 앞에 페이지 삽입
 * 				  캐시에 자리가 있는 경우엔 가장 앞에 페이지를 삽입
 * 
 * [참조]
 * https://velog.io/@hyeon930/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%BA%90%EC%8B%9C-Java
 * LRU알고리즘 - https://hee96-story.tistory.com/47	 
 */
public class Cache {

	static final int CHACHE_HIT = 1;
	static final int CHACHE_MISS = 5;
	public static void main(String[] args) {
		int cacheSize = 3;
		String cities[] = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
	
		System.out.println("result="+solution(cacheSize, cities));
	}
	
	public static int solution(int cacheSize, String[] cities) {
		if(cacheSize == 0) return CHACHE_MISS * cities.length;
        
		LinkedList<String> queue = new LinkedList<>();
        int answer = 0;
        for(int i=0;i<cities.length;i++) {
        	String city = cities[i].toUpperCase();
        	
        	//chahe hit
        	if(queue.remove(city)) {
        		queue.addFirst(city);
        		answer += CHACHE_HIT;
        	}
        	//chahe miss
        	else {
        		if(queue.size() == cacheSize) {
        			queue.pollLast();
        		}
        		queue.addFirst(city);
        		answer += CHACHE_MISS;
        	}
        }
        
        return answer;
    }

}
