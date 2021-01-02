package programmers.level3;


/**
 * 단어 변환
 * 
 * [문제]
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 
 * 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 *  	1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
 *  	2. words에 있는 단어로만 변환할 수 있습니다.
 * 예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.
 * 
 * 두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.
 * 
 * [제한 사항]
 * 각 단어는 알파벳 소문자로만 이루어져 있습니다.
 * 각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
 * words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
 * begin과 target은 같지 않습니다.
 * 변환할 수 없는 경우에는 0를 return 합니다.
 * 
 */
public class WordConversion {

	static int answer;
	static boolean visited[];
	public static int solution(String begin, String target, String[] words) {
        answer = words.length+1;
        visited = new boolean[words.length+1];
        
        dfs(begin, target, 0, words);
        
        if(answer == words.length+1) return 0;
        
        return answer;
    }
	
	// 1글자만 다른 다음 단어를 찾다가 target과 같아지는 경우 count 리턴
	public static void dfs(String begin, String target, int count, String[] words) {
		if(begin.equals(target)) {
			answer = (answer > count) ? count : answer;
//			answer = count;
			return;
		}
		
		for(int i=0;i<words.length;i++) {
			if(!visited[i] && check(begin, words[i])) {
				visited[i] = true;
				dfs(words[i], target, count+1, words);
				visited[i] = false;
			}
		}
	}
	
	//1번 조건 체크
	public static boolean check(String present, String next) {
		int count = 0;
		for(int i=0;i<present.length();i++) {
			if(present.charAt(i) != next.charAt(i)) {
				count++;
			}
			if(count > 1) return false;
		}
		return count==1?true:false;
	}
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};
		
		System.out.println(solution(begin,target,words));
	}
}
