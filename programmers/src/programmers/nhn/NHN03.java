package programmers.nhn;

public class NHN03 {

	public static void main(String[] args) {
		int numOfOrder = 2;
		String orderArr[] = {"B2(RG)", "3(R2(GB))"};
		solution(numOfOrder, orderArr);
	}
	
	private static void solution(int numOfOrder, String[] orderArr) {
		for(int i=0;i<numOfOrder;i++) {
			String order = orderArr[i];
			String result = getOrder(order);
//			System.out.println(result);
		}
	}
	
	private static String getOrder(String order) {
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<order.length();i++) {
			char ch = order.charAt(i);
			if(1 <= ch-'0' && ch-'0' <= 9) {
				String s = gg(order, i+1 , ch-'0');
				sb.append(s);
				System.out.println(sb.toString());
			}else {
				sb.append(ch);
			}
		}
		
		return sb.toString();
	}
	
	private static String gg(String s, int idx, int cnt) {
		StringBuilder tmp = new StringBuilder();
//		System.out.println("하이");
		if(idx == s.length()) {
			return tmp.toString();
		}
		while(true) {
			char c = s.charAt(idx);
//			System.out.println(c);
			if(c == '(') {
				//건너뜀
			}else if( c == ')') {
				String str = tmp.toString();
				for(int i=1;i<cnt;i++) {
					tmp.append(str);
				}
//				System.out.println(tmp.toString());
				return tmp.toString();
			}else if(1 <= c-'0' && c-'0' <= 9){
				//숫자일 경우 
				int num = c-'0';
				gg(s, idx+1 ,num);
			}else {
				tmp.append(c);
			}
			idx++;
		}
	}
}
