package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * DNA
 * DNA란 어떤 유전물질을 구성하는 분자이다. 이 DNA는 서로 다른 4가지의 뉴클레오티드로 이루어져 있다(Adenine, Thymine, Guanine, Cytosine). 우리는 어떤 DNA의 물질을 표현할 때, 이 DNA를 이루는 뉴클레오티드의 첫글자를 따서 표현한다. 
 * 만약에 Thymine-Adenine-Adenine-Cytosine-Thymine-Guanine-Cytosine-Cytosine-Guanine-Adenine-Thymine로 이루어진 DNA가 있다고 하면, “TAACTGCCGAT”로 표현할 수 있다. 
 * 그리고 Hamming Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수이다. 만약에 “AGCAT"와 ”GGAAT"는 첫 번째 글자와 세 번째 글자가 다르므로 Hamming Distance는 2이다.
 * 우리가 할 일은 다음과 같다. n개의 길이가 같은 DNA가 주어져 있을 때(이 DNA를 a1a2a3a4...이라고 하자) Hamming Distance의 합이 가장 작은 DNA s를 구하는 것이다.
 * 즉, s와 a1의 Hamming Distance + s와 a2의 Hamming Distance + s와 a3의 Hamming Distance ... 의 합이 최소가 된다는 의미이다.
 * 
 * [입력]
 * 첫 줄에 DNA의 수 N과 문자열의 길이 M이 주어진다. 그리고 둘째 줄부터 N+1번째 줄까지 N개의 DNA가 주어진다. N은 1,000보다 작거나 같은 자연수이고, M은 50보다 작거나 같은 자연수이다.
 * 
 * [출력]
 * 첫째 줄에 Hamming Distance의 합이 가장 작은 DNA 를 출력하고, 둘째 줄에는 그 Hamming Distance의 합을 출력하시오. 그러한 DNA가 여러 개 있을 때에는 사전순으로 가장 앞서는 것을 출력한다.
 */
public class Greedy_1969_ver2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		String[] DNA = new String[N];
		int[] alpha = new int[26];
		
		int sum = 0;
		StringBuffer sb = new StringBuffer();
		
		for(int i = 0; i < N; i++)
			DNA[i] = br.readLine();
		
		for(int j = 0; j < M; j++){
			int max = 0;
			int index = -1;
			
			for(int i = 0; i < N; i++){
				alpha[DNA[i].charAt(j) - 'A']++;
			}
			
			for(int i = 0; i < 26; i++){
				if(max < alpha[i]){
					max = alpha[i];
					index = i;
				}
			}
			
			sb.append((char)(index + 'A'));
			sum = sum + N - max;
			Arrays.fill(alpha, 0);
		}
		
		System.out.println(sb.toString());
		System.out.println(sum);
	}
}
