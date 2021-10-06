package programmers.cos_pro;

public class Java6_3 {
	public static int solution(int K, String[] words) {
		// 여기에 코드를 작성해주세요.
		// 첫번째 단어 입력
		int answer = 1;
		int space = K;
		for(int i=0;i<words.length;i++) {
			int len = words[i].length() + 1; // 공백 포함
			space -= len;
			// 마지막 단어의 공백 때문에 -1까지 한줄로 허용함
			if(space < -1) {
				answer ++;
				space = K - len;
			}
		}
		
		return answer;
	}

	// 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
	public static void main(String[] args) {
		int K = 10;
		String[] words = { new String("nice"), new String("happy"), new String("hello"), new String("world"),
				new String("hi") };
		int ret = solution(K, words);

		// [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
		System.out.println("solution 메소의 반환 값은 " + ret + " 입니다.");
	}
}
