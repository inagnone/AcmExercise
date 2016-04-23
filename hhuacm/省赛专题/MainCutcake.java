package 省赛专题;

import java.math.BigInteger;
import java.util.Scanner;

public class MainCutcake {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);		
		int T = scanner.nextInt();
		BigInteger M,N;
		while(T>0){
			M = new BigInteger(scanner.next());
			N = new BigInteger(scanner.next());
			BigInteger fenzi = M.multiply(N);
			BigInteger fenmu = M.pow(N.intValue());
			BigInteger gc = fenzi.gcd(fenmu);
			System.out.println(fenzi.divide(gc)+"/"+fenmu.divide(gc));
			
			T--;
		
		}
	}
}
