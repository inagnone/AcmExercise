package 省赛专题;

import java.util.Scanner;

public class MainHardcode {
public static void main(String[] args) {
	Scanner scanner =  new Scanner(System.in);
	
	int T = scanner.nextInt();
	int N,M;
	char[][] grid;
	while(T>0){
		N = scanner.nextInt();
		M = scanner.nextInt();
		String str = scanner.next();
		grid = new char[N][M];
		int at = 0;
		for(int i=0;i<N;i++){
			System.out.println(str.substring(i*M, i*M+M));
		}

		T--;
	}
}
}
