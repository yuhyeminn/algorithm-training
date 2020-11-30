package coding_test.nhn_godo;

public class Godo02 {

	public static void main(String[] args) {
		int page = 5457;
		int broken[] = { 6, 7, 8 };
		System.out.println("Result=" + solution(page, broken));
	}

	public static int solution(int page, int[] broken){
		//page가 100인 경우 return 0
		if(page == 100) return 0;
		
		int answer = Math.abs(page - 100);
		int btn[] = new int[10];
		for(int i=0;i<broken.length;i++) {
			btn[broken[i]] = -1;
		}
		
		for(int i = 0; i<500000; i++) {
			boolean flag = true;
			String num = String.valueOf(i);
			for(int j=0;j<num.length();j++) {
				//고장난 버튼 있을 경우 넘어감
				if(btn[num.charAt(j)-'0'] == -1) {
					flag = false;
					break;
				}
			}
			//고장난 버튼이 없을 경우
			//가까운 채널 찾기
			if(flag) {
				int x = Math.abs(i - page)+num.length();
				if(answer > x) {
					answer = x;
				}
			}
		}
		
		return answer;
    }

}
