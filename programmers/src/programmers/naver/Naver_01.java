package programmers.naver;

public class Naver_01 {

	public static void main(String[] args) {
		String m = "acbbcdc";
		String k = "abc";
		System.out.println(solution(m,k));
	}

	public static String solution(String m, String k) {
		StringBuilder sb = new StringBuilder();
		char[] mArr = m.toCharArray();
		char[] kArr = k.toCharArray();
		int mIndex = 0;
		int kIndex = 0;
		
		while(kIndex < kArr.length) {
			if(mArr[mIndex] == kArr[kIndex]) {
				mArr[mIndex] = ' ';
				kIndex++;
			}
			mIndex++;
		}
		
		for(int i=0;i<mArr.length;i++) {
			if(mArr[i] != ' ') {
				sb.append(mArr[i]);
			}
		}
		return sb.toString();
	}
}
