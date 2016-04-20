package icpc;

import java.util.ArrayList;
import java.util.Scanner;

public class MainCprime {
	/**
	 * 求n的所有素数因子
	 * @param n
	 * @return
	 * 从最小的素数开始，不断除n并把结果赋给n，直到n也是一个素数
	 */
	static ArrayList<Integer> prime_decomposition(int n){
		ArrayList<Integer> primes = new ArrayList<>();
		for(int i=2;i*i<=n;i++){
			if(n%i == 0){
				primes.add(i);
				while(n%i == 0){
					n /=i;
				}
			}
		}
		if(n>1){
			primes.add(n);
		}
		return primes;
	}
	
	static int rongchi(ArrayList<Integer> prime,int n){
		int sum = 0,j,flag,temp;
		for(int i=1;i<(1<<prime.size());i++){
			temp = 1;
			flag = 0;
			for(j=0;j<prime.size();j++){
				if((i & (1<<j)) != 0){
					flag++;
					temp *= prime.get(j);
				}
			}
			if(flag % 2 ==0){
				sum -= n/temp;
			}else{
				sum += n/temp;
			}
		}
		return n-sum;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		int a,b,n;
		while(T>0){
			a = scanner.nextInt();
			b = scanner.nextInt();
			n = scanner.nextInt();
			
			int sum = 0;
			ArrayList<Integer> primes = prime_decomposition(n);
			int result1 = rongchi(primes, b);
			int result2 = rongchi(primes, a-1);
			
			System.out.println(result1-result2);
			
			T--;
		}
	}
}
