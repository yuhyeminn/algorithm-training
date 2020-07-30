package programmers.level1;

/**
 * 키패드 누르기(2020 카카오 인턴쉽)
 * https://programmers.co.kr/learn/courses/30/lessons/67256
 *
 * 1. 엄지손가락은 상하좌우 4가지 방향으로만 이동할 수 있으며 키패드 이동 한 칸은 거리로 1에 해당합니다.
 * 2. 왼쪽 열의 3개의 숫자 1, 4, 7을 입력할 때는 왼손 엄지손가락을 사용합니다.
 * 3. 오른쪽 열의 3개의 숫자 3, 6, 9를 입력할 때는 오른손 엄지손가락을 사용합니다.
 * 4. 가운데 열의 4개의 숫자 2, 5, 8, 0을 입력할 때는 두 엄지손가락의 현재 키패드의 위치에서 더 가까운 엄지손가락을 사용합니다.
 *  4-1. 만약 두 엄지손가락의 거리가 같다면, 오른손잡이는 오른손 엄지손가락, 왼손잡이는 왼손 엄지손가락을 사용합니다.
 */
public class KeyPad {

	public static void main(String[] args) {
		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
		String hand = "left";
		System.out.println("result=" + KeyPad.solution(numbers, hand));
	}
	
	/* 
	 * 만약 키패드들의 위치가 달라진다면..? 다시 풀어 볼 문제.. 좌표를 이용해 풀어보자.. 
	 * https://tech.kakao.com/2020/07/01/2020-internship-test/
	 * 카카오 공식 해설 보고 다시 풀어 볼 것.
	 * */
	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int r = 10;
		int l = 12;
		
		for(int i=0;i<numbers.length;i++) {
			int target = numbers[i];
			if(target == 1 || target == 4 || target == 7) {
				sb.append("L");
				l = target;
			}else if(target == 3 || target == 6 || target == 9) {
				sb.append("R");
				r = target;
			}else {
				int rDistance = getDistance(r, target); 
				int lDistance = getDistance(l, target); 
//				System.out.println("rd="+rDistance +", ld="+lDistance + " target="+target);
				if(rDistance < lDistance) {
					sb.append("R");
					r = target;
				}else if(lDistance < rDistance) {
					sb.append("L");
					l = target;
				}else {
					if("right".equals(hand)) {
						sb.append("R");
						r = target;
					}else {
						sb.append("L");
						l = target;
					}
				}
			}
//			System.out.println("L="+l +", R="+r +" 	sb="+sb);
		}
		return sb.toString();
	}
	
	public static int getDistance(int hand, int target) {
		
		if(target == 0) target = 11;
		if(hand == 0) hand = 11;
		
		return Math.abs(hand - target)/3 + Math.abs(hand-target)%3;
	}
}
