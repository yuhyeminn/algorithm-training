package coding_test.nhn_godo;

public class Godo01 {

	public static void main(String[] args) {

	}

	public static int solution(int[] goods){
		int answer = 0;
		
		int sum = 0;
		for(int i=0;i<goods.length;i++) {
			if(goods[i] < 50) {
				sum += goods[i];
			}else {
				answer += (goods[i] - 10);
			}
		}
		
		if(sum >= 50) {
			answer += (sum - 10);
		}else {
			answer += sum;
		}
        return answer;
    }
}
