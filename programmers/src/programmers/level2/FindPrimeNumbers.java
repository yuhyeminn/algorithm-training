package programmers.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 소수 찾기
 * [문제]
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 * 
 * [제한사항]
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 
 * [참고]
 * https://hak0205.tistory.com/10
 */
public class FindPrimeNumbers {

	static boolean[] primeArr = new boolean[10000000];
	static Set<Integer> set;
	public static void main(String[] args) {
		String numbers = "011";
		System.out.println(solution(numbers));
	}
	
	public static int solution(String numbers) {
		set = new HashSet<>();
		
		//에라토스테네스의 체 이용하여 primeArr 셋팅
		Arrays.fill(primeArr, true);
		primeArr[0] = primeArr[1] = false;
		setPrimeArr();
		
		permutation("", numbers); //순열로 숫자 조합
		int count = 0;
		while(set.iterator().hasNext()) {
			int a = set.iterator().next();
			set.remove(a);
			if(primeArr[a]) count++;
		}
		return count;
	}
	
	//순열을 이용한 숫자 조합 만들기 (아직 이해 못함)
	public static void permutation(String prefix, String str) {
		int n = str.length();
		if(!prefix.equals("")) {
			set.add(Integer.valueOf(prefix)); //String을 Integer로 변환하여 add
		}
		for(int i=0; i<n;i++) {
			permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
		}
	}
	
	//에라토스테네스의 체
	public static void setPrimeArr() {
		for(int i=2;i<primeArr.length;i++) {
			if(!primeArr[i]) continue;
			for(int j = i + i; j < primeArr.length; j += i) {
				primeArr[j] = false;
			}
		}
	}
}
