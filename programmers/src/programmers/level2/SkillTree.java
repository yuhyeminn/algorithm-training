package programmers.level2;

/**
 * 스킬트리
 * [문제]
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 * 
 * [참고]
 * https://moon1226.tistory.com/43
 */
public class SkillTree {

	public static void main(String[] args) {
		String skill = "CBD";
		String skill_trees[] = {"BACDE","CBADF","AECB","BDA"};
		System.out.println(solution(skill, skill_trees));
	}
	
	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;
		
		for(int i=0;i<skill_trees.length;i++) {
			boolean flag = true;
			int skindex = 0;
			String s = skill_trees[i];
			for(int j=0;j<s.length();j++) {
				if(skill.indexOf(s.charAt(j)) > -1) {
					if(skill.charAt(skindex) == s.charAt(j)) {
						skindex++;
					}else {
						flag = false;
						break;
					}
				}
			}
			if(flag) answer++;
		}
		
		return answer;
	}
}
