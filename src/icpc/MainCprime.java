package icpc;

import java.util.Scanner;

public class MainCprime {
	private boolean prime(int n){
		    for(int i=2;i<n/2+1;++i)
		    { 
		        // 和比它的一半小数相除，如果都除不尽，证明素数
		        if ( 0 == n % i )
		        { 
		            // 除尽了，合数
		            return false;
		        }
		    }
		    return true; // 都没除尽，素数
		
	}
	
	 boolean isprime(int a,int b){
		if(a==1 || b== 1){
			return true;
		}
		if(a%2 ==0 && b%2 == 0){
			return false;
		}
		if(a>b){
			if(prime(a)){
				return true;
			}
			if(prime(b)){
				if(a%2 ==0 && a%b !=0){
					return true;
				}
			}
			int n = a%b;
			if(n == 1){
				return true;
			}else if(n == 0){
				return false;
			}else{
				return isprime(b, n);
			}
		}else{
			if(prime(a)){
				if(b%2 ==0 && b%a !=0){
					return true;
				}
			}
			if(prime(b)){
				return true;
			}
			int n = b%a;
			if(n == 1){
				return true;
			}else if(n == 0){
				return false;
			}else{
				return isprime(a, n);
			}
		}
	}
	public static void main(String[] args) {
		MainCprime demo = new MainCprime();
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int a,b,n,count;
		while(T>0){
			a = scanner.nextInt();
			b = scanner.nextInt();
			n = scanner.nextInt();
			count = 0;
			for(int i=a;i<=b;i++){
				if(i == n){
					continue;
				}
				if(demo.isprime(i, n)){
					count++;
				}
			}
			System.out.println(count);
			T--;
		}
	}
}
