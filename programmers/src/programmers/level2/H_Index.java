package programmers.level2;

import java.util.Arrays;

/**
 * H-Index
 * 
 * [문제]
 * H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
 * 어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
 * 어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
 *
 * [제한사항]
 * 과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
 * 논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
 */
public class H_Index {

	public static void main(String[] args) {
		int[] citations = {0,0,0};
		System.out.println("result="+solution(citations));
	}
	
	public static int solution(int[] citations) {
		int answer = 0;
		
		Arrays.sort(citations);
		
		int n = citations.length;
		while(n > 0) {
			int a = 0;	//num 이상인 개수
			int b = 0;	//num 이하인 개수
			for(int i=0;i<citations.length;i++) {
				if(n <= citations[i]) {
					a++;
				}else {
					b++;
				}
			}
			if(a>=n && b<=n) {
				return n;
			}
			n--;
		}
		return answer;
	}
	
	/* 다른사람 풀이
	 public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
	*/
}
