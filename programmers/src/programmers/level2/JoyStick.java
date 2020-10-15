package programmers.level2;

/**
 * 조이스틱
 * 
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/42860
 * 
 * [제한 사항]
 * name은 알파벳 대문자로만 이루어져 있습니다.
 * name의 길이는 1 이상 20 이하입니다.
 *
 * [참고]
 * https://parksuu.github.io/139-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%A1%B0%EC%9D%B4%EC%8A%A4%ED%8B%B1-(java)/
 */
public class JoyStick {

	public static void main(String[] args) {
		String name = "JAN";
		System.out.println("result="+solution(name));
	}
	
	public static int solution(String name) {
		int answer = 0;
		
		int len = name.length();
		//좌, 우 이동의 최댓 값은 오른쪽으로 쭉 가는 것
		int min_move = len - 1;
		for(int i=0;i<len;i++) {
			//각 알파벳별 위 아래 이동 값
			//아래부터 시작(ch-'A') vs 위부터 시작('Z'-ch+1)
			char ch = name.charAt(i);
			answer += Math.min(ch-'A','Z'-ch+1);
			
			//좌, 우 이동값. 연속된 A의 등장에 따라 최소 움직임이 달라짐
			int next = i+1;
			//다음이 A라면 계속 next++
			while(next < len && name.charAt(next) == 'A') {
				next++;
			}
			//(2*i)+len-next
			//	2*i = 현재위치(i)까지 온 것 + 다시 처음 위치로 돌아가는 것(i)
			//  len - next : name의 마지막 인덱스값 - 연속된 A중 마지막 A의 인덱스 값 ==> Z부터 A가 나오기 전까지의 이동 횟수
			min_move = Math.min(min_move, (2*i)+len-next);
		}
		answer += min_move;
		
		return answer;
	}
}
